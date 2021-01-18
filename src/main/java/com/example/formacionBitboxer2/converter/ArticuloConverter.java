package com.example.formacionBitboxer2.converter;

import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticuloConverter {
    public ArticuloConverter() {
    }

    public Articulo dto2pojo(ArticuloDTO articuloDTO){
        Articulo articuloPojo = new Articulo();
        if(articuloDTO.getIdarticulo()!=null){
            articuloPojo.setIdarticulo(articuloDTO.getIdarticulo());
        }
        articuloPojo.setPrecio(articuloDTO.getPrecio());
        articuloPojo.setDescripcion(articuloDTO.getDescripcion());
        articuloPojo.setEstado(articuloDTO.getEstado());
        articuloPojo.setIdarticulo(articuloDTO.getIdarticulo());
        articuloPojo.setCodigoArticulo(articuloDTO.getCodigoArticulo());
        articuloPojo.setProveedor(articuloDTO.getProveedor());
        articuloPojo.setReducciones(articuloDTO.getReducciones());
        return articuloPojo;
    }
    
    public ArticuloDTO pojo2dto(Articulo articulo){
        ArticuloDTO articuloDTO = new ArticuloDTO();
        if(articulo.getIdarticulo()!=null){
            articuloDTO.setIdarticulo(articulo.getIdarticulo());
        }
        articuloDTO.setPrecio(articulo.getPrecio());
        articuloDTO.setDescripcion(articulo.getDescripcion());
        articuloDTO.setEstado(articulo.getEstado());
        articuloDTO.setIdarticulo(articulo.getIdarticulo());
        articuloDTO.setCodigoArticulo(articulo.getCodigoArticulo());
        articuloDTO.setProveedor(articulo.getProveedor());
        articuloDTO.setReducciones(articulo.getReducciones());
        return articuloDTO;
    }
}
