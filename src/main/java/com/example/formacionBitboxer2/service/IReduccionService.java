package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.dto.ReduccionDTO;

import java.util.List;

public interface IReduccionService {
    public List<ReduccionDTO> obtenerTodos();
    public List<ReduccionDTO> obtenerTodosPorArticulo(int idarticulo);
}
