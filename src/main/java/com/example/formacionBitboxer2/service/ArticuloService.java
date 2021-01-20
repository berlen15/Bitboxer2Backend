package com.example.formacionBitboxer2.service;

import com.example.formacionBitboxer2.converter.ArticuloConverter;
import com.example.formacionBitboxer2.converter.ProveedorConverter;
import com.example.formacionBitboxer2.converter.ReduccionConverter;
import com.example.formacionBitboxer2.converter.UsuarioConverter;
import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.entities.Reduccion;
import com.example.formacionBitboxer2.repository.IArticuloRepository;
import com.example.formacionBitboxer2.repository.IProveedorRepository;
import com.example.formacionBitboxer2.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticuloService implements IArticuloService{
    @Autowired
    private IArticuloRepository articuloRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IProveedorRepository proveedorRepository;

    @Autowired
    private ReduccionService reduccionService;

    //CONVERTERS
    private ArticuloConverter articuloConverter= new ArticuloConverter();
    private ProveedorConverter proveedorConverter = new ProveedorConverter();
    private ReduccionConverter reduccionConverter = new ReduccionConverter();
    private UsuarioConverter usuarioConverter = new UsuarioConverter();

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
    public List<ArticuloDTO> findByProveedor(int idproveedor) {
        return articuloConverter.convertAllToDTO(articuloRepository.findByProveedor(idproveedor));
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
    public boolean addProveedor(int id, ProveedorDTO proveedorDTO) {
        Articulo articulo = articuloRepository.getOneByIdarticulo(id);
        Proveedor proveedor = proveedorRepository.findByIdproveedor(proveedorDTO.getIdproveedor());
        if(!articulo.getProveedor().contains(proveedor)){
            articulo.addProveedor(proveedor);
            return true;
        }
        return false;
    }

    @Override
    public boolean addReduccion(int idarticulo, int idusuario, ReduccionDTO reduccion) {
        Articulo articulo = articuloRepository.findOneByIdarticulo(idarticulo);
        if(articulo.getCreador().getIdusuario()==idusuario){
            List<Reduccion> reducciones = articulo.getReducciones();
            Reduccion nuevaReduccion = reduccionConverter.dto2pojo(reduccion);
            reduccionService.asociarArticulo(idarticulo, reduccion);
            articulo.addReduccion(nuevaReduccion);
            if(articulo.getReducciones().contains(nuevaReduccion)) {
                return true;
            }
        }
        return false;

    }
}
