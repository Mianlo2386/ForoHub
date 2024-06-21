package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.topico.DatosRegistroTopico;
import com.aluracursos.forohub.topico.Topico;
import com.aluracursos.forohub.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody DatosRegistroTopico datosRegistroTopico) {
        Topico topico = new Topico(datosRegistroTopico);
        topicoRepository.save(topico);
        return ResponseEntity.ok(topico);
    }
}






