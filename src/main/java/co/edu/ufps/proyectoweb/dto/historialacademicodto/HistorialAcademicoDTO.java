package co.edu.ufps.proyectoweb.dto.historialacademicodto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistorialAcademicoDTO {
    private String nombreCurso;
    private Double calificacion;
    private String estado;
    private String periodo;
}
