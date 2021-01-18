package com.example.formacionBitboxer2.dto;

import com.example.formacionBitboxer2.entities.Articulo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class ProveedorDTO implements Serializable {
    private int idproveedor;
    private String nombre;
    private String pais;
    private List<Articulo> articulos;

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}
