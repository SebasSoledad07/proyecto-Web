package co.edu.ufps.proyectoweb.controller;
import co.edu.ufps.proyectoweb.dto.asistenciadto.AsistenciaDTO;
import co.edu.ufps.proyectoweb.entity.Asistencia;
import co.edu.ufps.proyectoweb.service.AsistenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaService service;

    @GetMapping("/estudiante/{id}")
    public List<AsistenciaDTO> listarPorEstudiante(@PathVariable Long id) {
        return service.listarPorEstudiante(id);
    }

    @PostMapping
    public AsistenciaDTO registrar(@RequestBody Asistencia asistencia) {
        return service.registrar(asistencia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}

