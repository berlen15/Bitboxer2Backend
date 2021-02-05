package com.example.formacionBitboxer2.converter;

import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.entities.Reduccion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticuloConverter {

    private ProveedorConverter proveedorConverter = new ProveedorConverter();
    private ReduccionConverter reduccionConverter = new ReduccionConverter();
    private UsuarioConverter usuarioConverter = new UsuarioConverter();
    public ArticuloConverter() {
    }

    public Articulo dto2pojo(ArticuloDTO articuloDTO){
        Articulo articuloPojo = new Articulo();

        if(articuloDTO==null){
            return null;
        }
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
        if(articuloDTO.getProveedor()!=null){
            List<Proveedor> proveedores = new ArrayList<>();
            for(ProveedorDTO r: articuloDTO.getProveedor()){
                proveedores.add(proveedorConverter.dto2pojo(r));
            }
            articuloPojo.setProveedor(proveedores);
        }
        articuloPojo.setPrecio(articuloDTO.getPrecio());
        articuloPojo.setDescripcion(articuloDTO.getDescripcion());
        articuloPojo.setEstado(articuloDTO.getEstado());
        articuloPojo.setIdarticulo(articuloDTO.getIdarticulo());
        articuloPojo.setCodigoarticulo(articuloDTO.getCodigoarticulo());
        articuloPojo.setCreador(usuarioConverter.dto2pojo(articuloDTO.getCreador()));
        return articuloPojo;
    }
    
    public ArticuloDTO pojo2dto(Articulo articulo){
        ArticuloDTO articuloDTO = new ArticuloDTO();
        if(articulo==null){
            return null;
        }
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
        if(articulo.getProveedor()!=null){
            List<ProveedorDTO> proveedores = new ArrayList<>();
            for(Proveedor r: articulo.getProveedor()){
                proveedores.add(proveedorConverter.pojo2dto(r));
            }
            articuloDTO.setProveedor(proveedores);
        }
        articuloDTO.setPrecio(articulo.getPrecio());
        articuloDTO.setDescripcion(articulo.getDescripcion());
        articuloDTO.setEstado(articulo.getEstado());
        articuloDTO.setIdarticulo(articulo.getIdarticulo());
        articuloDTO.setCodigoarticulo(articulo.getCodigoarticulo());
        articuloDTO.setCreador(usuarioConverter.pojo2dto(articulo.getCreador()));
        return articuloDTO;
    }
    public List<Articulo> convertAllToPojo(List<ArticuloDTO> articulosDTO){
        List<Articulo> articulosPojo = new ArrayList<>();
        for(ArticuloDTO r: articulosDTO){
            articulosPojo.add(dto2pojo(r));
        }
        return articulosPojo;
    }

    public List<ArticuloDTO> convertAllToDTO(List<Articulo> articulos){
        List<ArticuloDTO> articulosDTO = new ArrayList<>();
        for(Articulo r: articulos){
            articulosDTO.add(pojo2dto(r));
        }
        return articulosDTO;
    }
}
