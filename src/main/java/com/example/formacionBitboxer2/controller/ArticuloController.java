package com.example.formacionBitboxer2.controller;

import com.example.formacionBitboxer2.converter.ArticuloConverter;
import com.example.formacionBitboxer2.dto.ArticuloDTO;
import com.example.formacionBitboxer2.entities.Articulo;
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
    private IArticuloService articuloService;

    private ArticuloConverter articuloConverter = new ArticuloConverter();
    @GetMapping("/articulos")
    public List<ArticuloDTO> obtenerTodos(){
        return articuloService.findAll();
    }

    @GetMapping("/articulos/{id}")
    public ArticuloDTO obtenerPorId(@PathVariable(name="id") Integer id){
        return articuloService.getOneById(id);
    }


    @GetMapping("/articulos/filter")
    public @ResponseBody List<ArticuloDTO>  obtenerPorFiltro(@RequestParam(name="estado") String estado) {
        List<ArticuloDTO> resultados = new ArrayList<>();
        if(estado.equals("Venta")){
            for(ArticuloDTO a : articuloService.findAll()){
                if(a.getEstado()==1){
                    resultados.add(a);
                }else{
                    continue;
                }
            }
        }else{
            for(ArticuloDTO a : articuloService.findAll()){
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
            articuloService.save(articuloDTO);
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
        Articulo articuloEditar = articuloConverter.dto2pojo(articuloService.getOneById(id));
        if(articuloDTO.getPrecio()!=null){
            articuloEditar.setPrecio(articuloDTO.getPrecio());
        }
        if(articuloDTO.getDescripcion()!=null){
            articuloEditar.setDescripcion(articuloDTO.getDescripcion());
        }
        if(articuloDTO.getEstado()!=null){
            articuloEditar.setEstado(articuloDTO.getEstado());
        }
        articuloService.save(articuloConverter.pojo2dto(articuloEditar));
        return new ResponseEntity("Se ha editado el artículo",HttpStatus.ACCEPTED);
    }


    @Override
    public String getErrorPath() {
        return null;
    }
}
