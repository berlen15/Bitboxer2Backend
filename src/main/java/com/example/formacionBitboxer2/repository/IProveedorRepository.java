package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.entities.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IProveedorRepository extends CrudRepository<Proveedor, Integer> {
    Proveedor findByNombre(String nombre);
    Proveedor save(Proveedor proveedor);

}
