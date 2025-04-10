package co.edu.ufps.proyectoweb.entity;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "estudiante_curso_evaluaciones")
public class EstudianteCursoEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id")
    private Evaluacion evaluacion;

    private Double nota;
}
