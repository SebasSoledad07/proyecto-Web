package co.edu.ufps.proyectoweb.entity;
import lombok.Data;
import jakarta.persistence.*;


@Data
@Entity
@Table(name = "materiales")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private String nombre;
    private String tipo;
    private String descripcion;
}
