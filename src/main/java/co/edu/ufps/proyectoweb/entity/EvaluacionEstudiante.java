package co.edu.ufps.proyectoweb.entity;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "evaluaciones_estudiantes")
public class EvaluacionEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id")
    private Evaluacion evaluacion;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    private Double nota;

}
