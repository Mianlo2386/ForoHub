package com.aluracursos.forohub.topico;

import com.aluracursos.forohub.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Usuario> findUsuarioById(Long id);
}
