package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.converter.UsuarioConverter;
import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.UsuarioDTO;
import com.example.formacionBitboxer2.entities.Usuario;
import com.example.formacionBitboxer2.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    private UsuarioConverter usuarioConverter = new UsuarioConverter();

    @Override
    public UsuarioDTO buscarPorNombreUsuario(String nombreusuario) {
        return  usuarioConverter.pojo2dto(usuarioRepository.findByNombreusuario(nombreusuario));
    }


    @Override
    public boolean crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.dto2pojo(usuarioDTO);
        Usuario existe = usuarioRepository.findByNombreusuario(usuarioDTO.getNombreusuario());
        if(existe!=null){
            return false;
        }
        String salt = BCrypt.gensalt(12);
        usuario.setContraseña(BCrypt.hashpw(usuarioDTO.getContraseña(),salt));
        usuarioRepository.save(usuario);
        List<Usuario> usuarios = usuarioRepository.findAll();
        if(usuarios.contains(usuario)){
            return true;
        }
        return false;
    }
    public void guardarUsuario(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(usuarioConverter.dto2pojo(usuarioDTO));
    }

    @Transactional
    @Override
    public boolean eliminarUsuario(String nombreusuario) {
        usuarioRepository.deleteByNombreusuario(nombreusuario);
        Usuario usuario = usuarioRepository.findByNombreusuario(nombreusuario);
        if(usuario==null){
            return true;
        }
        return false;
    }

    public List<UsuarioDTO> findAll(){
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for(Usuario  u : usuarioRepository.findAll()){
            usuariosDTO.add(usuarioConverter.pojo2dto(u));
        }
        return usuariosDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usuarioRepository.findByNombreusuario(s);
    }
}
