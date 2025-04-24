package co.edu.ufps.proyectoweb.repository;

import co.edu.ufps.proyectoweb.entity.HistorialAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistorialAcademicoRepository extends JpaRepository<HistorialAcademico, Long> {
    List<HistorialAcademico> findByEstudianteId(Long estudianteId);
    List<HistorialAcademico> findByEstudianteIdAndAprobadoTrue(Long estudianteId);
    boolean existsByEstudianteIdAndCursoId(Long estudianteId, Long cursoId);
    @Query("SELECT AVG(h.calificacionFinal) FROM HistorialAcademico h WHERE h.estudiante.id = :estudianteId")
    Double calcularPromedioPorEstudiante(@Param("estudianteId") Long estudianteId);

}
