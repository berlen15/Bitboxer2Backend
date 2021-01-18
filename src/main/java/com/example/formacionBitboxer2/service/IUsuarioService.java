package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.dto.UsuarioDTO;
import com.example.formacionBitboxer2.entities.Usuario;

public interface IUsuarioService {
    UsuarioDTO findByIdusuario(int idusuario);
    UsuarioDTO findByNombreusuario(String nombreusuario);
    void save(UsuarioDTO usuario);
}
