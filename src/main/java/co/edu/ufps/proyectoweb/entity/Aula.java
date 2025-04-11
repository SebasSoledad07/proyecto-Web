package co.edu.ufps.proyectoweb.entity;
import lombok.Data;
import jakarta.persistence.*;

import java.util.List;


@Data
@Entity
@Table(name = "aulas")
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer capacidad;
    private String ubicacion;

    @OneToMany(mappedBy = "aula")
    private List<CursoAula> cursoAulas;
}