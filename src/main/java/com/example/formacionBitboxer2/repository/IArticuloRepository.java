package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.entities.Reduccion;
import com.example.formacionBitboxer2.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticuloRepository extends CrudRepository<Articulo, Integer> {
    Articulo findByCodigoarticulo(Integer codigo);
    Articulo getOneByCodigoarticulo(int codigo);
    List<Articulo> findByProveedor(Proveedor proveedor);
    List<Articulo> findByProveedorOrderByPrecioAsc(Proveedor proveedor);
    Articulo getOneByIdarticulo(int id);
    void deleteById(int id);
    void deleteByCodigoarticulo(int codigo);
    void deleteByIdarticulo(int id);
    List<Articulo> findByCreador(Usuario creador);
}
