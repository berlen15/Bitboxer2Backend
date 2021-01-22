package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.entities.Reduccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticuloRepository extends CrudRepository<Articulo, Integer> {
    Articulo findOneByCodigoarticulo(int codigo);
    Articulo getOneByCodigoarticulo(int codigo);
    List<Articulo> findByProveedor(Proveedor proveedor);
    Articulo getOneByIdarticulo(int id);
    void deleteById(int id);
    void deleteByCodigoarticulo(int codigo);
}
