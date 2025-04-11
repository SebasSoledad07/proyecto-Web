package co.edu.ufps.proyectoweb.repository;

import co.edu.ufps.proyectoweb.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findByNombreContaining(String nombre);
}
