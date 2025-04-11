package co.edu.ufps.proyectoweb.dto.inscripciondto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InscripcionDTO {
    private Long id;
    private String fechaInscripcion;
    private Long estudianteId;
    private Long cursoId;
    private Boolean inscrito;

}