package dev.gio.demosesionsb02.controller;

import dev.gio.demosesionsb02.model.Libro;
import dev.gio.demosesionsb02.repo.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/libros")
    List<Libro> getLibros(){
        return libroRepository.findAll();
    }
    @PostMapping("/libros")
    Libro crearLibro(@RequestBody @Validated Libro libro){
        return libroRepository.save(libro);
    }

    @PutMapping("/libros/{id}")
    Libro actualizarLibro(@PathVariable Integer id,@RequestBody  Libro libro){
        Libro libroForm = libroRepository.getById(id);
        libro.setId(libroForm.getId());

        libroRepository.save(libro);
        return libro;
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/libros/{id}")
    void eleiminarLibro(@PathVariable Integer id){
        Libro libroAEliminar = libroRepository.getById(id);
        libroRepository.delete(libroAEliminar);
    }
}
