package com.example.formacionBitboxer2.dto;

import com.example.formacionBitboxer2.Rol;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

public class UsuarioDTO implements Serializable {

    private Integer idusuario;
    private String nombreusuario;
    private String contraseña;
    private Rol rol;
    //@JsonBackReference
    private List<ReduccionDTO> reducciones;

    @JsonBackReference
    private List<ArticuloDTO> articulos;
    private String ciudad;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String token;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<ArticuloDTO> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<ArticuloDTO> articulos) {
        this.articulos = articulos;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<ReduccionDTO> getReducciones() {
        return reducciones;
    }

    public void setReducciones(List<ReduccionDTO> reducciones) {
        this.reducciones = reducciones;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
