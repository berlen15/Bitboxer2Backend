package com.example.formacionBitboxer2.dto;

import com.example.formacionBitboxer2.entities.Articulo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class ProveedorDTO implements Serializable {
    private Integer idproveedor;
    private String nombre;
    private String pais;
    private List<ArticuloDTO> articulos;

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
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

    public List<ArticuloDTO> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<ArticuloDTO> articulos) {
        this.articulos = articulos;
    }
}
