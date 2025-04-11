package co.edu.ufps.proyectoweb.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "inscripciones")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDate fechaInscripcion;
    private Boolean inscrito;
}
