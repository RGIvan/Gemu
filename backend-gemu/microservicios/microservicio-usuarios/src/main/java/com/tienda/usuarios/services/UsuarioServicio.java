package com.tienda.usuarios.services;

import com.tienda.usuarios.models.Usuario;
import com.tienda.usuarios.repositories.UsuarioRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(UsuarioRepositorio usuarioRepository) {
        this.usuarioRepositorio = usuarioRepository;
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setApellidos(usuarioActualizado.getApellidos());
        usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
        usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
        usuarioExistente.setCorreoElectronico(usuarioActualizado.getCorreoElectronico());
        usuarioExistente.setPassword(usuarioActualizado.getPassword());
        usuarioExistente.setUsername(usuarioActualizado.getUsername());

        return usuarioRepositorio.save(usuarioExistente);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        return usuarioRepositorio.findByNombreIgnoreCase(nombre)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con nombre: " + nombre));
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}