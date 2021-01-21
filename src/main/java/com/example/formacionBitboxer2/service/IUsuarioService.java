package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.dto.UsuarioDTO;
import com.example.formacionBitboxer2.entities.Usuario;

public interface IUsuarioService {
    UsuarioDTO buscarPorId(int idusuario);
    UsuarioDTO buscarPorNombreUsuario(String nombreusuario);
    boolean crearUsuario(UsuarioDTO usuario);
    boolean eliminarUsuario(String nombreusuario);

}
