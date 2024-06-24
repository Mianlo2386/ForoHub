

package com.aluracursos.forohub.domain.usuario;

import java.util.Arrays;
import java.util.List;

public record UsuarioDTO(
        Long id,
        String nombre,
        String email,
        List<String> perfiles
) {
    public UsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(), convertPerfilesToList(usuario.getPerfiles()));
    }

    private static List<String> convertPerfilesToList(String perfilesString) {
        if (perfilesString == null || perfilesString.isEmpty()) {
            return List.of();
        }
        return Arrays.asList(perfilesString.split(","));
    }
}

