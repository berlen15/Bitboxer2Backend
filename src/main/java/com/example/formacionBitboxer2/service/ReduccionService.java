package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.converter.ArticuloConverter;
import com.example.formacionBitboxer2.converter.ReduccionConverter;
import com.example.formacionBitboxer2.converter.UsuarioConverter;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Reduccion;
import com.example.formacionBitboxer2.repository.IArticuloRepository;
import com.example.formacionBitboxer2.repository.IReduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReduccionService implements IReduccionService{

    @Autowired
    private IReduccionRepository reduccionRepository;

    @Autowired
    private IArticuloRepository articuloRepository;

    private ReduccionConverter reduccionConverter = new ReduccionConverter();
    private ArticuloConverter articuloConverter = new ArticuloConverter();
    private UsuarioConverter usuarioConverter = new UsuarioConverter();

    @Override
    public void asociarArticulo(int codigoarticulo, ReduccionDTO reduccionDTO) {
        Reduccion reduccion = reduccionConverter.dto2pojo(reduccionDTO);
        Articulo articulo = articuloRepository.findByCodigoarticulo(codigoarticulo);
        reduccion.setArticulo(articulo);
        reduccionRepository.save(reduccion);
    }

    @Override
    public ReduccionDTO obtenerPorCodigoreduccion(Integer codigo) {
        return reduccionConverter.pojo2dto(reduccionRepository.findByCodigoreduccion(codigo));
    }

    @Override
    public void guardarReduccion(Reduccion reduccion) {
        reduccionRepository.save(reduccion);
    }
}
