package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="reduccion")
public class Reduccion implements Serializable {
    @Id
    @Column(name="idreduccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idreduccion;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable = false)
    private Usuario creador;

    @Column(name="creacion", nullable = false)
    private Date creacion;

    @Column(name="inicio", nullable = false)
    private Date inicio;

    @Column(name="fin", nullable = false)
    private Date fin;

    @ManyToOne
    @JoinColumn ( name = "articulo_id", nullable = false, updatable = false)
    private Articulo articulo;

    public int getIdreduccion() {
        return idreduccion;
    }

    public void setIdreduccion(int idreduccion) {
        this.idreduccion = idreduccion;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
