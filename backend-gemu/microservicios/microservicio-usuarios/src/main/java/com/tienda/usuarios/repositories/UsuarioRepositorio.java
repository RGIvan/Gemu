package com.tienda.usuarios.repositories;

import com.tienda.usuarios.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreIgnoreCase(String nombre);
}