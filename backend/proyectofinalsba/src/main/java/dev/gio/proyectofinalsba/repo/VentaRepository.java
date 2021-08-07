package dev.gio.proyectofinalsba.repo;

import dev.gio.proyectofinalsba.model.Libro;
import dev.gio.proyectofinalsba.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
}
