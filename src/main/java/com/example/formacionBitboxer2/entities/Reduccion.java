package com.example.formacionBitboxer2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="reduccion")
public class Reduccion implements Serializable {
    @Id
    @Column(name="idreduccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idreduccion;

    @JsonIgnoreProperties("reducciones")
    @ManyToOne
    @JoinColumn(name="usuario_id", nullable = false)
    private Usuario creador;

    @Column(name="creacion", nullable = false)
    private Date creacion;

    @Column(name="inicio", nullable = false)
    private Date inicio;

    @Column(name="fin", nullable = false)
    private Date fin;


    @ManyToOne
    @JoinColumn ( name = "articulo_id", nullable = false, updatable = false)
    private Articulo articulo;

    public Reduccion(){}
    public Reduccion(int idreduccion, Usuario creador, Date creacion, Date inicio, Date fin, Articulo articulo) {
        this.idreduccion = idreduccion;
        this.creador = creador;
        this.creacion = creacion;
        this.inicio = inicio;
        this.fin = fin;
        this.articulo = articulo;
    }

    public Integer getIdreduccion() {
        return idreduccion;
    }

    public void setIdreduccion(Integer idreduccion) {
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
