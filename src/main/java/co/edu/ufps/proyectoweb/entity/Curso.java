package co.edu.ufps.proyectoweb.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private Integer creditos;

    @Column(nullable = false)
    private Integer cupoMaximo;

    @Column(nullable = false)
    private Integer cupoActual;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String objetivos;

    @Column(nullable = false)
    private String competencias;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToMany
    @JoinTable(
            name = "curso_estudiante",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private Set<Estudiante> estudiantes;

    @ManyToMany
    @JoinTable(
            name = "curso_prerrequisito",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "prerrequisito_id")
    )
    private Set<Curso> prerrequisitos;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private Set<Horario> horarios;
}

