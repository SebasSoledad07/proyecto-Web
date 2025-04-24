package co.edu.ufps.proyectoweb.entity;


import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "evaluacion")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesor profesor;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipo; // EXAMEN, TAREA, PROYECTO, QUIZ

    @Column(nullable = false)
    private Double porcentaje;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @Column
    private String descripcion;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "evaluacion", cascade = CascadeType.ALL)
    private Set<Calificacion> calificaciones;
}
