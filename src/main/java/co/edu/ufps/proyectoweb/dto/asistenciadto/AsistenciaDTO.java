package co.edu.ufps.proyectoweb.dto.asistenciadto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsistenciaDTO {
    private Long id;
    private String fecha;
    private Boolean presente;
    private Long estudianteId;
    private Long cursoId;
}
