package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;

import java.util.List;

public interface IArticuloService {
    public List<ArticuloDTO> obtenerTodos();
    public void guardarArticulo(ArticuloDTO articulo);
    public ArticuloDTO obtenerPorCodigoarticulo(int codigo);
    public boolean addProveedor(int id,  ProveedorDTO proveedorDTO);
    public boolean addReduccion(int codigo, String nombreusuario, ReduccionDTO reduccion);
    public boolean eliminarArticulo(int codigo);
    public List<ArticuloDTO> obtenerTodosPorUsuario(String nombreusuario);
}
