package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.converter.ArticuloConverter;
import com.example.formacionBitboxer2.converter.ProveedorConverter;
import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.repository.IArticuloRepository;
import com.example.formacionBitboxer2.repository.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorService implements IProveedorService{

    //INJECTIONS OF REPOSITORIES
    @Autowired
    private IProveedorRepository proveedorRepository;

    @Autowired
    private IArticuloRepository articuloRepository;

    //CONVERTERS
    private ProveedorConverter proveedorConverter = new ProveedorConverter();
    private ArticuloConverter articuloConverter = new ArticuloConverter();
    

    @Override
    public List<ProveedorDTO> obtenerTodos() {
        List<ProveedorDTO> proveedores = new ArrayList<>();
        for(Proveedor p : proveedorRepository.findAll()){
            List<ArticuloDTO> articulos = articuloConverter.convertAllToDTO(p.getArticulos());
            ProveedorDTO proveedorDTO = proveedorConverter.pojo2dto(p);
            proveedorDTO.setArticulos(articulos);
            proveedores.add(proveedorDTO);
        }
        return proveedores;
    }

    @Override
    public ProveedorDTO obtenerPorNombre(String nombre) {
        return proveedorConverter.pojo2dto(proveedorRepository.findByNombre(nombre));
    }

    @Override
    public ArticuloDTO articuloMasBaratoPorProveedor(String nombre) {
        Proveedor proveedor = proveedorRepository.findByNombre(nombre);
        if(proveedor.getArticulos().size()>0){
            List<ArticuloDTO> articulos = articuloConverter.convertAllToDTO(proveedor.getArticulos());
            if(articulos==null){
                return null;
            }
            ArticuloDTO articuloBarato = articulos.get(0);

            for(int i = 1; i<articulos.size(); i++){
                ArticuloDTO articulo = articulos.get(i);
                if(articulo.getPrecio()<articuloBarato.getPrecio()){
                    articuloBarato=articulo;
                }else{
                    continue;
                }
            }
            return articuloBarato;
        }
        return null;
    }

    @Override
    public boolean guardarProveedor(ProveedorDTO proveedorDTO) {
        Proveedor proveedorNuevo = proveedorConverter.dto2pojo(proveedorDTO);
        proveedorRepository.save(proveedorNuevo);
        List<Proveedor> proveedores = (List<Proveedor>) proveedorRepository.findAll();
        if(proveedores.contains(proveedorNuevo)){
            return true;
        }
        return false;
    }
}
