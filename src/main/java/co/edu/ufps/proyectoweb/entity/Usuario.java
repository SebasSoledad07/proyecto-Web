package co.edu.ufps.proyectoweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    private Boolean activo;

    @OneToMany(mappedBy = "usuario")
    private List<AsignacionRol> roles;

    @OneToMany(mappedBy = "emisor")
    private List<Mensaje> mensajesEnviados;

    @OneToMany(mappedBy = "receptor")
    private List<Mensaje> mensajesRecibidos;
}
