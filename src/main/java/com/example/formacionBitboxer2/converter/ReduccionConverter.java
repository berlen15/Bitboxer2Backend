package com.example.formacionBitboxer2.converter;

import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.entities.Reduccion;

public class ReduccionConverter {
    private UsuarioConverter usuarioConverter = new UsuarioConverter();
    public Reduccion dto2pojo(ReduccionDTO reduccionDTO){
        Reduccion reduccionPojo = new Reduccion();
        if(reduccionDTO.getIdreduccion()!=null){
            reduccionPojo.setIdreduccion(reduccionDTO.getIdreduccion());
        }
        reduccionPojo.setIdreduccion(reduccionDTO.getIdreduccion());
        reduccionPojo.setCreacion(reduccionDTO.getCreacion());
        reduccionPojo.setActivo(reduccionDTO.isActivo());
        reduccionPojo.setFin(reduccionDTO.getFin());
        reduccionPojo.setCantidad(reduccionDTO.getCantidad());
        reduccionPojo.setInicio(reduccionDTO.getInicio());
        return reduccionPojo;
    }

    public ReduccionDTO pojo2dto(Reduccion reduccion){
        ReduccionDTO reduccionDTO = new ReduccionDTO();
        if(reduccion.getIdreduccion()!=null){
            reduccionDTO.setIdreduccion(reduccion.getIdreduccion());
        }
        reduccionDTO.setCreacion(reduccion.getCreacion());
        reduccionDTO.setActivo(reduccion.isActivo());
        reduccionDTO.setFin(reduccion.getFin());
        reduccionDTO.setCantidad(reduccion.getCantidad());
        reduccionDTO.setInicio(reduccion.getInicio());
        return reduccionDTO;
    }
}
