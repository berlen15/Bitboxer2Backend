package com.example.formacionBitboxer2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    @Id
    @Column(name="idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusuario;

    @Column(name="nombreusuario", nullable = false)
    private String nombreusuario;

    @Column(name="contraseña", nullable = false)
    private String contraseña;

    @Column(name="tipo", nullable = false)
    private String tipo;

    @JsonIgnoreProperties("creador")
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creador", orphanRemoval = true)
    private List<Reduccion> reducciones;

    private String token;

    public Usuario(){}

    public Usuario(int idusuario, String nombreusuario, String contraseña, String tipo) {
        this.idusuario = idusuario;
        this.nombreusuario = nombreusuario;
        this.contraseña = contraseña;
        this.tipo=tipo;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public List<Reduccion> getReducciones() {
        return reducciones;
    }

    public void setReducciones(List<Reduccion> reducciones) {
        this.reducciones = reducciones;
    }
}
