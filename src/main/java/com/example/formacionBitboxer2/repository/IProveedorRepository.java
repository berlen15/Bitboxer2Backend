package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.entities.Proveedor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProveedorRepository extends CrudRepository<Proveedor, Integer> {
    Proveedor findByNombre(String nombre);
    Proveedor save(Proveedor proveedor);
    @Query("SELECT p from Proveedor p " +
            "JOIN p.articulos a " +
            "WHERE a.reducciones IS NOT EMPTY")
    List<Proveedor> findProveedoresArticulosReducidos();

}
