package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.infra.TopicoNotFoundException;
import com.aluracursos.forohub.topico.*;
import com.aluracursos.forohub.usuario.DatosListadoUsuarios;
import com.aluracursos.forohub.usuario.Usuario;
import com.aluracursos.forohub.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/topicos")
public class TopicoController {
    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;

    public TopicoController(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody DatosRegistroTopico datosRegistroTopico) {
        Usuario usuario = usuarioRepository.findById(datosRegistroTopico.autorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        Topico topico = new Topico(datosRegistroTopico, usuario);
        Topico topicoGuardado = topicoRepository.save(topico);
        return ResponseEntity.ok(topicoGuardado);
    }
    @GetMapping
    public Page<DatosListadoTopicos> listadoTopicos(@PageableDefault(size=10,sort="titulo") Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalleTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new TopicoNotFoundException("Tópico no encontrado"));
        return ResponseEntity.ok(topico);
    }
    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }







}




