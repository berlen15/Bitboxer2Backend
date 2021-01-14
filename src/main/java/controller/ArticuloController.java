package controller;

import entities.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IArticuloService;

import java.util.List;

@Controller
@RequestMapping(value="articulos")
public class ArticuloController {

    @Autowired
    private IArticuloService articuloService;

    @GetMapping(value="all")
    public List<Articulo> getAll(){
        return articuloService.findAll();
    }

}
