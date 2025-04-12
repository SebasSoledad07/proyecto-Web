package co.edu.ufps.proyectoweb.service;
import co.edu.ufps.proyectoweb.entity.Evaluacion;

import java.util.List;
import java.util.Optional;

public interface EvaluacionService {

    Evaluacion guardar(Evaluacion evaluacion);
    List<Evaluacion> obtenerTodas();
    Optional<Evaluacion> obtenerPorId(Long id);
    Evaluacion actualizar(Long id, Evaluacion evaluacion);
    void eliminar(Long id);
}
