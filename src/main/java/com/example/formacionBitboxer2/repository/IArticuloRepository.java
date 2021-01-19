package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.entities.Reduccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticuloRepository extends CrudRepository<Articulo, Integer> {
    List<Articulo> findByCodigoArticulo(int codigo);
    Articulo findOneByIdarticulo(int id);
    Articulo findOneByCodigoArticulo(int codigo);
    List<Articulo> findByProveedor(int idProveedor);
    List<Reduccion> findAllByCodigoArticulo(int codigo);
    Articulo getOneByIdarticulo(int id);
    List<Proveedor> findAllByIdarticulo(int id);

}
