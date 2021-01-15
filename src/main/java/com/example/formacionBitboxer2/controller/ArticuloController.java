package com.example.formacionBitboxer2.controller;

import com.example.formacionBitboxer2.entities.Articulo;
import jdk.nashorn.internal.ir.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.formacionBitboxer2.service.IArticuloService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="articulos")
public class ArticuloController implements ErrorController {

    @Autowired
    private IArticuloService articuloService;

    @GetMapping("")
    public List<Articulo> getAll(){
        return articuloService.findAll();
    }

    @GetMapping("/filter")
    public @ResponseBody List<Articulo>  getByFilter(@RequestParam(name="estado") String estado) {
        List<Articulo> resultados = new ArrayList<>();
        if(estado.equals("Venta")){
            for(Articulo a : articuloService.findAll()){
                if(a.getEstado()==1){
                    resultados.add(a);
                }else{
                    continue;
                }
            }
        }else{
            for(Articulo a : articuloService.findAll()){
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

    @PostMapping("")
    public ResponseEntity save(@RequestBody Articulo articulo){
        if(articulo!=null){
            articuloService.save(articulo);
            return new ResponseEntity("Artículo creado con éxito",HttpStatus.CREATED);
        }else{
            return new ResponseEntity("El articulo no se ha creado correctamente. Supervise sus valores",HttpStatus.BAD_REQUEST);
        }

    }

    /*@PutMapping("/editar/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable("id") int id, HttpServletRequest request,
                                            HttpServletResponse response, Model model){
        String descripcion = request.getParameter("descripcion");
        Double precio = Double.parseDouble(request.getParameter("precio"));
        String estado = request.getParameter("estado");

        Articulo editado = articuloService.getOneById(id);
        if(!descripcion.equals("") || descripcion!=null){
            editado.setDescripcion(descripcion);
        }
        if(!precio.equals("") || precio!=null){
            editado.setDescripcion(descripcion);
        }
        if(!estado.equals("") || estado!=null){
            editado.setDescripcion(descripcion);
        }
        if((descripcion.equals("") ||  descripcion==null) && (precio.equals("")|| precio==null)  && (estado.equals("") || estado==null)){
            return new ResponseEntity("Los valores enviados están vacíos",HttpStatus.BAD_REQUEST);
        }
        articuloService.save(editado);
        return new ResponseEntity("Se ha editado el artículo",HttpStatus.ACCEPTED);
    }*/

    @Override
    public String getErrorPath() {
        return null;
    }
}
