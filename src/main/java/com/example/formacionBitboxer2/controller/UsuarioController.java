package com.example.formacionBitboxer2.controller;

import com.example.formacionBitboxer2.converter.UsuarioConverter;
import com.example.formacionBitboxer2.dto.UsuarioDTO;
import com.example.formacionBitboxer2.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsuarioController implements ErrorController {

    @Autowired
    private UsuarioService usuarioService;

    private UsuarioConverter usuarioConverter= new UsuarioConverter();

    @GetMapping("/usuarios")
    public List<UsuarioDTO> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios/{idusuario}")
    public @ResponseBody UsuarioDTO getById(@PathVariable("idusuario") int idusuario){
        return usuarioService.buscarPorId(idusuario);
    }

    @PostMapping("/login")
    public UsuarioDTO login(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioLogged = usuarioService.buscarPorNombreUsuario(usuarioDTO.getNombreusuario());
        if(usuarioLogged!=null && BCrypt.checkpw(usuarioDTO.getContraseña(),usuarioLogged.getContraseña())){
            usuarioLogged.setToken(getJWTToken(usuarioDTO.getNombreusuario()));
            return usuarioLogged;
        }
        return null;

    }
    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
    @Override
    public String getErrorPath() {
        return null;
    }
}
