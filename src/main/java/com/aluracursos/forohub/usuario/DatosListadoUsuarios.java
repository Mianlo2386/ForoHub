package com.aluracursos.forohub.usuario;

public record DatosListadoUsuarios(

        Long id,
        String nombre
) {
    public DatosListadoUsuarios(Usuario usuario){
        this(usuario.getId(), usuario.getNombre());
    }
}
