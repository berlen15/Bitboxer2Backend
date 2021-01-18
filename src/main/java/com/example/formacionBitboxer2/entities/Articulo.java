package com.example.formacionBitboxer2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="articulo")
public class Articulo implements Serializable, Comparable<Articulo> {
    @Id
    @Column(name="idarticulo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idarticulo;

    @Column(name="codigoarticulo", unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigoArticulo;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio")
    private Double precio;

    @Column(name="estado", nullable = false)
    private Integer estado; //Estado 1 = venta, Estado 2 = descatalogado

    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable(
            name = "articulo_proveedor",
            joinColumns = @JoinColumn(name="articulo_id", nullable = false),
            inverseJoinColumns =  @JoinColumn(name="proveedor_id")
    )
    private List<Proveedor> proveedor;

    @JsonIgnoreProperties("articulo")
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "articulo")
    private List <Reduccion> reducciones;

    public Articulo() {}

    public Articulo(Integer idarticulo, int codigoArticulo, String descripcion, Double precio, int estado) {
        this.idarticulo = idarticulo;
        this.codigoArticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }

    public Articulo(int codigoArticulo, String descripcion, int estado) {
        this.codigoArticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdarticulo() {
        return idarticulo;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setIdarticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(List<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }

    public List<Reduccion> getReducciones() {
        return reducciones;
    }

    public void setReducciones(List<Reduccion> reducciones) {
        this.reducciones = reducciones;
    }

    @Override
    public String toString(){
        return "ID: "+this.idarticulo+" | CODIGO: "+this.codigoArticulo+ " | ESTADO: "+this.estado;
    }

    @Override
    public int compareTo(Articulo o) {
        return this.compareTo(o);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj == null || getClass() != obj.getClass())
            return false;
        Articulo that = (Articulo) obj;
        return obj.equals(that.idarticulo);
    }
    @Override
    public int hashCode() {
        return this == null ? 0 : this.hashCode();
    }
}
