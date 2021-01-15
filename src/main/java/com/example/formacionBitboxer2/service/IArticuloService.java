package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.entities.Articulo;

import java.util.List;

public interface IArticuloService {
    public List<Articulo> findAll();
    public List<Articulo> findByProveedor(int idproveedor);
    public void save(Articulo articulo);
    public void update(Articulo articulo);
    public Articulo getOneById(int id);
}
