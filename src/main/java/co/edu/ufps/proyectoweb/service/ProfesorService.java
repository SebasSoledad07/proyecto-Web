package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.entity.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    List<Profesor> getAllProfesores();
    Profesor getProfesorById(Long id);
    Profesor createProfesor(Profesor profesor);
    Profesor updateProfesor(Long id, Profesor profesor);
    void deleteProfesor(Long id);
    Profesor findByCodigo(String codigo);
    Profesor findByEmail(String email);
}
