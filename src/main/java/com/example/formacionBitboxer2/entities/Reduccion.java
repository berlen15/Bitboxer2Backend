package com.example.formacionBitboxer2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="reduccion")
public class Reduccion implements Serializable {
    @Id
    @Column(name="idreduccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idreduccion;

    @Column(name="cantidad", nullable = false)
    private Double cantidad;

    @Column(name="creacion")
    private Date creacion;

    @Column(name="inicio")
    private Date inicio;

    @Column(name="fin", nullable = false)
    private Date fin;

    @ManyToOne
    @JoinColumn ( name = "articulo_id", updatable = false)
    private Articulo articulo;

    private boolean activo;

    public Reduccion(){}
    public Reduccion(int idreduccion, Date creacion, Date inicio, Date fin, Articulo articulo, boolean activo) {
        this.idreduccion = idreduccion;
        this.creacion = creacion;
        this.inicio = inicio;
        this.fin = fin;
        this.articulo = articulo;
        this.activo=activo;
    }


    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Integer getIdreduccion() {
        return idreduccion;
    }

    public void setIdreduccion(Integer idreduccion) {
        this.idreduccion = idreduccion;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reduccion reduccion = (Reduccion) o;
        return Objects.equals(idreduccion, reduccion.idreduccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idreduccion);
    }
}
