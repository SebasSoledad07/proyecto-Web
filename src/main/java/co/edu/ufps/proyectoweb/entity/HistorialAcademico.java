package co.edu.ufps.proyectoweb.entity;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "historial_academico")
public class HistorialAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private Double calificacionFinal;
    private Boolean aprobado;
    private String periodo;
}
