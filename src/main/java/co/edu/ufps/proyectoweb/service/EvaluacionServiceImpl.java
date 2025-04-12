package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.entity.Evaluacion;
import co.edu.ufps.proyectoweb.repository.EvaluacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EvaluacionServiceImpl implements EvaluacionService {

    private final EvaluacionRepository evaluacionRepository;

    @Override
    public Evaluacion guardar(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    public List<Evaluacion> obtenerTodas() {
        return evaluacionRepository.findAll();
    }

    @Override
    public Optional<Evaluacion> obtenerPorId(Long id) {
        return evaluacionRepository.findById(id);
    }

    @Override
    public Evaluacion actualizar(Long id, Evaluacion evaluacion) {
        evaluacion.setId(id);
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    public void eliminar(Long id) {
        evaluacionRepository.deleteById(id);
    }

    List<Evaluacion> findByFechaBetween(LocalDate inicio, LocalDate fin){
        return evaluacionRepository.findByFechaBetween(inicio,fin);
    }

}

