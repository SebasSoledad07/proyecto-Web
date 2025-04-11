package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.dto.matriculadto.MatriculaRequestDTO;
import co.edu.ufps.proyectoweb.dto.matriculadto.MatriculaResponseDTO;
import co.edu.ufps.proyectoweb.dto.matriculadto.MatriculaMapper;
import co.edu.ufps.proyectoweb.entity.Matricula;
import co.edu.ufps.proyectoweb.repository.MatriculaRepository;

import java.util.List;
import java.util.Optional;

public class MatriculaService {
    private MatriculaRepository matriculaRepository;
    private final MatriculaMapper mapper;

    public MatriculaService(MatriculaMapper mapper) {
        this.mapper = mapper;
    }


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
    public MatriculaResponseDTO guardarMatricula(MatriculaRequestDTO dto) {
        if (dto.getEstudianteId() == null || dto.getCursoId() == null) {
            throw new IllegalArgumentException("El ID del estudiante y del curso son obligatorios.");
        }

        Matricula matricula = mapper.toEntity(dto);
        Matricula guardada = matriculaRepository.save(matricula);
        return mapper.toDTO(guardada);
    }

}
