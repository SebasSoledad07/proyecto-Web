package co.edu.ufps.proyectoweb.repository;

import co.edu.ufps.proyectoweb.entity.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    List<Evaluacion> findByFechaBetween(LocalDate inicio, LocalDate fin);
}
