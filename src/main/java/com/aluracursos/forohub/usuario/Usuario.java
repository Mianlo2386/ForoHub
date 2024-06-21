package com.aluracursos.forohub.usuario;

public record Usuario(
        String nombre,
        String correoElectronico,
        String contraseña,
        String perfiles
) {
}
