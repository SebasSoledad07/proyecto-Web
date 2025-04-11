package co.edu.ufps.proyectoweb.controller;

import co.edu.ufps.proyectoweb.entity.Profesor;
import co.edu.ufps.proyectoweb.service.ProfesorService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.guardar(profesor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable Long id) {
        return profesorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> listarProfesores() {
        return ResponseEntity.ok(profesorService.obtenerTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.actualizar(id, profesor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Long id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
