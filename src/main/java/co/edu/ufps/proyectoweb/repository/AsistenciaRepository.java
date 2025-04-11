package co.edu.ufps.proyectoweb.repository;
import co.edu.ufps.proyectoweb.entity.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

    List<Asistencia> findByEstudianteIdAndCursoId(Long estudianteId, Long cursoId);

    List<Asistencia> findByEstudianteId(Long estudianteId);

    List<Asistencia> findByCursoIdAndFecha(Long cursoId, LocalDate fecha);

    boolean existsByEstudianteIdAndCursoIdAndFecha(Long estudianteId, Long cursoId, LocalDate fecha);

    @Query("SELECT COUNT(a) FROM Asistencia a WHERE a.estudiante.id = :estudianteId AND a.curso.id = :cursoId AND a.presente = false")
    Long contarInasistenciasPorEstudianteYCurso(
            @Param("estudianteId") Long estudianteId,
            @Param("cursoId") Long cursoId);

    @Query("SELECT (COUNT(a) * 100.0 / (SELECT COUNT(a2) FROM Asistencia a2 WHERE a2.estudiante.id = :estudianteId AND a2.curso.id = :cursoId)) " +
            "FROM Asistencia a WHERE a.estudiante.id = :estudianteId AND a.curso.id = :cursoId AND a.presente = true")
    Double calcularPorcentajeAsistencia(
            @Param("estudianteId") Long estudianteId,
            @Param("cursoId") Long cursoId);


}
