package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.converter.ArticuloConverter;
import com.example.formacionBitboxer2.converter.ProveedorConverter;
import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.repository.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorService implements IProveedorService{
    @Autowired
    private IProveedorRepository proveedorRepository;

    private ProveedorConverter proveedorConverter = new ProveedorConverter();
    private ArticuloConverter articuloConverter = new ArticuloConverter();
    @Override
    public List<ProveedorDTO> obtenerTodos() {
        List<ProveedorDTO> proveedores = new ArrayList<>();
        for(Proveedor p : proveedorRepository.findAll()){
            List<ArticuloDTO> articulos = articuloConverter.convertAllToDTO(p.getArticulos());
            ProveedorDTO proveedorDTO = proveedorConverter.pojo2dto(p);
            proveedorDTO.setArticulos(articulos);
            proveedores.add(proveedorDTO);
        }
        return proveedores;
    }

    @Override
    public ProveedorDTO obtenerPorNombre(String nombre) {
        return proveedorConverter.pojo2dto(proveedorRepository.findByNombre(nombre));
    }

    @Override
    public List<ArticuloDTO> articulosPorProveedor(String nombre) {
        Proveedor proveedor = proveedorRepository.findByNombre(nombre);
        return articuloConverter.convertAllToDTO(proveedor.getArticulos());
    }

    @Override
    public boolean guardarProveedor(ProveedorDTO proveedorDTO) {
        Proveedor proveedorNuevo = proveedorConverter.dto2pojo(proveedorDTO);
        proveedorRepository.save(proveedorNuevo);
        List<Proveedor> proveedores = (List<Proveedor>) proveedorRepository.findAll();
        if(proveedores.contains(proveedorNuevo)){
            return true;
        }
        return false;
    }


}
