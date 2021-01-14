package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="articulo")
public class Articulo implements Serializable {
    @Id
    @Column(name="idarticulo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idarticulo;

    @Column(name="codigoarticulo", unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigoArticulo;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio", nullable = false)
    private Double precio;

    @Column(name="estado", nullable = false)
    private int estado; //Estado 1 = venta, Estado 2 = descatalogado

    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable(
            name = "articulo_proveedor",
            joinColumns = @JoinColumn(name="articulo_id", nullable = false),
            inverseJoinColumns =  @JoinColumn(name="proveedor_id")
    )
    private List<Proveedor> proveedores;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "articulo")
    private List <Reduccion> reducciones;

    public Articulo(int idarticulo, int codigoArticulo, String descripcion, Double precio, int estado) {
        this.idarticulo = idarticulo;
        this.codigoArticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(int idarticulo) {
        this.idarticulo = idarticulo;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
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
}
