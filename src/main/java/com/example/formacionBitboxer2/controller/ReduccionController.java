package com.example.formacionBitboxer2.controller;

import com.example.formacionBitboxer2.converter.ReduccionConverter;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Reduccion;
import com.example.formacionBitboxer2.service.ReduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
public class ReduccionController implements ErrorController {
    @Autowired
    private ReduccionService reduccionService;

    private ReduccionConverter reduccionConverter = new ReduccionConverter();

    @PostMapping("/reducciones/{id}")
    public ResponseEntity actualizarEstadoReduccion(@PathVariable("id") Integer idreduccion, @RequestParam Boolean estado){
        Reduccion reduccion = reduccionConverter.dto2pojo(reduccionService.obtenerPorId(idreduccion));
        reduccion.setActivo(estado);
        reduccionService.guardarReduccion(reduccion);
        if(reduccion.isActivo()!=estado){
            return new ResponseEntity("No se ha podido actualizar la reduccion", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity(reduccion, HttpStatus.ACCEPTED);
        }




    }
    @GetMapping("/reducciones/{id}")
    public ReduccionDTO obtenerReduccion(@PathVariable("id") Integer idreduccion){
       return reduccionService.obtenerPorId(idreduccion);
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
