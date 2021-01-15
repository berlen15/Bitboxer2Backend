package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.entities.Usuario;
import com.example.formacionBitboxer2.repository.IReduccionRepository;
import com.example.formacionBitboxer2.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public Usuario findByIdusuario(int idusuario) {
        return (Usuario) usuarioRepository.findByIdusuario(idusuario);
    }

    @Override
    public Usuario findByNombreusuario(String nombreusuario) {
        return (Usuario) usuarioRepository.findByNombreusuario(nombreusuario);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

}
