package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.usuario.Usuario;

public record DatosListadoTopicos(
        String titulo
) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getTitulo());
    }
}
