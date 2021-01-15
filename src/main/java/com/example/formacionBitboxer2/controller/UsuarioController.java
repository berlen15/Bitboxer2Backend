package com.example.formacionBitboxer2.controller;

import com.example.formacionBitboxer2.entities.Usuario;
import com.example.formacionBitboxer2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @RequestMapping("/{id}")
    public @ResponseBody Usuario getById(@PathVariable("id") int idusuario){
        return usuarioService.findByIdusuario(idusuario);
    }


}
