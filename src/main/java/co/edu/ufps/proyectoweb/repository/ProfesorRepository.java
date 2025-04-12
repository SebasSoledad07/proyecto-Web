package co.edu.ufps.proyectoweb.repository;

import co.edu.ufps.proyectoweb.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    // Consulta optimizada con JOIN FETCH para relaciones
    @Query("SELECT p FROM Profesor p LEFT JOIN FETCH p.cursos WHERE p.id = :id")
    Optional<Profesor> findByIdWithCursos(@Param("id") Long id);
}
