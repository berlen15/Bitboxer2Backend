package com.example.formacionBitboxer2.converter;

import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.entities.Reduccion;

public class ReduccionConverter {
    public Reduccion dto2pojo(ReduccionDTO reduccionDTO){
        Reduccion reduccionPojo = new Reduccion();
        reduccionPojo.setIdreduccion(reduccionDTO.getIdreduccion());
        reduccionPojo.setArticulo(reduccionDTO.getArticulo());
        reduccionPojo.setCreacion(reduccionDTO.getCreacion());
        reduccionPojo.setCreador(reduccionDTO.getCreador());
        reduccionPojo.setFin(reduccionDTO.getFin());
        reduccionPojo.setInicio(reduccionDTO.getInicio());
        return reduccionPojo;
    }

    public ReduccionDTO pojo2dto(Reduccion reduccion){
        ReduccionDTO reduccionDTO = new ReduccionDTO();
        reduccionDTO.setIdreduccion(reduccion.getIdreduccion());
        reduccionDTO.setArticulo(reduccion.getArticulo());
        reduccionDTO.setCreacion(reduccion.getCreacion());
        reduccionDTO.setCreador(reduccion.getCreador());
        reduccionDTO.setFin(reduccion.getFin());
        reduccionDTO.setInicio(reduccion.getInicio());
        return reduccionDTO;
    }
}
