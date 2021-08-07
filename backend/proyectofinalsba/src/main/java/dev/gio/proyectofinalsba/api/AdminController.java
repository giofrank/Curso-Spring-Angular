package dev.gio.proyectofinalsba.api;

import dev.gio.proyectofinalsba.exception.BadRequestException;
import dev.gio.proyectofinalsba.model.Libro;
import dev.gio.proyectofinalsba.repo.LibroRepository;
import dev.gio.proyectofinalsba.service.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/libros")
public class AdminController extends BaseController{

    @Autowired
    private LibroRepository libroRepository;


    @Autowired
    private FileSystemStorageService fileSystemStorageService;


    @GetMapping("")
    Page<Libro> getLibros(@PageableDefault(sort = "titulo", size = 5) Pageable pageable){
        Page<Libro> libroPage = libroRepository.findAll(pageable);

        libroPage.forEach(libro -> {
            libro.setUrlArchivo(buildUriString(libro.getRutaArchivo()));
            libro.setUrlPortada(buildUriString(libro.getRutaPortada()));
        });
        return libroPage;
    }

    @PostMapping("")
    Libro crearLibro(@RequestBody @Validated Libro libro){

        boolean slugYaExiste = libroRepository.existsBySlug(libro.getSlug());

        if(slugYaExiste){
            throw  new BadRequestException("El slug  ya fue registrado");
        }
        return  libroRepository.save(libro);
    }


    @GetMapping("/{id}")
    Libro getLibro(@PathVariable Integer id){
        Libro libro =  libroRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        libro.setUrlArchivo(buildUriString(libro.getRutaArchivo()));
        libro.setUrlPortada(buildUriString(libro.getRutaPortada()));

        return libro;

    }


    @PutMapping("/{id}")

    Libro actualizarLibro(@PathVariable Integer id, @RequestBody @Validated Libro libro){
        Libro librofrom = libroRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        boolean slugYaExiste = libroRepository.existsBySlugAndIdNot(libro.getSlug(), id);

        if(slugYaExiste){
            throw new BadRequestException("El Slug ya fue registrado");

        }

        //libro.setId(id);
        librofrom.setPrecio(libro.getPrecio());
        librofrom.setDescripcion(libro.getDescripcion());
        librofrom.setRutaArchivo(libro.getRutaArchivo());
        librofrom.setRutaPortada(libro.getRutaPortada());
        librofrom.setSlug(libro.getSlug());
        librofrom.setTitulo(libro.getTitulo());
        return libroRepository.save(librofrom);

    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eleiminarLibro(@PathVariable Integer id){
        Libro libro = libroRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        libroRepository.delete(libro);
    }
}
