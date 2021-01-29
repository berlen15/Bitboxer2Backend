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
import com.example.formacionBitboxer2.entities.Usuario;
import com.example.formacionBitboxer2.repository.IArticuloRepository;
import com.example.formacionBitboxer2.repository.IProveedorRepository;
import com.example.formacionBitboxer2.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArticuloService implements IArticuloService{

    //INJECTIONS OF REPOSITORIES
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
    public ArticuloDTO obtenerPorCodigoarticulo(int codigo) {
        return articuloConverter.pojo2dto(articuloRepository.findByCodigoarticulo(codigo));
    }

    @Override
    public boolean addProveedor(int codigo, ProveedorDTO proveedorDTO) {
        Articulo articulo = articuloRepository.getOneByCodigoarticulo(codigo);
        if(articulo.getProveedor()==null){
            articulo.setProveedor(new ArrayList<Proveedor>());
        }
        Proveedor proveedor = proveedorRepository.findByNombre(proveedorDTO.getNombre());
        if(!articulo.getProveedor().contains(proveedor)){
            articulo.addProveedor(proveedor);
            return true;
        }
        return false;
    }

    @Override
    public boolean addReduccion(int codigo, String nombreusuario, ReduccionDTO reduccion) {
        Articulo articulo = articuloRepository.findByCodigoarticulo(codigo);
        Usuario usuario = usuarioRepository.findByNombreusuario(nombreusuario);
        if(articulo.getCreador().getNombreusuario()==usuario.getNombreusuario()){
            List<Reduccion> reducciones = articulo.getReducciones();
            Reduccion nuevaReduccion = reduccionConverter.dto2pojo(reduccion);
            reduccionService.asociarArticulo(codigo, reduccion);
            articulo.addReduccion(nuevaReduccion);
            if(articulo.getReducciones().contains(nuevaReduccion)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarArticulo(int codigo) {
        articuloRepository.deleteByCodigoarticulo(codigo);
        Articulo articulo = articuloRepository.findByCodigoarticulo(codigo);
        if(articulo==null){
            return true;
        }
        return false;

    }

    @Override
    public List<ArticuloDTO> obtenerTodosPorUsuario(String nombreusuario) {
        Usuario usuario = usuarioRepository.findByNombreusuario(nombreusuario);
        return articuloConverter.convertAllToDTO(articuloRepository.findByCreador(usuario));
    }
}
