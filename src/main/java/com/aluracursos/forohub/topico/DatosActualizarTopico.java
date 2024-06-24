package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.usuario.Usuario;


import java.time.LocalDateTime;

public record DatosActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        Usuario autor,
        String curso
) {
}
