package com.example.formacionBitboxer2.converter;


import com.example.formacionBitboxer2.dto.UsuarioDTO;
import com.example.formacionBitboxer2.entities.Usuario;

public class UsuarioConverter {
    public Usuario dto2pojo(UsuarioDTO usuarioDTO){
        Usuario usuarioPojo = new Usuario();
        if(usuarioDTO==null){
            return null;
        }
        if(usuarioDTO.getIdusuario()!=null){
            usuarioPojo.setIdusuario(usuarioDTO.getIdusuario());
        }
        usuarioPojo.setNombreusuario(usuarioDTO.getNombreusuario());
        usuarioPojo.setContraseña(usuarioDTO.getContraseña());
        usuarioPojo.setToken(usuarioDTO.getToken());
        usuarioPojo.setReducciones(usuarioDTO.getReducciones());
        usuarioPojo.setTipo(usuarioDTO.getTipo());
        return usuarioPojo;
    }

    public UsuarioDTO pojo2dto(Usuario usuarioPojo){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        if(usuarioPojo==null){
            return null;
        }
        if(usuarioPojo.getIdusuario()!=null){
            usuarioDTO.setIdusuario(usuarioPojo.getIdusuario());
        }
        usuarioDTO.setIdusuario(usuarioPojo.getIdusuario());
        usuarioDTO.setNombreusuario(usuarioPojo.getNombreusuario());
        usuarioDTO.setContraseña(usuarioPojo.getContraseña());
        usuarioDTO.setToken(usuarioPojo.getToken());
        usuarioDTO.setReducciones(usuarioPojo.getReducciones());
        usuarioDTO.setTipo(usuarioPojo.getTipo());


        return usuarioDTO;
    }
}
