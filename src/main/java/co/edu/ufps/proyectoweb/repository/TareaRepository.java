package co.edu.ufps.proyectoweb.repository;

import co.edu.ufps.proyectoweb.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByCursoId(Long cursoId);
    List<Tarea> findByFechaEntregaBetween(LocalDate inicio, LocalDate fin);
}
