package co.edu.ufps.proyectoweb.entity;

import lombok.Data;
import jakarta.persistence.*;


@Data
@Entity
@Table(name = "curso_aula")
public class CursoAula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;
}