package co.edu.ufps.proyectoweb.repository;
import co.edu.ufps.proyectoweb.entity.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

    List<Asistencia> findByEstudianteIdAndCursoId(Long estudianteId, Long cursoId);

    List<Asistencia> findByEstudianteId(Long estudianteId);

    List<Asistencia> findByCursoIdAndFecha(Long cursoId, LocalDate fecha);
    boolean existsByEstudianteIdAndCursoId(Long estudianteId, Long cursoId);


}
