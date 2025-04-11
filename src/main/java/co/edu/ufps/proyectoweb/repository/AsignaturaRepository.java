package co.edu.ufps.proyectoweb.repository;

import co.edu.ufps.proyectoweb.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    List<Asignatura> findByNombreContaining(String nombre);
}
