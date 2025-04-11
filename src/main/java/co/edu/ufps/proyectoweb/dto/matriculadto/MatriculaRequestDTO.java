package co.edu.ufps.proyectoweb.dto.matriculadto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatriculaRequestDTO {
    private String periodo;
    private LocalDate fechaRegistro;
    private Long estudianteId;
    private Long cursoId;
}
