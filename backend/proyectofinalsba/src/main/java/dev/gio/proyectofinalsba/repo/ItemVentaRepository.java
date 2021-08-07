package dev.gio.proyectofinalsba.repo;

import dev.gio.proyectofinalsba.model.ItemVenta;
import dev.gio.proyectofinalsba.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemVentaRepository extends JpaRepository<ItemVenta, Integer> {
}
