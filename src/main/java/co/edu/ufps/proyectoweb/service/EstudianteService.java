package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.entity.Estudiante;
import co.edu.ufps.proyectoweb.repository.EstudianteRepository;
import co.edu.ufps.proyectoweb.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }
    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }


    @Transactional(readOnly = true)
    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudianteRepository.findById(id);
    }


    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }


    public Estudiante actualizar(Long id, Estudiante estudianteActualizado) {
        return estudianteRepository.findById(id)
                .map(e -> {
                    e.setId(estudianteActualizado.getId());
                    e.setNombre(estudianteActualizado.getNombre());
                    e.setApellido(estudianteActualizado.getApellido());
                    e.setEmail(estudianteActualizado.getEmail());
                    return estudianteRepository.save(e);
                })
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));
    }


    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }
}
