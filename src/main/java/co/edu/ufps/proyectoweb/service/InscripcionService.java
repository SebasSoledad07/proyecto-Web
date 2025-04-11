package co.edu.ufps.proyectoweb.service;
import co.edu.ufps.proyectoweb.dto.inscripciondto.InscripcionDTO;
import co.edu.ufps.proyectoweb.entity.Curso;
import co.edu.ufps.proyectoweb.entity.Estudiante;
import co.edu.ufps.proyectoweb.entity.Inscripcion;
import co.edu.ufps.proyectoweb.repository.CursoRepository;
import co.edu.ufps.proyectoweb.repository.EstudianteRepository;
import co.edu.ufps.proyectoweb.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Inscripcion> findAllInscripciones() {
        return inscripcionRepository.findAll();
    }

    public List<Inscripcion> findInscripcionesByEstudiante(Long estudianteId) {
        return inscripcionRepository.findByEstudianteId(estudianteId);
    }

    public List<Inscripcion> findInscripcionesByCurso(Long cursoId) {
        return inscripcionRepository.findByCursoId(cursoId);
    }

    @Transactional
    public Inscripcion inscribirEstudiante(Long estudianteId, Long cursoId) {
        if (inscripcionRepository.existsByEstudianteIdAndCursoId(estudianteId, cursoId)) {
            throw new RuntimeException("El estudiante ya está inscrito en este curso");
        }

        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudiante(estudiante);
        inscripcion.setCurso(curso);
        inscripcion.setFechaInscripcion(LocalDate.now());

        return inscripcionRepository.save(inscripcion);
    }

    public void deleteInscripcion(Long id) {
        inscripcionRepository.deleteById(id);
    }

    private InscripcionDTO convertirADTO(Inscripcion inscripcion) {
        return InscripcionDTO.builder()
                .id(inscripcion.getId())
                .fechaInscripcion(inscripcion.getFechaInscripcion().toString())
                .estudianteId(inscripcion.getEstudiante().getId())
                .cursoId(inscripcion.getCurso().getId())
                .inscrito(inscripcion.getInscrito())
                .build();
    }
}

