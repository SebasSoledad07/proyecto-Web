package co.edu.ufps.proyectoweb.entity;


import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "evaluaciones")
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private String titulo;
    private String descripcion;
    private LocalDate fecha;

    @OneToMany(mappedBy = "evaluacion")
    private List<EvaluacionEstudiante> evaluacionesEstudiantes;

    @OneToMany(mappedBy = "evaluacion")
    private List<EstudianteCursoEvaluacion> estudianteCursoEvaluaciones;
}
