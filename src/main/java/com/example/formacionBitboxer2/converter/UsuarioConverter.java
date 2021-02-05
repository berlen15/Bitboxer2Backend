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
        usuarioPojo.setRol(usuarioDTO.getRol());
        usuarioPojo.setNombre(usuarioDTO.getNombre());
        usuarioPojo.setApellidos(usuarioDTO.getApellidos());
        usuarioPojo.setCiudad(usuarioDTO.getCiudad());
        usuarioPojo.setTelefono(usuarioDTO.getTelefono());
       // usuarioPojo.setReducciones(usuarioDTO.getReducciones());
        usuarioPojo.setRol(usuarioDTO.getRol());
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
        usuarioDTO.setRol(usuarioPojo.getRol());

        usuarioDTO.setNombre(usuarioPojo.getNombre());
        usuarioDTO.setApellidos(usuarioPojo.getApellidos());
        usuarioDTO.setCiudad(usuarioPojo.getCiudad());
        usuarioDTO.setTelefono(usuarioPojo.getTelefono());
       // usuarioDTO.setReducciones(usuarioPojo.getReducciones());
        usuarioDTO.setRol(usuarioPojo.getRol());


        return usuarioDTO;
    }
}
