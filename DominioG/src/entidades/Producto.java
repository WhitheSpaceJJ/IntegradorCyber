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

    @Column(name = "marca", nullable = false, length = 20)
    private String marca;

    @Column(name = "codigp", nullable = false, length = 15)
    private long codigo;

    @Column(name = "precioCompra", nullable = false)
    private float precioCompra;

    @Column(name = "stock", nullable = false)
    private float stock;

    @Column(name = "precioVenta", nullable = false)
    private float precioVenta;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "producto")
    private List<DetalleCompra> entradasAlmacens;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "producto")
    private List<DetalleVenta> detalleVentas;

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
 public Producto(String nombre, String descripcion, float precioCompra, float stock, float precioVenta, Categoria categoria,String marca,long codigo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
        this.marca=marca;
        this.codigo=codigo;
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

    public Producto(String nombre, String descripcion, float precioCompra, float stock, float precioVenta, Categoria categoria, List<DetalleCompra> entradasAlmacens, List<DetalleVenta> detalleVentas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
        this.entradasAlmacens = entradasAlmacens;
        this.detalleVentas = detalleVentas;
    }

    public Producto(Integer id, String nombre, String descripcion, float precioCompra, float stock, float precioVenta, Categoria categoria, List<DetalleCompra> entradasAlmacens, List<DetalleVenta> detalleVentas) {
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

    public List<DetalleCompra> getEntradasAlmacens() {
        return entradasAlmacens;
    }

    public void setEntradasAlmacens(List<DetalleCompra> entradasAlmacens) {
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
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioCompra=" + precioCompra + ", stock=" + stock + ", precioVenta=" + precioVenta + ", categoria=" + categoria + ", entradasAlmacens=" + entradasAlmacens + ", detalleVentas=" + detalleVentas + '}';
    }

}//end class
