package co.edu.ufps.proyectoweb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@DiscriminatorValue("PROFESOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Profesor extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String departamento;
    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Evaluacion> evaluaciones;

}
