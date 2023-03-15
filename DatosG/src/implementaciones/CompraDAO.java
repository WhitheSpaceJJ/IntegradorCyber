package implementaciones;

import entidades.Compra;
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
    private IProveedoresDAO proveedoresDAO;
    private IProductosDAO productosDAO;

    public CompraDAO(IConexionBD conexion,IProveedoresDAO proveedoresDAO,IProductosDAO productosDAO) {
        this.conexion = conexion;
        proveedoresDAO =proveedoresDAO;
        productosDAO = productosDAO;

    }

    @Override
    public boolean agregar(Compra entradaAlmacen) {

        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();

            Proveedor proveedorBD = em.find(Proveedor.class, entradaAlmacen.getProveedor().getId());
            Producto productoBD = em.find(Producto.class, entradaAlmacen.getProducto().getId());
            entradaAlmacen.setProveedor(proveedorBD);

            em.persist(entradaAlmacen);
            productosDAO.agregarStock(productoBD, entradaAlmacen.getCantidadComprada());

            em.flush();

            em.getTransaction().commit();
            return true;

        } catch (IllegalStateException ise) {
            System.err.println("No fue posible guardar la entrada al almacen");
            ise.printStackTrace();
            return false;
        }

    }

    @Override
    public Compra consultar(int id) {
        try {
            EntityManager em = this.conexion.crearConexion();

            Compra entradaAlmacen = em.find(Compra.class, id);

            return entradaAlmacen;
        } catch (IllegalStateException ise) {
            System.err.println("No fue posible consultar la venta");
            ise.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Compra> consultarTodos() {
        List<Compra> entradasAlmacen = null;

        try {

            EntityManager em = conexion.crearConexion();

            em.getTransaction().begin();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Compra> criteria = builder.createQuery(Compra.class);
            TypedQuery<Compra> query = em.createQuery(criteria);

            entradasAlmacen = query.getResultList();

            em.getTransaction().commit();
        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar todas entradas al almacen");
            ex.printStackTrace();
            return null;
        }

        return entradasAlmacen;
    }

    @Override
    public List<Compra> buscarEntre(Calendar inicio, Calendar fin) {

        List<Compra> entradasAlmacen = null;

        try {

            EntityManager em = conexion.crearConexion();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String fechaInicio = dateFormat.format(inicio.getTimeInMillis());

            String fechaFin = dateFormat.format(fin.getTimeInMillis());

            return em.createQuery(String.format("SELECT v FROM EntradaAlmacen v WHERE v.fecha >= '%s' AND v.fecha <= '%s'", fechaInicio, fechaFin)).getResultList();

        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar las entradas al almacen entre las fechas dadas");
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Compra> buscarEntreProveedores(Calendar inicio, Calendar fin, Proveedor proveedor) {
        List<Compra> entradasAlmacen = null;

        try {

            EntityManager em = conexion.crearConexion();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String fechaInicio = dateFormat.format(inicio.getTimeInMillis());

            String fechaFin = dateFormat.format(fin.getTimeInMillis());

            return em.createQuery(String.format("SELECT v FROM EntradaAlmacen v WHERE v.fecha >= '%s' AND v.fecha <= '%s' AND v.proveedor.id = %d", fechaInicio, fechaFin, proveedor.getId())).getResultList();

        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar las entradas al almacen del proveedor en la fecha dada");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Compra> buscarEntreProductos(Calendar inicio, Calendar fin, Producto producto) {
        List<Compra> entradasAlmacen = null;

        try {

            EntityManager em = conexion.crearConexion();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String fechaInicio = dateFormat.format(inicio.getTimeInMillis());

            String fechaFin = dateFormat.format(fin.getTimeInMillis());

            return em.createQuery(String.format("SELECT v FROM Producto v WHERE v.fecha >= '%s' AND v.fecha <= '%s' AND v.proveedor.id = %d", fechaInicio, fechaFin, producto.getId())).getResultList();

        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar las entradas al almacen del producto en la fecha dada");
            ex.printStackTrace();
            return null;
        }}

}
