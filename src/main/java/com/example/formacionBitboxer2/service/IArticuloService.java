package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Articulo;

import java.util.List;

public interface IArticuloService {
    public List<ArticuloDTO> findAll();
    public List<ArticuloDTO> findByProveedor(int idproveedor);
    public void save(ArticuloDTO articulo);
    public void update(ArticuloDTO articulo);
    public ArticuloDTO getOneById(int id);
    public ArticuloDTO findOneById(int id);
    public Boolean addProveedor(int id, ProveedorDTO proveedor);
    public Boolean addReduccion(int id, ReduccionDTO reduccion);
}
