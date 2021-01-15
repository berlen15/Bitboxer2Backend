package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.entities.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.formacionBitboxer2.repository.IArticuloRepository;

import java.util.List;

@Service
public class ArticuloService implements IArticuloService{
    @Autowired
    private IArticuloRepository articuloRepository;

    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>) articuloRepository.findAll();
    }

    @Override
    public List<Articulo> findByProveedor(int idproveedor) {
        return null;
    }

    @Override
    public void save(Articulo articulo) {
        articuloRepository.save(articulo);
    }

    @Override
    public void update(Articulo articulo) {
        Articulo articuloActualizar = articuloRepository.getOneByIdarticulo(articulo.getIdarticulo());

    }

    @Override
    public Articulo getOneById(int id) {
        return articuloRepository.getOneByIdarticulo(id);
    }
}
