package co.edu.ufps.proyectoweb.dto.matriculadto;

import co.edu.ufps.proyectoweb.entity.Curso;
import co.edu.ufps.proyectoweb.entity.Estudiante;
import co.edu.ufps.proyectoweb.entity.Matricula;
import co.edu.ufps.proyectoweb.repository.CursoRepository;
import co.edu.ufps.proyectoweb.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatriculaMapper {

    private EstudianteRepository estudianteRepository;
    private CursoRepository cursoRepository;


    public Matricula toEntity(MatriculaRequestDTO dto) {
        Matricula matricula = new Matricula();
        matricula.setFechaMatricula(dto.getFechaRegistro());

        Estudiante estudiante = estudianteRepository.findById(dto.getEstudianteId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        matricula.setEstudiante(estudiante);
        matricula.setCurso(curso);
        return matricula;
    }

    public MatriculaResponseDTO toDTO(Matricula matricula) {
        MatriculaResponseDTO dto = new MatriculaResponseDTO();
        dto.setId(matricula.getId());
        dto.setFechaRegistro(matricula.getFechaMatricula());
        dto.setNombreEstudiante(matricula.getEstudiante().getNombre());
        dto.setNombreCurso(matricula.getCurso().getNombre());
        return dto;
    }
}

