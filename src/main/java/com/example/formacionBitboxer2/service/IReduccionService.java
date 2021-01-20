package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Reduccion;

public interface IReduccionService {
    public void asociarArticulo(Integer idarticulo, ReduccionDTO reduccionDTO);
    public ReduccionDTO obtenerPorId(Integer idreduccion);
    public void guardarReduccion(Reduccion reduccion);

}
