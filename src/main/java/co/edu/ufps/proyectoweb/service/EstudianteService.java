package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.entity.Estudiante;
import co.edu.ufps.proyectoweb.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante getEstudianteById(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
    }

    public Estudiante createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante updateEstudiante(Long id, Estudiante estudianteDetails) {
        Estudiante estudiante = getEstudianteById(id);
        estudiante.setNombre(estudianteDetails.getNombre());
        estudiante.setApellido(estudianteDetails.getApellido());
        estudiante.setEmail(estudianteDetails.getEmail());
        estudiante.setTelefono(estudianteDetails.getTelefono());
        estudiante.setDireccion(estudianteDetails.getDireccion());
        estudiante.setSemestre(estudianteDetails.getSemestre());
        return estudianteRepository.save(estudiante);
    }


    public void deleteEstudiante(Long id) {
        Estudiante estudiante = getEstudianteById(id);
        estudianteRepository.delete(estudiante);
    }


    public Estudiante findByCodigo(String codigo) {
        return estudianteRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con código: " + codigo));
    }


    public Estudiante findByEmail(String email) {
        return estudianteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con email: " + email));
    }
}
