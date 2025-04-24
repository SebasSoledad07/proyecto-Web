package co.edu.ufps.proyectoweb.entity;
import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private String descripcion;

    @OneToMany(mappedBy = "rol")
    private List<AsignacionRol> asignaciones;

    @OneToMany(mappedBy = "rol")
    private List<RolPermiso> permisos;
}