package dev.gio.proyectofinalsba.repo;

import dev.gio.proyectofinalsba.model.Libro;
import dev.gio.proyectofinalsba.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String mail);

    //@Query(value = "select * from usuario where mail = :name", nativeQuery = true)
    //boolean existePorCorreo(@Param(":name") String Email);
}
