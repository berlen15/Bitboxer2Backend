package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.entities.Reduccion;

import java.util.List;

public interface IReduccionRepository {
    void save(Reduccion reduccion);
    List<Reduccion> findAllByArticulo(int idarticulo);
}
