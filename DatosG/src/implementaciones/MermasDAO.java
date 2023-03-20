package implementaciones;

import entidades.DetalleCompra;
import entidades.Producto;
import entidades.Proveedor;

import interfaces.IConexionBD;
import interfaces.ICompraDAO;
import interfaces.IProductosDAO;
import interfaces.IProveedoresDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public class CompraDAO implements ICompraDAO {

    private final IConexionBD conexion;

    public CompraDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(DetalleCompra entradaAlmacen) {

        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();

            em.persist(entradaAlmacen);

            em.flush();

            em.getTransaction().commit();
            return true;

        } catch (IllegalStateException ise) {
            System.err.println("No fue posible guardar la entrada al almacen");
            return false;
        }

    }

    @Override
    public DetalleCompra consultar(int id) {
        try {
            EntityManager em = this.conexion.crearConexion();

            DetalleCompra entradaAlmacen = em.find(DetalleCompra.class, id);

            return entradaAlmacen;
        } catch (IllegalStateException ise) {
            System.err.println("No fue posible consultar la venta");
            return null;
        }
    }

    @Override
    public List<DetalleCompra> consultarTodos() {
        List<DetalleCompra> entradasAlmacen = null;

        try {

            EntityManager em = conexion.crearConexion();

            em.getTransaction().begin();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<DetalleCompra> criteria = builder.createQuery(DetalleCompra.class);
            TypedQuery<DetalleCompra> query = em.createQuery(criteria);

            entradasAlmacen = query.getResultList();

            em.getTransaction().commit();
        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar todas entradas al almacen");
            return null;
        }

        return entradasAlmacen;
    }

    @Override
    public List<DetalleCompra> buscarEntre(Calendar inicio, Calendar fin) {

        List<DetalleCompra> entradasAlmacen = null;

        try {

            EntityManager em = conexion.crearConexion();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String fechaInicio = dateFormat.format(inicio.getTimeInMillis());

            String fechaFin = dateFormat.format(fin.getTimeInMillis());

            return em.createQuery(String.format("SELECT v FROM EntradaAlmacen v WHERE v.fecha >= '%s' AND v.fecha <= '%s'", fechaInicio, fechaFin)).getResultList();

        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar las entradas al almacen entre las fechas dadas");
            return null;
        }

    }

    @Override
    public List<DetalleCompra> buscarEntreProveedores(Calendar inicio, Calendar fin, Proveedor proveedor) {
        List<DetalleCompra> entradasAlmacen = null;

        try {

            EntityManager em = conexion.crearConexion();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String fechaInicio = dateFormat.format(inicio.getTimeInMillis());

            String fechaFin = dateFormat.format(fin.getTimeInMillis());

            return em.createQuery(String.format("SELECT v FROM EntradaAlmacen v WHERE v.fecha >= '%s' AND v.fecha <= '%s' AND v.proveedor.id = %d", fechaInicio, fechaFin, proveedor.getId())).getResultList();

        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar las entradas al almacen del proveedor en la fecha dada");
            return null;
        }
    }

    @Override
    public List<DetalleCompra> buscarEntreProductos(Calendar inicio, Calendar fin, Producto producto) {
        List<DetalleCompra> entradasAlmacen = null;

        try {

            EntityManager em = conexion.crearConexion();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String fechaInicio = dateFormat.format(inicio.getTimeInMillis());

            String fechaFin = dateFormat.format(fin.getTimeInMillis());

            return em.createQuery(String.format("SELECT v FROM Producto v WHERE v.fecha >= '%s' AND v.fecha <= '%s' AND v.proveedor.id = %d", fechaInicio, fechaFin, producto.getId())).getResultList();

        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar las entradas al almacen del producto en la fecha dada");
            return null;
        }}

}
