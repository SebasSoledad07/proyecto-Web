package co.edu.ufps.proyectoweb.entity;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "horarios")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private String diaSemana;
    private java.time.LocalTime horaInicio;
    private java.time.LocalTime horaFin;
}