package com.aluracursos.forohub.respuesta;

public record DatosRegistroRespuesta(
        String mensaje,
        String topico,
        String fechaCreacion,
        String autor,
        String solucion
) {
}
