package com.example.formacionBitboxer2.entities;

import com.example.formacionBitboxer2.Rol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable, UserDetails {
    String ROLE_PREFIX = "ROLE_";
    @Id
    @Column(name="idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;

    @Column(name="nombreusuario", unique = true)
    private String nombreusuario;

    @Column(name="contraseña")
    private String contraseña;

    @Column(name="rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;

   /* @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creador", orphanRemoval = true)
    private List<Reduccion> reducciones;*/

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creador", orphanRemoval = true)
    private List<Articulo> articulos;


    private String token;

    public Usuario(){}

    public Usuario(Integer idusuario, String nombreusuario, String contraseña, Rol rol) {
        this.idusuario = idusuario;
        this.nombreusuario = nombreusuario;
        this.contraseña = contraseña;
        this.rol=rol;
    }

    public Usuario(String nombreusuario, String contraseña, Rol rol, List<Articulo> articulos) {
        this.ROLE_PREFIX = ROLE_PREFIX;
        this.nombreusuario = nombreusuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.articulos = articulos;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
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

   public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(ROLE_PREFIX+rol.name()));
        return roles;
    }

    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public String getUsername() {
        return nombreusuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
