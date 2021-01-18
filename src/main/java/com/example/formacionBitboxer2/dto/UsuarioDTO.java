package com.example.formacionBitboxer2.dto;

import com.example.formacionBitboxer2.entities.Reduccion;
import java.io.Serializable;
import java.util.List;

public class UsuarioDTO implements Serializable {

    private Integer idusuario;
    private String nombreusuario;
    private String contraseña;
    private String tipo;
    private List<Reduccion> reducciones;
    private String token;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Reduccion> getReducciones() {
        return reducciones;
    }

    public void setReducciones(List<Reduccion> reducciones) {
        this.reducciones = reducciones;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
