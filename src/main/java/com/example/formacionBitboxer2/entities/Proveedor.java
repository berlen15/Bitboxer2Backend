package com.example.formacionBitboxer2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {
    @Id
    @Column(name="idproveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproveedor;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="pais")
    private String pais;

    @JsonIgnoreProperties("proveedor")
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
    private List<Articulo> articulos;


    public Proveedor(int idproveedor, String nombre, String pais) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.pais = pais;
    }
    public Proveedor(){}

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

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}
