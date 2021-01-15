package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.entities.Usuario;

public interface IUsuarioService {
    Usuario findByIdusuario(int idusuario);
    Usuario findByNombreusuario(String nombreusuario);
    void save(Usuario usuario);
}
