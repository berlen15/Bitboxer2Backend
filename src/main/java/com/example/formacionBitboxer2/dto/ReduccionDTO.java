package com.example.formacionBitboxer2.dto;

import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class ReduccionDTO implements Serializable {
    private Integer idreduccion;
    private Date creacion;
    private Date inicio;
    private Date fin;
    private ArticuloDTO articulo;
    private Double cantidad;
    private boolean activo;

    public Integer getIdreduccion() {
        return idreduccion;
    }

    public void setIdreduccion(Integer idreduccion) {
        this.idreduccion = idreduccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public ArticuloDTO getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloDTO articulo) {
        this.articulo = articulo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
