package co.edu.ufps.proyectoweb.entity;
import lombok.Data;
import jakarta.persistence.*;



@Data
@Entity
@Table(name = "asignacion_roles")
public class AsignacionRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
}
