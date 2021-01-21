package com.example.formacionBitboxer2.controller;

import com.example.formacionBitboxer2.converter.UsuarioConverter;
import com.example.formacionBitboxer2.dto.UsuarioDTO;
import com.example.formacionBitboxer2.entities.Usuario;
import com.example.formacionBitboxer2.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class UsuarioController implements ErrorController {

    @Autowired
    private UsuarioService usuarioService;

    private UsuarioConverter usuarioConverter = new UsuarioConverter();

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/usuarios")
    public List<UsuarioDTO> findAll() {
        return usuarioService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/usuarios/{nombreusuario}")
    public @ResponseBody
    UsuarioDTO obtenerPorNombreUsuario(@PathVariable("nombreusuario") String nombreusuario) {
        return usuarioService.buscarPorNombreUsuario(nombreusuario);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/usuarios")
    public ResponseEntity crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
        if(usuarioService.crearUsuario(usuarioDTO)){
            return new ResponseEntity(usuarioDTO, HttpStatus.CREATED);
        }else{
            return new ResponseEntity("El usuario ya existe o no es válido", HttpStatus.BAD_REQUEST);
        }

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/usuarios/{nombreusuario}")
    public ResponseEntity eliminarUsuario(@PathVariable("nombreusuario") String nombreusuario){
        if(usuarioService.eliminarUsuario(nombreusuario)){
            return new ResponseEntity("Usuario eliminado con éxito", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity("No se pudo eliminar el usuario correctamente", HttpStatus.BAD_REQUEST);
        }
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

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout"; //You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    private String getJWTToken(String username) {
        Usuario usuario = usuarioConverter.dto2pojo(usuarioService.buscarPorNombreUsuario(username));
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_"+usuario.getRol().name());

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
    @Override
    public String getErrorPath() {
        return null;
    }
}
