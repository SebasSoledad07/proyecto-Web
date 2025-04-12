package co.edu.ufps.proyectoweb.service;
import co.edu.ufps.proyectoweb.entity.Matricula;
import co.edu.ufps.proyectoweb.repository.MatriculaRepository;

import java.util.List;
import java.util.Optional;

public class MatriculaService {
    private MatriculaRepository matriculaRepository;

    public Matricula guardarMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

       public Matricula actualizarMatricula(Long id, Matricula matricula) {
        if (!matriculaRepository.existsById(id)) {
            throw new RuntimeException("La matrícula no existe con id: " + id);
        }
        matricula.setId(id);
        return matriculaRepository.save(matricula);
    }


    public void eliminarMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }


    public Optional<Matricula> obtenerMatriculaPorId(Long id) {
        return matriculaRepository.findById(id);
    }

    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }


}
