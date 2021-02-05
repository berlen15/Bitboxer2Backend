package com.example.formacionBitboxer2.dto;

import com.example.formacionBitboxer2.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;

public class ArticuloDTO implements Serializable {
    private Integer idarticulo;
    private Integer codigoarticulo;
    private String descripcion;
    private Double precio;
    private Integer estado; //Estado 1 = venta, Estado 2 = descatalogado

    private List<ProveedorDTO> proveedor;
    private List<ReduccionDTO> reducciones;

    private UsuarioDTO creador;

    public UsuarioDTO getCreador() {
        return creador;
    }

    public void setCreador(UsuarioDTO creador) {
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

    public List<ProveedorDTO> getProveedor() {
        return proveedor;
    }

    public void setProveedor(List<ProveedorDTO> proveedor) {
        this.proveedor = proveedor;
    }

    public List<ReduccionDTO> getReducciones() {
        return reducciones;
    }

    public void setReducciones(List<ReduccionDTO> reducciones) {
        this.reducciones = reducciones;
    }
}
