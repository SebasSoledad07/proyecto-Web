package co.edu.ufps.proyectoweb.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "estudiantes")
public class Estudiante extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Column(unique = true)
    private String email;

    private LocalDate fechaNacimiento;
    private String direccion;

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
