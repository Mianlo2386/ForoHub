package com.aluracursos.forohub.usuario;

public record DatosListadoUsuarios(
        String nombre
) {
    public DatosListadoUsuarios(Usuario usuario){
        this(usuario.getNombre());
    }
}
