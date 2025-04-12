package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.entity.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    Profesor guardarProfesor(Profesor profesor);
    Optional<Profesor> obtenerProfesorPorId(Long id);
    List<Profesor> obtenerTodosLosProfesores();
    Profesor actualizarProfesor(Long id, Profesor profesorActualizado);
    void eliminarProfesor(Long id);
}
