package com.example.formacionBitboxer2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {
    @Id
    @Column(name="idproveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproveedor;

    @Column(name="nombre", unique = true)
    private String nombre;

    @Column(name="pais")
    private String pais;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Articulo> articulos;

    public Proveedor(Integer idproveedor, String nombre, String pais, List<Articulo> articulos) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.pais = pais;
        this.articulos = articulos;
    }

    public Proveedor(String nombre, String pais) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return Objects.equals(idproveedor, proveedor.idproveedor) &&
                Objects.equals(nombre, proveedor.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproveedor, nombre);
    }
}
