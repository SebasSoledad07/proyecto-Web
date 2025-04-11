package co.edu.ufps.proyectoweb.repository;
import co.edu.ufps.proyectoweb.entity.RecursoMultimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecursoMultimediaRepository extends JpaRepository<RecursoMultimedia, Long> {
    List<RecursoMultimedia> findByCursoId(Long cursoId);
    List<RecursoMultimedia> findByTipo(String tipo);
}
