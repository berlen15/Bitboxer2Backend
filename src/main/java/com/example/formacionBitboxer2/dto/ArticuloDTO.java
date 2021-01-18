package com.example.formacionBitboxer2.dto;

import com.example.formacionBitboxer2.entities.Proveedor;
import com.example.formacionBitboxer2.entities.Reduccion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class ArticuloDTO implements Serializable {
    private Integer idarticulo;
    private int codigoArticulo;
    private String descripcion;
    private Double precio;
    private Integer estado; //Estado 1 = venta, Estado 2 = descatalogado
    private List<Proveedor> proveedor;
    private List <Reduccion> reducciones;

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
}
