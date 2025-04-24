package co.edu.ufps.proyectoweb.service;

import co.edu.ufps.proyectoweb.entity.Profesor;
import co.edu.ufps.proyectoweb.repository.ProfesorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfesorServiceImpl implements ProfesorService{
    @Autowired
    private ProfesorRepository profesorRepository;


    public List<Profesor> getAllProfesores() {
        return profesorRepository.findAll();
    }


    public Profesor getProfesorById(Long id) {
        return profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id: " + id));
    }


    public Profesor createProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }


    public Profesor updateProfesor(Long id, Profesor profesorDetails) {
        Profesor profesor = getProfesorById(id);
        profesor.setNombre(profesorDetails.getNombre());
        profesor.setApellido(profesorDetails.getApellido());
        profesor.setEmail(profesorDetails.getEmail());
        profesor.setTelefono(profesorDetails.getTelefono());
        profesor.setEspecialidad(profesorDetails.getEspecialidad());
        return profesorRepository.save(profesor);
    }


    public void deleteProfesor(Long id) {
        Profesor profesor = getProfesorById(id);
        profesorRepository.delete(profesor);
    }


    public Profesor findByCodigo(String codigo) {
        return profesorRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con código: " + codigo));
    }


    public Profesor findByEmail(String email) {
        return profesorRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con email: " + email));
    }
}
