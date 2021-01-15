package com.example.formacionBitboxer2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("home")
    public String home(@RequestParam(value="nombreusuario", defaultValue="usuario") String nombreusuario){
        return "Bienvenid@ "+nombreusuario;
    }
}
