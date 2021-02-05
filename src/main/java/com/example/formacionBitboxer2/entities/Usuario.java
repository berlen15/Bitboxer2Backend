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
import java.util.Objects;

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

    @Column(name="ciudad")
    private String ciudad;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellidos")
    private String apellidos;

    @Column(name="telefono")
    private String telefono;

    @Column(name="rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;

   /* @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creador", orphanRemoval = true)
    private List<Reduccion> reducciones;*/

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creador")
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

    public Usuario(String nombreusuario, String contraseña, String ciudad, String nombre, String apellidos, String telefono, Rol rol) {
        this.nombreusuario = nombreusuario;
        this.contraseña = contraseña;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.rol = rol;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idusuario, usuario.idusuario) &&
                Objects.equals(nombreusuario, usuario.nombreusuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idusuario, nombreusuario);
    }
}
