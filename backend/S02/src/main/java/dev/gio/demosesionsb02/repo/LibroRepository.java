package dev.gio.demosesionsb02.repo;

import dev.gio.demosesionsb02.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
