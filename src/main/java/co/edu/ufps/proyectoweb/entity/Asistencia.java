package co.edu.ufps.proyectoweb.entity;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "asistencias")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDate fecha;
    private Boolean presente;
}
