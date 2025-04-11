package co.edu.ufps.proyectoweb.controller;
import co.edu.ufps.proyectoweb.entity.HistorialAcademico;
import co.edu.ufps.proyectoweb.service.HistorialAcademicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/historiales")
public class HistorialAcademicoController {

    private HistorialAcademicoService service;

    @GetMapping("/estudiante/{id}")
    public List<HistorialAcademico> obtenerPorEstudiante(@PathVariable Long id) {
        return service.obtenerPorEstudiante(id);
    }

    @PostMapping
    public HistorialAcademico registrar(@RequestBody HistorialAcademico historial) {
        return service.registrar(historial);
    }

    @PutMapping
    public HistorialAcademico actualizar(@RequestBody HistorialAcademico historial) {
        return service.actualizar(historial);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
