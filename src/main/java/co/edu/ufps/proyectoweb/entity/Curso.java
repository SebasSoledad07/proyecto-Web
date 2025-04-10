package co.edu.ufps.proyectoweb.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    @OneToMany(mappedBy = "curso")
    private List<Inscripcion> inscripciones;

    @OneToMany(mappedBy = "curso")
    private List<Evaluacion> evaluaciones;

    @OneToMany(mappedBy = "curso")
    private List<Tarea> tareas;

    @OneToMany(mappedBy = "curso")
    private List<Asistencia> asistencias;

    @OneToMany(mappedBy = "curso")
    private List<RecursoMultimedia> recursos;

    @OneToMany(mappedBy = "curso")
    private List<Horario> horarios;

    @OneToMany(mappedBy = "curso")
    private List<CursoAula> cursoAulas;

    @OneToMany(mappedBy = "curso")
    private List<Material> materiales;

    @OneToMany(mappedBy = "curso")
    private List<EstudianteCursoEvaluacion> estudianteCursoEvaluaciones;

    @OneToMany(mappedBy = "curso")
    private List<HistorialAcademico> historialAcademico;

    @OneToMany(mappedBy = "curso")
    private List<ObjetivoCurso> objetivos;

    @OneToMany(mappedBy = "curso")
    private List<CalendarioEvento> eventos;
}

