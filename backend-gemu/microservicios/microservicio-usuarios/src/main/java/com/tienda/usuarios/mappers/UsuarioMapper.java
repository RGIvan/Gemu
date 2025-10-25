package com.tienda.usuarios.mappers;

import com.tienda.usuarios.models.Usuario;
import com.tienda.usuarios.dto.UsuarioDTO;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getCorreoElectronico(),
                usuario.getUsername(),
                usuario.getTelefono(),
                usuario.getDireccion(),
                usuario.getPassword()
        );
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setApellidos(dto.getApellidos());
        usuario.setCorreoElectronico(dto.getCorreoElectronico());
        usuario.setUsername(dto.getUsername());
        usuario.setTelefono(dto.getTelefono());
        usuario.setDireccion(dto.getDireccion());
        usuario.setPassword(dto.getPassword());

        return usuario;
    }
}