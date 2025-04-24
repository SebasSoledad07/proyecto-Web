package co.edu.ufps.proyectoweb.controller;

import co.edu.ufps.proyectoweb.entity.Matricula;
import co.edu.ufps.proyectoweb.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<Matricula> crearMatricula(@RequestBody Matricula matricula) {
        return ResponseEntity.ok(matriculaService.guardarMatricula(matricula));
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> listar() {
        return ResponseEntity.ok(matriculaService.listarMatriculas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> obtenerPorId(@PathVariable Long id) {
        return matriculaService.obtenerMatriculaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> actualizar(@PathVariable Long id, @RequestBody Matricula matricula) {
        return ResponseEntity.ok(matriculaService.actualizarMatricula(id, matricula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        matriculaService.eliminarMatricula(id);
        return ResponseEntity.noContent().build();
    }
}