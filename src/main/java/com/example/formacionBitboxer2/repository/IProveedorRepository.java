package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProveedorRepository extends CrudRepository<Proveedor, Integer> {
    Proveedor findByNombre(String nombre);
    List<Articulo> findAllByIdproveedor(int id);
    Proveedor save(Proveedor proveedor);

}
