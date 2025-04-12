package co.edu.ufps.proyectoweb.service;
import co.edu.ufps.proyectoweb.entity.Asistencia;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AsistenciaService {
    Asistencia guardar(Asistencia asistencia);
    Optional<Asistencia> obtenerPorId(Long id);
    List<Asistencia> obtenerTodas();
    List<Asistencia> listarPorEstudiante(Long estudianteId);
    List<Asistencia> listarPorCursoYFecha(Long cursoId, LocalDate fecha);
    void eliminar(Long id);
    boolean existeHistorial(Long estudianteId, Long cursoId);

}
