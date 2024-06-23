package com.aluracursos.forohub.usuario;

import com.aluracursos.forohub.topico.Topico;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity(name = "usuario")
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Set<Perfil> perfiles;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Topico> topicos;
}


