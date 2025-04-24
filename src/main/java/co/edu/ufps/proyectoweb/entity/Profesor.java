package co.edu.ufps.proyectoweb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String especialidad;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Evaluacion> evaluaciones;

}
