package com.example.formacionBitboxer2.converter;


import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.entities.Proveedor;

public class ProveedorConverter {
    public Proveedor dto2pojo(ProveedorDTO proveedorDTO){
        Proveedor proveedorPojo = new Proveedor();
        proveedorPojo.setArticulos(proveedorDTO.getArticulos());
        proveedorPojo.setIdproveedor(proveedorDTO.getIdproveedor());
        proveedorPojo.setNombre(proveedorDTO.getNombre());
        proveedorPojo.setPais(proveedorDTO.getPais());
        return proveedorPojo;
    }

    public ProveedorDTO pojo2dto(Proveedor proveedor){
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setArticulos(proveedor.getArticulos());
        proveedorDTO.setIdproveedor(proveedor.getIdproveedor());
        proveedorDTO.setNombre(proveedor.getNombre());
        proveedorDTO.setPais(proveedor.getPais());
        return proveedorDTO;
    }
}
