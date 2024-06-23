package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.respuesta.DatosRegistroRespuesta;
import com.aluracursos.forohub.respuesta.Respuesta;
import com.aluracursos.forohub.respuesta.RespuestaRepository;
import com.aluracursos.forohub.topico.Topico;
import com.aluracursos.forohub.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/topicos/{topicoId}/respuestas")
public class RespuestaController {

    private final RespuestaRepository respuestaRepository;
    private final TopicoRepository topicoRepository;

    public RespuestaController(RespuestaRepository respuestaRepository, TopicoRepository topicoRepository) {
        this.respuestaRepository = respuestaRepository;
        this.topicoRepository = topicoRepository;
    }

    @PostMapping
    public ResponseEntity<Respuesta> crearRespuesta(@PathVariable Long topicoId, @RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta) {
        Topico topico = topicoRepository.findById(topicoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));

        Respuesta respuesta = new Respuesta(datosRegistroRespuesta, topico);
        Respuesta respuestaGuardada = respuestaRepository.save(respuesta);

        return ResponseEntity.status(HttpStatus.CREATED).body(respuestaGuardada);
    }


}
