package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "precioCompra", nullable = false)
    private float precioCompra;
    
    @Column (name = "stock",nullable = false)
    private float stock;
    
    @Column (name = "precioVenta", nullable = false)
    private float precioVenta;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Compra> entradasAlmacens;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<DetalleVenta> detalleVentas;
    private static final Logger LOG = Logger.getLogger(Producto.class.getName());

    public Producto() {
    }

    public Producto(String nombre, String descripcion, float precioCompra, float stock, float precioVenta, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
    }

    public Producto(Integer id, String nombre, String descripcion, float precioCompra, float stock, float precioVenta, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
    }

    public Producto(String nombre, String descripcion, float precioCompra, float stock, float precioVenta, Categoria categoria, List<DetalleVenta> detalleVentas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
        this.detalleVentas = detalleVentas;
    }

    public Producto(Integer id, String nombre, String descripcion, float precioCompra, float stock, float precioVenta, Categoria categoria, List<DetalleVenta> detalleVentas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
        this.detalleVentas = detalleVentas;
    }

    public Producto(String nombre, String descripcion, float precioCompra, float stock, float precioVenta, Categoria categoria, List<Compra> entradasAlmacens, List<DetalleVenta> detalleVentas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
        this.entradasAlmacens = entradasAlmacens;
        this.detalleVentas = detalleVentas;
    }

    public Producto(Integer id, String nombre, String descripcion, float precioCompra, float stock, float precioVenta, Categoria categoria, List<Compra> entradasAlmacens, List<DetalleVenta> detalleVentas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
        this.entradasAlmacens = entradasAlmacens;
        this.detalleVentas = detalleVentas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Compra> getEntradasAlmacens() {
        return entradasAlmacens;
    }

    public void setEntradasAlmacens(List<Compra> entradasAlmacens) {
        this.entradasAlmacens = entradasAlmacens;
    }

    public List<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return nombre;
    }

    
    
    
}//end class
