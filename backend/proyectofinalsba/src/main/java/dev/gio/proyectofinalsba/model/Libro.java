package dev.gio.proyectofinalsba.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlibro")
    private Integer id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String slug;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String rutaPortada;

    @NotNull
    private Float precio;
    @NotBlank
    private String rutaArchivo;

    private LocalDateTime fechaCreacion;
    @Transient
    private String urlPortada;
    @Transient
    private String urlArchivo;


    @PrePersist
    private  void prePersist(){
        fechaCreacion = LocalDateTime.now();
    }
}
