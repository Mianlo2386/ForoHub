package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.topico.DatosActualizarTopico;
import com.aluracursos.forohub.topico.Topico;
import com.aluracursos.forohub.usuario.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody DatosRegistroUsuario datosRegistroUsuario) {
        List<String> perfiles = datosRegistroUsuario.perfiles() != null ? datosRegistroUsuario.perfiles() : new ArrayList<>();
        Usuario usuario = new Usuario(
                datosRegistroUsuario.nombre(),
                datosRegistroUsuario.email(),
                datosRegistroUsuario.contrasena(),
                perfiles
        );
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return ResponseEntity.ok(new UsuarioDTO(usuarioGuardado));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public Page<DatosListadoUsuarios> listadoUsuarios(Pageable paginacion){
        return usuarioRepository.findAll(paginacion).map(DatosListadoUsuarios::new);
    }


    @PutMapping("/{id}")
    @Transactional
    public void actualizarUsuario(@PathVariable Long id, @RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        usuario.actualizarDatos(datosActualizarUsuario);
        usuarioRepository.save(usuario);
    }


}

