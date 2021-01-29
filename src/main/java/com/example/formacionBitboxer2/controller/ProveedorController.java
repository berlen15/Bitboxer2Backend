package com.example.formacionBitboxer2.controller;

import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProveedorController implements ErrorController {

    @Autowired
    private ProveedorService proveedorService;

    @Override
    public String getErrorPath() {
        return null;
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping("/proveedores")
    public List<ProveedorDTO> obtenerTodos(){
        return proveedorService.obtenerTodos();
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @PostMapping("/proveedores")
    public ResponseEntity crearProveedor(@RequestBody ProveedorDTO proveedorDTO){
        if(proveedorService.guardarProveedor(proveedorDTO)){
            return new ResponseEntity(proveedorDTO, HttpStatus.CREATED);
        }else{
            return new ResponseEntity("No se ha podido guardar al proveedor en el sistema", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping("/proveedores/{nombre}")
    public ProveedorDTO obtenerPorId(@PathVariable("nombre") String nombre){
        return proveedorService.obtenerPorNombre(nombre);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping("/proveedores/{nombre}/articulos")
    public List<ArticuloDTO> obtenerArticulosPorProveedor(@PathVariable(name="nombre") String nombre){
        ProveedorDTO proveedor = proveedorService.obtenerPorNombre(nombre);
        return proveedor.getArticulos();
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping("/proveedores/articulos")
    public List<ArticuloDTO> listaArticulosMasBaratos(){
        return proveedorService.listaArticulosMasBaratos();
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping("/proveedores/{nombre}/articulos/ordenados")
    public List<ArticuloDTO> articulosOrdenadosBaratosPrimero(@PathVariable(name="nombre") String nombre){
        return proveedorService.articulosMasBaratosPrimero(nombre);
    }
}
