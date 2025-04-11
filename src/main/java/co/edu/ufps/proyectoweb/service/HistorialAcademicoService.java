package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.entity.HistorialAcademico;
import co.edu.ufps.proyectoweb.repository.HistorialAcademicoRepository;

import java.util.List;
import java.util.Optional;

public class HistorialAcademicoService {
    private HistorialAcademicoRepository repository;

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
    
}
