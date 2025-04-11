package co.edu.ufps.proyectoweb.repository;

import co.edu.ufps.proyectoweb.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByEstudianteId(Long estudianteId);
    List<Inscripcion> findByCursoId(Long cursoId);
    boolean existsByEstudianteIdAndCursoId(Long estudianteId, Long cursoId);
}
