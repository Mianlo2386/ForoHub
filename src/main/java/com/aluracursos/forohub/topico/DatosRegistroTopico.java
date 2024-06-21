package com.aluracursos.forohub.topico;

public record DatosRegistroTopico(
        String titulo,
        String mensaje,
        String fecha_creacion,
        Status status,
        String autor,
        String curso,
        String respuestas
        ) {
}
