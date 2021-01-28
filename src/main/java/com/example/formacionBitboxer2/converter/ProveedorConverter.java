package com.example.formacionBitboxer2.converter;


import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.entities.Reduccion;

import java.util.ArrayList;
import java.util.List;

public class ProveedorConverter {

    public ProveedorConverter() { }
    private ArticuloConverter articuloConverter;
    private ReduccionConverter reduccionConverter = new ReduccionConverter();

    public Proveedor dto2pojo(ProveedorDTO proveedorDTO){
        Proveedor proveedorPojo = new Proveedor();
        if(proveedorDTO==null){
            return null;
        }
        if(proveedorDTO.getIdproveedor()!=null){
            proveedorPojo.setIdproveedor(proveedorDTO.getIdproveedor());
        }
        if(proveedorDTO.getArticulos()!=null){
            //articuloConverter= new ArticuloConverter();
            List<Articulo> articulos = new ArrayList<>();
            for(ArticuloDTO a: proveedorDTO.getArticulos()){
                //articulos.add(articuloConverter.dto2pojo(a));
                articulos.add(articuloDto2pojo(a));
            }
            proveedorPojo.setArticulos(articulos);
        }else{
            proveedorPojo.setArticulos(new ArrayList<>());
        }
        proveedorPojo.setNombre(proveedorDTO.getNombre());
        proveedorPojo.setPais(proveedorDTO.getPais());
        return proveedorPojo;
    }

    public ProveedorDTO pojo2dto(Proveedor proveedor){
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        if(proveedor==null){
            return null;
        }
        if(proveedor.getIdproveedor()!=null){
            proveedorDTO.setIdproveedor(proveedor.getIdproveedor());
        }
        if(proveedor.getArticulos()!=null){
            List<ArticuloDTO> articulosDTO = new ArrayList<>();
            for(Articulo a: proveedor.getArticulos()){
                articulosDTO.add(articuloPojo2dto(a));
            }
            proveedorDTO.setArticulos(articulosDTO);
        }else{
            proveedorDTO.setArticulos(new ArrayList<>());
        }
        proveedorDTO.setNombre(proveedor.getNombre());
        proveedorDTO.setPais(proveedor.getPais());
        return proveedorDTO;
    }

    public List<Proveedor> convertAllToPojo(List<ProveedorDTO> proveedoresDTO){
        List<Proveedor> proveedorPojo = new ArrayList<>();
        for(ProveedorDTO r: proveedoresDTO){
            proveedorPojo.add(dto2pojo(r));
        }
        return proveedorPojo;
    }

    public List<ProveedorDTO> convertAllToDTO(List<Proveedor> proveedores){
        List<ProveedorDTO> proveedoresDTO = new ArrayList<>();
        for(Proveedor r: proveedores){
            proveedoresDTO.add(pojo2dto(r));
        }
        return proveedoresDTO;
    }
    public Articulo articuloDto2pojo(ArticuloDTO articuloDTO){
        Articulo articuloPojo = new Articulo();
        if(articuloDTO.getIdarticulo()!=null){
            articuloPojo.setIdarticulo(articuloDTO.getIdarticulo());
        }
        if(articuloDTO.getReducciones()!=null){
            List<Reduccion> reducciones = new ArrayList<>();
            for(ReduccionDTO r: articuloDTO.getReducciones()){
                reducciones.add(reduccionConverter.dto2pojo(r));
            }
            articuloPojo.setReducciones(reducciones);
        }
        articuloPojo.setPrecio(articuloDTO.getPrecio());
        articuloPojo.setDescripcion(articuloDTO.getDescripcion());
        articuloPojo.setEstado(articuloDTO.getEstado());
        articuloPojo.setIdarticulo(articuloDTO.getIdarticulo());
        articuloPojo.setCodigoarticulo(articuloDTO.getCodigoarticulo());
        return articuloPojo;
    }

    public ArticuloDTO articuloPojo2dto(Articulo articulo){
        ArticuloDTO articuloDTO = new ArticuloDTO();
        if(articulo.getIdarticulo()!=null){
            articuloDTO.setIdarticulo(articulo.getIdarticulo());
        }
        if(articulo.getReducciones()!=null){
            List<ReduccionDTO> reducciones = new ArrayList<>();
            for(Reduccion r: articulo.getReducciones()){
                reducciones.add(reduccionConverter.pojo2dto(r));
            }
            articuloDTO.setReducciones(reducciones);
        }
        articuloDTO.setPrecio(articulo.getPrecio());
        articuloDTO.setDescripcion(articulo.getDescripcion());
        articuloDTO.setEstado(articulo.getEstado());
        articuloDTO.setIdarticulo(articulo.getIdarticulo());
        articuloDTO.setCodigoarticulo(articulo.getCodigoarticulo());
        return articuloDTO;
    }
}
