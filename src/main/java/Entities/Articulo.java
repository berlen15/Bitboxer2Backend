package Entities;

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

    @Column(name="descripcion", unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigoArticulo;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio", nullable = false)
    private Double precio;

    @Column(name="estado", nullable = false)
    private int estado;

    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable(
            name = "articulo_proveedor",
            joinColumns = @JoinColumn(name="articulo_id", nullable = false),
            inverseJoinColumns =  @JoinColumn(name="proveedor_id")
    )
    private List<Proveedor> proveedores;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "articulo")
    private List <Reduccion> reducciones;

}
