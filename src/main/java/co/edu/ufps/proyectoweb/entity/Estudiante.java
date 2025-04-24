package co.edu.ufps.proyectoweb.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Data
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String semestre;


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
