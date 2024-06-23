package com.aluracursos.forohub.usuario;

import java.util.Set;

public record DatosRegistroUsuario(
        String nombre,
        String email,
        String contrasena,
        Set<Perfil> perfiles
) {
}
