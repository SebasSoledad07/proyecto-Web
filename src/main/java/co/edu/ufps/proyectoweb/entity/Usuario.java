package co.edu.ufps.proyectoweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios", indexes = {
        @Index(name = "idx_usuario_tipo", columnList = "tipo_usuario"),
        @Index(name = "idx_usuario_id_tipo", columnList = "id,tipo_usuario")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private LocalDate fechaNacimiento;
    private String direccion;
    @Column(unique = true)
    private String email;
    private Boolean activo;

    @OneToMany(mappedBy = "usuario")
    private List<AsignacionRol> roles;

    //@OneToMany(mappedBy = "emisor")
   // private List<Usuario> mensajesEnviados;

   // @OneToMany(mappedBy = "receptor")
    //private List<Mensaje> mensajesRecibidos;
}
