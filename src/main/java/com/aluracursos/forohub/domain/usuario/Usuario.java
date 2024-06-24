package com.aluracursos.forohub.domain.usuario;

import com.aluracursos.forohub.domain.topico.Topico;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity(name = "usuario")
@Table(name = "Usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"topicos"})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;

    @Column(columnDefinition = "TEXT")
    private String perfiles;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Topico> topicos;

    public Usuario(String nombre, String email, String contrasena, List<String> perfiles) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.perfiles = convertPerfilesToString(perfiles);
    }
    private String convertPerfilesToString(List<String> perfiles) {
        return String.join(",", perfiles);
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario) {
        this.nombre = datosActualizarUsuario.nombre() != null
                ? datosActualizarUsuario.nombre() : this.nombre;

    }
}


