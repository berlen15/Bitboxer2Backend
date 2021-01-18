package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.entities.Proveedor;
import org.springframework.data.repository.CrudRepository;

public interface IProveedorRepository extends CrudRepository<Proveedor, Integer> {
    ProveedorDTO findByIdproveedor(int id);
}
