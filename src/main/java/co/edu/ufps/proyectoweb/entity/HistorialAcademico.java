package co.edu.ufps.proyectoweb.entity;
import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "historial_academico")
public class HistorialAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @Column(nullable = false)
    private Double calificacion;

    @Column(nullable = false)
    private String estado; // APROBADO, REPROBADO, EN_PROGRESO

    @Column(nullable = false)
    private String periodo;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @Column
    private String observaciones;
}
