package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.entity.Asistencia;

import co.edu.ufps.proyectoweb.repository.AsistenciaRepository;
import co.edu.ufps.proyectoweb.repository.HistorialAcademicoRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AsistenciaServiceImpl implements AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;
    private final HistorialAcademicoRepository historialAcademicoRepository;

    @Override
    public Asistencia guardar(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }


    public Optional<Asistencia> obtenerPorId(Long id) {
        return asistenciaRepository.findById(id);
    }

    public List<Asistencia> obtenerTodas() {
        return asistenciaRepository.findAll();
    }

    public List<Asistencia> listarPorEstudiante(Long estudianteId) {
        return asistenciaRepository.findByEstudianteId(estudianteId);
    }


    public List<Asistencia> listarPorCursoYFecha(Long cursoId, LocalDate fecha) {
        return asistenciaRepository.findByCursoIdAndFecha(cursoId, fecha);
    }

    List<Asistencia> findByEstudianteIdAndCursoId(Long estudianteId, Long cursoId){
        return asistenciaRepository.findByEstudianteIdAndCursoId(estudianteId,cursoId);
    }

    public void eliminar(Long id) {
        asistenciaRepository.deleteById(id);
    }
    public boolean existeHistorial(Long estudianteId, Long cursoId) {
        return asistenciaRepository.existeHistorial(estudianteId, cursoId);
    }
}




