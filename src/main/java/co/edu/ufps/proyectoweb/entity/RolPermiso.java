package co.edu.ufps.proyectoweb.entity;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "roles_permisos")
public class RolPermiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "permiso_id")
    private Permiso permiso;
}
