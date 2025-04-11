package co.edu.ufps.proyectoweb.repository;

import co.edu.ufps.proyectoweb.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByAsignaturaId(Long asignaturaId);
    List<Curso> findByProfesorId(Long profesorId);
    List<Curso> findByFechaInicioBetween(LocalDate inicio, LocalDate fin);
}
