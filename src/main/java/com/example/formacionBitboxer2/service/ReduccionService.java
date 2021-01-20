package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.converter.ArticuloConverter;
import com.example.formacionBitboxer2.converter.ReduccionConverter;
import com.example.formacionBitboxer2.converter.UsuarioConverter;
import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.dto.UsuarioDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Reduccion;
import com.example.formacionBitboxer2.entities.Usuario;
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
    public void asociarArticulo(Integer idarticulo, ReduccionDTO reduccionDTO) {
        Reduccion reduccion = reduccionConverter.dto2pojo(reduccionDTO);
        Articulo articulo = articuloRepository.findOneByIdarticulo(idarticulo);
        reduccion.setArticulo(articulo);
        reduccionRepository.save(reduccion);
    }

    @Override
    public ReduccionDTO obtenerPorId(Integer idreduccion) {
        return reduccionConverter.pojo2dto(reduccionRepository.findByIdreduccion(idreduccion));
    }

    @Override
    public void guardarReduccion(Reduccion reduccion) {
        reduccionRepository.save(reduccion);
    }
}
