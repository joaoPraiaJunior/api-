package med.voll.api.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.model.entity.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
