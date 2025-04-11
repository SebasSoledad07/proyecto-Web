package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.entity.Profesor;
import co.edu.ufps.proyectoweb.repository.ProfesorRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class ProfesorService {
    private ProfesorRepository profesorRepository;


    public Profesor guardar(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Optional<Profesor> obtenerPorId(Long id) {
        return profesorRepository.findById(id);
    }


    public List<Profesor> obtenerTodos() {
        return profesorRepository.findAll();
    }

    @Transactional
    public Profesor actualizar(Long id, Profesor profesorActualizado) {
        return profesorRepository.findById(id)
                .map(p -> {
                    p.setNombre(profesorActualizado.getNombre());
                    p.setApellido(profesorActualizado.getApellido());
                    p.setEmail(profesorActualizado.getEmail());
                    return profesorRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));
    }

    public void eliminar(Long id) {
        profesorRepository.deleteById(id);
    }
}
