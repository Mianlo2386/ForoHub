package com.aluracursos.forohub.domain.usuario;

import com.aluracursos.forohub.domain.topico.Topico;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Entity(name = "usuario")
@Table(name = "Usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"topicos"})
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;


    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Topico> topicos;

    public Usuario(String nombre, String email, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // No es necesario implementar nada aquí por ahora
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.contrasena;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario) {
        this.nombre = datosActualizarUsuario.nombre() != null
                ? datosActualizarUsuario.nombre() : this.nombre;

    }
}



