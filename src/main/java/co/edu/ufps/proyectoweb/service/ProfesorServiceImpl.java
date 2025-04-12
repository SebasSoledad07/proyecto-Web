package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.entity.Profesor;
import co.edu.ufps.proyectoweb.repository.ProfesorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfesorServiceImpl implements ProfesorService{

    private final ProfesorRepository profesorRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
         this.profesorRepository = profesorRepository;
    }

    @Override
    public Profesor guardarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Transactional(readOnly = true)
    public Optional<Profesor> obtenerProfesorPorId(Long id) {
        return profesorRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Profesor> obtenerTodosLosProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor actualizarProfesor(Long id, @org.jetbrains.annotations.NotNull Profesor profesorActualizado) {
        Profesor profesorExistente = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));

        profesorExistente.setNombre(profesorActualizado.getNombre());
        profesorExistente.setApellido(profesorActualizado.getApellido());
        profesorExistente.setEmail(profesorActualizado.getEmail());

        return profesorRepository.save(profesorExistente);
    }

    @Override
    public void eliminarProfesor(Long id) {
        if (!profesorRepository.existsById(id)) {
            throw new RuntimeException("Profesor no encontrado con ID: " + id);
        }
        profesorRepository.deleteById(id);
    }
}
