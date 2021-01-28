package com.example.formacionBitboxer2.controller;

import com.example.formacionBitboxer2.converter.ReduccionConverter;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Reduccion;
import com.example.formacionBitboxer2.service.ReduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReduccionController implements ErrorController {
    @Autowired
    private ReduccionService reduccionService;

    private ReduccionConverter reduccionConverter = new ReduccionConverter();

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @PostMapping("/reducciones/{codigo}")
    public ResponseEntity actualizarEstadoReduccion(@PathVariable("codigo") Integer codigo, @RequestParam Boolean estado){
        Reduccion reduccion = reduccionConverter.dto2pojo(reduccionService.obtenerPorCodigoreduccion(codigo));
        reduccion.setActivo(estado);
        reduccionService.guardarReduccion(reduccion);
        if(reduccion.isActivo()!=estado){
            return new ResponseEntity("No se ha podido actualizar la reduccion", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity(reduccion, HttpStatus.ACCEPTED);
        }
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping("/reducciones/{codigo}")
    public ReduccionDTO obtenerReduccion(@PathVariable("codigo") Integer codigo){
       return reduccionService.obtenerPorCodigoreduccion(codigo);
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
