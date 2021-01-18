package com.example.formacionBitboxer2.dto;

import com.example.formacionBitboxer2.entities.Articulo;
import com.example.formacionBitboxer2.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class ReduccionDTO implements Serializable {
    private int idreduccion;
    private Usuario creador;
    private Date creacion;
    private Date inicio;
    private Date fin;
    private Articulo articulo;

    public int getIdreduccion() {
        return idreduccion;
    }

    public void setIdreduccion(int idreduccion) {
        this.idreduccion = idreduccion;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
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

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
