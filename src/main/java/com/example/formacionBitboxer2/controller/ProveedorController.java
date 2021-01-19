package com.example.formacionBitboxer2.controller;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProveedorController implements ErrorController {

    @Autowired
    private ProveedorService proveedorService;

    @Override
    public String getErrorPath() {
        return null;
    }

    @GetMapping("/proveedores")
    public List<ProveedorDTO> obtenerTodos(){
        return proveedorService.obtenerTodos();
    }

    @GetMapping("/proveedores/{id}")
    public List<ProveedorDTO> obtenerPorId(@PathVariable("id") Integer idproveedor){
        return proveedorService.obtenerTodos();
    }

}
