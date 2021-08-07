package dev.gio.demosesionsb01.controller;

import dev.gio.demosesionsb01.model.Libro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    private final static List<Libro> LIBROS = new ArrayList<>();

    static {
        LIBROS.add(new Libro(1,"Python", LocalDate.now().plusDays(45)));
        LIBROS.add(new Libro(2,"Python", LocalDate.of(2020,12,01)));
        LIBROS.add(new Libro(3,"Python", LocalDate.now()));
    }

    @GetMapping("")
    String holaMundo(@RequestParam(defaultValue = "Mundo") String name){
        return "Hola "+ name+"!";
    }

    @GetMapping("/libros")
    List<Libro> getLibros(){
        return LIBROS;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/libros")
    Libro createLibros(@RequestBody Libro libro){
        LIBROS.add(libro);
        return libro;
    }

    @PutMapping("/libros/{id}")
    Libro updateLibros(@PathVariable Integer id,  @RequestBody Libro libroForm){
        Libro libro = LIBROS.stream().filter(l->l.getId().equals(id)).findFirst().get();
        libro.setTitulo(libroForm.getTitulo());
        libro.setFechaCreacion(libroForm.getFechaCreacion());
        return libroForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/libros/{id}")
    void deleteLibros(@PathVariable Integer id){
        LIBROS.removeIf(l->l.getId().equals(id));
    }

}
