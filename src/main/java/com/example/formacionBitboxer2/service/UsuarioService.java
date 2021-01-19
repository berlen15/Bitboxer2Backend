package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.converter.UsuarioConverter;
import com.example.formacionBitboxer2.dto.UsuarioDTO;
import com.example.formacionBitboxer2.entities.Usuario;
import com.example.formacionBitboxer2.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    private UsuarioConverter usuarioConverter = new UsuarioConverter();

    @Override
    public UsuarioDTO buscarPorId(int idusuario) {
        return  usuarioConverter.pojo2dto(usuarioRepository.findByIdusuario(idusuario));
    }

    @Override
    public UsuarioDTO buscarPorNombreUsuario(String nombreusuario) {
        return  usuarioConverter.pojo2dto(usuarioRepository.findByNombreusuario(nombreusuario));
    }

    @Override
    public void guardarUsuario(UsuarioDTO usuario) {
        usuarioRepository.save(usuarioConverter.dto2pojo(usuario));
    }

    public List<UsuarioDTO> findAll(){
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for(Usuario  u : usuarioRepository.findAll()){
            usuariosDTO.add(usuarioConverter.pojo2dto(u));
        }
        return usuariosDTO;
    }

}
