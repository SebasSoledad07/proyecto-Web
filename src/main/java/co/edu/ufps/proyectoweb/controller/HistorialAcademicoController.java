package co.edu.ufps.proyectoweb.controller;
import co.edu.ufps.proyectoweb.entity.HistorialAcademico;
import co.edu.ufps.proyectoweb.service.HistorialAcademicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/historiales")
public class HistorialAcademicoController {
    private  HistorialAcademicoService historialAcademicoService;

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<List<HistorialAcademico>> listarPorEstudiante(@PathVariable Long id) {
        return ResponseEntity.ok(historialAcademicoService.obtenerPorEstudiante(id));
    }

    @GetMapping("/estudiante/{id}/aprobados")
    public ResponseEntity<List<HistorialAcademico>> listarAprobados(@PathVariable Long id) {
        return ResponseEntity.ok(historialAcademicoService.obtenerAprobadosPorEstudiante(id));
    }

    @GetMapping("/estudiante/{id}/promedio")
    public ResponseEntity<Double> obtenerPromedio(@PathVariable Long id) {
        return ResponseEntity.ok(historialAcademicoService.calcularPromedio(id));
    }

    @GetMapping("/existe")
    public ResponseEntity<Boolean> verificarExistencia(
            @RequestParam Long estudianteId,
            @RequestParam Long cursoId) {
        return ResponseEntity.ok(historialAcademicoService.existeHistorial(estudianteId, cursoId));
    }

    @PostMapping
    public ResponseEntity<HistorialAcademico> registrar(@RequestBody HistorialAcademico historial) {
        return ResponseEntity.ok(historialAcademicoService.actualizar(historial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historialAcademicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
