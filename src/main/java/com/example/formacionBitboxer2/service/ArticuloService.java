package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.converter.ArticuloConverter;
import com.example.formacionBitboxer2.converter.ProveedorConverter;
import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.repository.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.formacionBitboxer2.repository.IArticuloRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloService implements IArticuloService{
    @Autowired
    private IArticuloRepository articuloRepository;

    @Autowired
    private IProveedorRepository proveedorRepository;

    private ArticuloConverter articuloConverter= new ArticuloConverter();
    private ProveedorConverter proveedorConverter = new ProveedorConverter();

    @Override
    public List<ArticuloDTO> findAll() {
        List<ArticuloDTO> articulosDTO = new ArrayList<>();
        for(Articulo a : articuloRepository.findAll()){
            articulosDTO.add(articuloConverter.pojo2dto(a));
        }
        return articulosDTO;
    }

    @Override
    public List<ArticuloDTO> findByProveedor(int idproveedor) {
        return null;
    }

    @Override
    public void save(ArticuloDTO articuloDTO) {
        articuloRepository.save(articuloConverter.dto2pojo(articuloDTO));
    }

    @Override
    public void update(ArticuloDTO articuloDTO) {
        Articulo articuloActualizar = articuloRepository.getOneByIdarticulo(articuloDTO.getIdarticulo());

    }

    @Override
    public ArticuloDTO getOneById(int id) {
        return articuloConverter.pojo2dto(articuloRepository.findOneByIdarticulo(id));
    }

    @Override
    public ArticuloDTO findOneById(int id) {
        return articuloConverter.pojo2dto(articuloRepository.findOneByIdarticulo(id));
    }

    /*@Override
    public Boolean addProveedor(int id, ProveedorDTO proveedorDTO) {
        ArticuloDTO articulo = articuloConverter.pojo2dto(articuloRepository.getOneByIdarticulo(id));
        List<Proveedor> proveedores = articulo.getProveedor();
        if(!proveedores.contains(articulo)){
            Proveedor proveeedorPojo = proveedorConverter.dto2pojo(proveedorRepository.findByIdproveedor(proveedorDTO.getIdproveedor()));
            proveedores.add(proveeedorPojo);
            proveeedorPojo.getArticulos().add(articuloConverter.dto2pojo(articulo));
            return true;
        }
        return false;

    }*/

    @Override
    public Boolean addReduccion(int id, ReduccionDTO reduccion) {
        return null;
    }
}
