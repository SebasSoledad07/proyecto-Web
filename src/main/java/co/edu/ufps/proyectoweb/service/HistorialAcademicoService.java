package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.entity.HistorialAcademico;
import co.edu.ufps.proyectoweb.repository.HistorialAcademicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialAcademicoService {
    private HistorialAcademicoRepository repository;

    public HistorialAcademicoService(HistorialAcademicoRepository repository) {
        this.repository = repository;
    }

    public List<HistorialAcademico> obtenerPorEstudiante(Long estudianteId) {
        return repository.findByEstudianteId(estudianteId);
    }

    public Optional<HistorialAcademico> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public HistorialAcademico registrar(HistorialAcademico historial) {
        return repository.save(historial);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public HistorialAcademico actualizar(HistorialAcademico historial) {
        return repository.save(historial);
    }

    public boolean existeHistorial(Long estudianteId, Long cursoId) {
        return repository.existsByEstudianteIdAndCursoId(estudianteId, cursoId);
    }
    public Double calcularPromedio(Long estudianteId) {
        return repository.calcularPromedioPorEstudiante(estudianteId);
    }

    public List<HistorialAcademico> obtenerAprobadosPorEstudiante(Long estudianteId) {
        return repository.findByEstudianteIdAndAprobadoTrue(estudianteId);
    }

}
