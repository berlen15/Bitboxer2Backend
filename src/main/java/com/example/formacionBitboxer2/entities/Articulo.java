package com.example.formacionBitboxer2.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="articulo")
public class Articulo implements Serializable, Comparable<Articulo> {
    @Id
    @Column(name="idarticulo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idarticulo;

    @Column(name="codigoarticulo", unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer codigoarticulo;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio")
    private Double precio;

    @Column(name="estado", nullable = false)
    private Integer estado; //Estado 1 = venta, Estado 2 = descatalogado

    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinTable(
            name = "articulo_proveedor",
            joinColumns = @JoinColumn(name="articulo_id", nullable = false),
            inverseJoinColumns =  @JoinColumn(name="proveedor_id")
    )
    private List<Proveedor> proveedor;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "articulo")
    private List <Reduccion> reducciones;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable = false)
    private Usuario creador;

    public Articulo() {}

    public Articulo(Integer idarticulo, Integer codigoArticulo, String descripcion, Double precio, int estado) {
        this.idarticulo = idarticulo;
        this.codigoarticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }

    public Articulo(Integer codigoArticulo, String descripcion, int estado) {
        this.codigoarticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Integer getIdarticulo() {
        return idarticulo;
    }

    public Integer getCodigoarticulo() {
        return codigoarticulo;
    }

    public void setCodigoarticulo(Integer codigoarticulo) {
        this.codigoarticulo = codigoarticulo;
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

    public void addReduccion(Reduccion red){
        reducciones.add(red);
    }

    public void addProveedor(Proveedor prov){
        proveedor.add(prov);
    }
    @Override
    public String toString(){
        return "ID: "+this.idarticulo+" | CODIGO: "+this.codigoarticulo+ " | ESTADO: "+this.estado;
    }

    @Override
    public int compareTo(Articulo o) {
        return this.compareTo(o);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return idarticulo.equals(articulo.idarticulo) &&
                codigoarticulo.equals(articulo.codigoarticulo) &&
                creador.equals(articulo.creador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idarticulo, codigoarticulo, creador);
    }
}
