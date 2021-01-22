package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.entities.Reduccion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReduccionRepository extends CrudRepository<Reduccion, Integer> {
    Reduccion save(Reduccion reduccion);
    Reduccion findByIdreduccion(Integer idreduccion);
}
