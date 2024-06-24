

package com.aluracursos.forohub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//    Usuario findByEmail(String email);
//    Optional<Usuario> findUsuarioById(Long id);
}




