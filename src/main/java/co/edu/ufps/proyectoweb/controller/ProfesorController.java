package co.edu.ufps.proyectoweb.controller;

import co.edu.ufps.proyectoweb.entity.Profesor;
import co.edu.ufps.proyectoweb.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
        Profesor profesorCreado = profesorService.guardarProfesor(profesor);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(profesorCreado.getId())
                .toUri();

        return ResponseEntity.created(location).body(profesorCreado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesor(@PathVariable Long id) {
        return profesorService.obtenerProfesorPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> listarProfesores() {
        List<Profesor> profesores = profesorService.obtenerTodosLosProfesores();
        return ResponseEntity.ok(profesores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(
            @PathVariable Long id,
            @RequestBody Profesor profesor) {

        try {
            Profesor profesorActualizado = profesorService.actualizarProfesor(id, profesor);
            return ResponseEntity.ok(profesorActualizado);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Long id) {
        try {
            profesorService.eliminarProfesor(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}