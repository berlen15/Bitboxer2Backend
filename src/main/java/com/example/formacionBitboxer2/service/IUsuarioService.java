package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.dto.UsuarioDTO;

public interface IUsuarioService {
    UsuarioDTO buscarPorNombreUsuario(String nombreusuario);
    boolean crearUsuario(UsuarioDTO usuario);
    boolean eliminarUsuario(String nombreusuario);
    void guardarUsuario(UsuarioDTO usuarioDTO);
}
