package co.edu.ufps.proyectoweb.controller;
import co.edu.ufps.proyectoweb.entity.Asistencia;
import co.edu.ufps.proyectoweb.service.AsistenciaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/asistencias")
@RequiredArgsConstructor
public class AsistenciaController {

    private final AsistenciaService asistenciaService;

    @PostMapping
    public ResponseEntity<Asistencia> registrar(@RequestBody Asistencia asistencia) {
        return ResponseEntity.ok(asistenciaService.guardar(asistencia));
    }

    @GetMapping
    public ResponseEntity<List<Asistencia>> listarTodas() {
        return ResponseEntity.ok(asistenciaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> obtenerPorId(@PathVariable Long id) {
        return asistenciaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<List<Asistencia>> listarPorEstudiante(@PathVariable Long id) {
        return ResponseEntity.ok(asistenciaService.listarPorEstudiante(id));
    }

    @GetMapping("/curso/{cursoId}/fecha/{fecha}")
    public ResponseEntity<List<Asistencia>> listarPorCursoYFecha(@PathVariable Long cursoId, @PathVariable String fecha) {
        return ResponseEntity.ok(asistenciaService.listarPorCursoYFecha(cursoId, LocalDate.parse(fecha)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        asistenciaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}


