package service;

import entities.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IArticuloRepository;

import java.util.List;

@Service
public class ArticuloService implements IArticuloService{
    @Autowired
    private IArticuloRepository articuloRepository;

    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>) articuloRepository.findAll();
    }
}
