package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        Usuario autor,
        String curso
) {
    public DatosListadoTopicos(Topico topico){
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
