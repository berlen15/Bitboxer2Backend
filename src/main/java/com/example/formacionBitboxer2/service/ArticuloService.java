package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.converter.ArticuloConverter;
import com.example.formacionBitboxer2.converter.ProveedorConverter;
import com.example.formacionBitboxer2.converter.ReduccionConverter;
import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.repository.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.formacionBitboxer2.repository.IArticuloRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArticuloService implements IArticuloService{
    @Autowired
    private IArticuloRepository articuloRepository;

    @Autowired
    private IProveedorRepository proveedorRepository;

    //CONVERTERS
    private ArticuloConverter articuloConverter= new ArticuloConverter();
    private ProveedorConverter proveedorConverter = new ProveedorConverter();
    private ReduccionConverter reduccionConverter = new ReduccionConverter();


    @Override
    public List<ArticuloDTO> obtenerTodos() {
        List<ArticuloDTO> articulosDTO = new ArrayList<>();
        for(Articulo a : articuloRepository.findAll()){
            articulosDTO.add(articuloConverter.pojo2dto(a));
        }
        return articulosDTO;
    }

    @Override
    public void guardarArticulo(ArticuloDTO articuloDTO) {
        articuloRepository.save(articuloConverter.dto2pojo(articuloDTO));
    }

    @Override
    public void actualizarArticulo(ArticuloDTO articuloDTO) {
        Articulo articuloActualizar = articuloRepository.getOneByIdarticulo(articuloDTO.getIdarticulo());

    }

    @Override
    public ArticuloDTO obtenerPorId(int id) {
        return articuloConverter.pojo2dto(articuloRepository.findOneByIdarticulo(id));
    }

    @Override
    public ArticuloDTO buscarPorId(int id) {
        return articuloConverter.pojo2dto(articuloRepository.findOneByIdarticulo(id));
    }

    /*SOLO AÑADE PROVEEDORES YA EXISTENTES EN EL SISTEMA*/
    @Override
    public void addProveedor(int id, int idproveedor) {
        Articulo articulo = articuloRepository.getOneByIdarticulo(id);
        Proveedor proveedor = proveedorRepository.findByIdproveedor(idproveedor);
        //Guardar en la lista de proveedores
        /*List<Proveedor> proveedores = articulo.getProveedor();
        proveedores.add(proveedor);
        articuloRepository.save(articulo);

        //Guardar en la lista de artículos del proveedor
        List<Articulo> articulosProveedor;
        if(proveedor.getArticulos()==null){
             articulosProveedor = new ArrayList<>();
        }else{
            articulosProveedor = proveedor.getArticulos();
        }

        articulosProveedor.add(articulo);
        proveedorRepository.save(proveedor);*/
        articulo.addProveedor(proveedor);

    }

    @Override
    public void addReduccion(int id, ReduccionDTO reduccion) {
        Articulo articulo = articuloRepository.findOneByIdarticulo(id);
        articulo.addReduccion(reduccionConverter.dto2pojo(reduccion));
    }
}
