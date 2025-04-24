package co.edu.ufps.proyectoweb.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recursos_multimedia")
public class RecursoMultimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private String titulo;
    private String tipo;
    private String url;
}
