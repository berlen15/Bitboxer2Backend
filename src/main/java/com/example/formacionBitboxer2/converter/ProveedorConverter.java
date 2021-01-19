package com.example.formacionBitboxer2.converter;


import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorConverter {

    private ArticuloConverter articuloConverter = new ArticuloConverter();
    public Proveedor dto2pojo(ProveedorDTO proveedorDTO){
        Proveedor proveedorPojo = new Proveedor();
        if(proveedorDTO.getIdproveedor()!=null){
            proveedorPojo.setIdproveedor(proveedorDTO.getIdproveedor());
        }
        if(proveedorDTO.getArticulos()!=null){
            List<Articulo> articulos = new ArrayList<>();
            for(ArticuloDTO a: proveedorDTO.getArticulos()){
                articulos.add(articuloConverter.dto2pojo(a));
            }
            proveedorPojo.setArticulos(articulos);
        }
        proveedorPojo.setIdproveedor(proveedorDTO.getIdproveedor());
        proveedorPojo.setNombre(proveedorDTO.getNombre());
        proveedorPojo.setPais(proveedorDTO.getPais());
        return proveedorPojo;
    }

    public ProveedorDTO pojo2dto(Proveedor proveedor){
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        if(proveedor.getIdproveedor()!=null){
            proveedorDTO.setIdproveedor(proveedor.getIdproveedor());
        }
        if(proveedor.getArticulos()!=null){
            List<ArticuloDTO> articulosDTO = new ArrayList<>();
            for(Articulo a: proveedor.getArticulos()){
                articulosDTO.add(articuloConverter.pojo2dto(a));
            }
            proveedorDTO.setArticulos(articulosDTO);
        }
        proveedorDTO.setIdproveedor(proveedor.getIdproveedor());
        proveedorDTO.setNombre(proveedor.getNombre());
        proveedorDTO.setPais(proveedor.getPais());
        return proveedorDTO;
    }
}
