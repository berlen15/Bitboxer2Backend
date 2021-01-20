package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Articulo;

import java.util.List;

public interface IArticuloService {
    public List<ArticuloDTO> obtenerTodos();
    public void guardarArticulo(ArticuloDTO articulo);
    public void actualizarArticulo(ArticuloDTO articulo);
    public List<ArticuloDTO> findByProveedor(int idproveedor);
    public ArticuloDTO obtenerPorId(int id);
    public ArticuloDTO buscarPorId(int id);
    public boolean addProveedor(int id,  ProveedorDTO proveedorDTO);
    public boolean addReduccion(int idarticulo, int idusuario, ReduccionDTO reduccion);
}
