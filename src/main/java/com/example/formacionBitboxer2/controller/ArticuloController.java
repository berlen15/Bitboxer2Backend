package com.example.formacionBitboxer2.controller;

import com.example.formacionBitboxer2.converter.ArticuloConverter;
import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.dto.ProveedorDTO;
import com.example.formacionBitboxer2.dto.ReduccionDTO;
import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.formacionBitboxer2.service.IArticuloService;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticuloController implements ErrorController {

    @Autowired
    private ArticuloService articuloService;

    private ArticuloConverter articuloConverter = new ArticuloConverter();
    @GetMapping("/articulos")
    public List<ArticuloDTO> obtenerTodos(){
        return articuloService.obtenerTodos();
    }

    @GetMapping("/articulos/{id}")
    public ArticuloDTO obtenerPorId(@PathVariable(name="id") Integer id){
        return articuloService.obtenerPorId(id);
    }


    @GetMapping("/articulos/filter")
    public @ResponseBody List<ArticuloDTO>  obtenerPorFiltro(@RequestParam(name="estado") String estado) {
        List<ArticuloDTO> resultados = new ArrayList<>();
        if(estado.equals("Venta")){
            for(ArticuloDTO a : articuloService.obtenerTodos()){
                if(a.getEstado()==1){
                    resultados.add(a);
                }else{
                    continue;
                }
            }
        }else{
            for(ArticuloDTO a : articuloService.obtenerTodos()){
                if(a.getEstado()==2){
                    resultados.add(a);
                }else{
                    continue;
                }
            }
        }
        return resultados;
    }

    /*
    * @GetMapping
    public List<Articulo> list(@RequestParam int size, @RequestParam int page, @RequestParam string filtro, Model model){
        Page<Articulo> pageableArticales = articlesRepository.findAll(searchArticleSpecification(search), PageRequest.of(page, limit);
        return pageableArticales.getContent();
    }}
    * */

    @PostMapping("/articulos")
    public ResponseEntity guardar(@RequestBody ArticuloDTO articuloDTO){
        if(articuloDTO!=null){
            articuloService.guardarArticulo(articuloDTO);
            return new ResponseEntity("Artículo creado con éxito",HttpStatus.CREATED);
        }else{
            return new ResponseEntity("El articulo no se ha creado correctamente. Supervise sus valores",HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/articulos/{id}")
    @ResponseBody
    public ResponseEntity actualizar(@PathVariable("id") int id, @RequestBody ArticuloDTO articuloDTO){
        if(articuloDTO==null){
            return new ResponseEntity("El artículo está vacío",HttpStatus.BAD_REQUEST);
        }
        Articulo articuloEditar = articuloConverter.dto2pojo(articuloService.obtenerPorId(id));
        if(articuloDTO.getPrecio()!=null){
            articuloEditar.setPrecio(articuloDTO.getPrecio());
        }
        if(articuloDTO.getDescripcion()!=null){
            articuloEditar.setDescripcion(articuloDTO.getDescripcion());
        }
        if(articuloDTO.getEstado()!=null){
            articuloEditar.setEstado(articuloDTO.getEstado());
        }
        articuloService.guardarArticulo(articuloConverter.pojo2dto(articuloEditar));
        return new ResponseEntity("Se ha editado el artículo",HttpStatus.ACCEPTED);
    }

    @PostMapping("/articulos/{id}/proveedores")
    public ResponseEntity añadirProveedor(@PathVariable("id") int id, @RequestParam Integer idproveedor){
        if(idproveedor==null){
            return new ResponseEntity("El proveedor seleccionado no es válido", HttpStatus.BAD_REQUEST);
        }
        articuloService.addProveedor(id, idproveedor);
        return new ResponseEntity("Se ha añadido el proveedor al artículo", HttpStatus.CREATED);
    }

    @PostMapping("/articulos/{id}/reducciones")
    public ResponseEntity añadirReduccion(@PathVariable("id") int id, @RequestBody ReduccionDTO reduccionDTO){
       /* if(reduccionDTO==null){
            return new ResponseEntity("El proveedor seleccionado no es válido", HttpStatus.BAD_REQUEST);
        }
        articuloService.addReduccion(id, reduccionDTO);
        return new ResponseEntity("Se ha añadido el proveedor al artículo", HttpStatus.CREATED);*/
        return new ResponseEntity("Mensaje por defecto", HttpStatus.CREATED);
    }
    @Override
    public String getErrorPath() {
        return null;
    }
}
