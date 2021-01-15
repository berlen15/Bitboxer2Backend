package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Reduccion;
import com.example.formacionBitboxer2.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
    List<Reduccion> findAllByIdusuario(int idusuario);
    List<Reduccion> findAllByNombreusuario(String nombreUsuario);
    Usuario findByNombreusuario(String nombreUsuario);
    Usuario findByIdusuario(int idusuario);
}
