package com.example.formacionBitboxer2.repository;

import com.example.formacionBitboxer2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNombreusuario(String nombreUsuario);
    Usuario save(Usuario usuario);
    void deleteByNombreusuario(String nombreusuario);
}
