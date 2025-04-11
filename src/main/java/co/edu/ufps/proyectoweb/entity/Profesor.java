package co.edu.ufps.proyectoweb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@DiscriminatorValue( "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Column(unique = true)
    private String email;

    private String especialidad;

    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;
}
