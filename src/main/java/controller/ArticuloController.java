package controller;

import entities.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IArticuloService;

import java.util.List;

@RestController
@RequestMapping(value="articulos")
public class ArticuloController implements ErrorController {

    @Autowired
    private IArticuloService articuloService;

    @GetMapping(value="all")
    public List<Articulo> getAll(){
        return articuloService.findAll();
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
