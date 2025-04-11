package co.edu.ufps.proyectoweb.repository;

import co.edu.ufps.proyectoweb.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

}
