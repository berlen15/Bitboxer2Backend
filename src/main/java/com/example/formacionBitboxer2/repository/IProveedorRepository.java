package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProveedorRepository extends CrudRepository<Proveedor, Integer> {
    Proveedor findByIdproveedor(int id);
    List<Articulo> findAllByIdproveedor(int id);

}
