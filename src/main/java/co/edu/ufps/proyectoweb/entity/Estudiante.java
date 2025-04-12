package co.edu.ufps.proyectoweb.entity;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@DiscriminatorValue("ESTUDIANTE")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Estudiante extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String programa;
    @OneToMany(mappedBy = "estudiante")
    private List<Inscripcion> inscripciones;

    @OneToMany(mappedBy = "estudiante")
    private List<Asistencia> asistencias;

    @OneToMany(mappedBy = "estudiante")
    private List<EvaluacionEstudiante> evaluaciones;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteCursoEvaluacion> estudianteCursoEvaluaciones;

    @OneToMany(mappedBy = "estudiante")
    private List<HistorialAcademico> historialAcademico;
}
