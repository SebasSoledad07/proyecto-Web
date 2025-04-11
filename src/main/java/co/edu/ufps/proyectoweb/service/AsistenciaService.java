package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.dto.asistenciadto.AsistenciaDTO;
import co.edu.ufps.proyectoweb.entity.Asistencia;
import co.edu.ufps.proyectoweb.entity.Curso;
import co.edu.ufps.proyectoweb.entity.Estudiante;
import co.edu.ufps.proyectoweb.repository.AsistenciaRepository;
import co.edu.ufps.proyectoweb.repository.CursoRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository repository;

    public Asistencia registarAsistencia(Asistencia asistencia) {
        return repository.save(asistencia);
    }
    public List<AsistenciaDTO> listarPorEstudiante(Long estudianteId) {
        return repository.findByEstudianteId(estudianteId).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public AsistenciaDTO registrar(Asistencia asistencia) {
        return convertirADTO(repository.save(asistencia));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    private AsistenciaDTO convertirADTO(Asistencia asistencia) {
        return AsistenciaDTO.builder()
                .id(asistencia.getId())
                .fecha(asistencia.getFecha().toString())
                .presente(asistencia.getPresente())
                .estudianteId(asistencia.getEstudiante().getId())
                .cursoId(asistencia.getCurso().getId())
                .build();
    }

}



