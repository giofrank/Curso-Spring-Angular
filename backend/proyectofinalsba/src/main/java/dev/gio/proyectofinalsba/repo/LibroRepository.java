package dev.gio.proyectofinalsba.repo;

import dev.gio.proyectofinalsba.model.Libro;
import dev.gio.proyectofinalsba.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    boolean existsBySlug(String slug);

    Optional<Libro> findOneBySlug(String slug);

    boolean existsBySlugAndIdNot(String slug, Integer idNot);
}
