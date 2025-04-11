package co.edu.ufps.proyectoweb.repository;

import co.edu.ufps.proyectoweb.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
