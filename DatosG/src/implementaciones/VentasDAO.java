package implementaciones;

import entidades.Cliente;
import entidades.Venta;
import interfaces.IConexionBD;
import interfaces.IVentasDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class VentasDAO implements IVentasDAO {

    private final IConexionBD conexion;

    public VentasDAO(IConexionBD conexion) {
        this.conexion = conexion;

    }

    @Override
    public boolean agregar(Venta venta) {

        EntityManager em = this.conexion.crearConexion();

        try {

            em.getTransaction().begin();
            em.persist(venta);
            em.getTransaction().commit();

            return true;

        } catch (IllegalStateException ise) {
            System.err.println("No fue posible guardar la venta");
            return false;
        }
    }

    @Override
    public Venta consultar(int id) {
        EntityManager em = this.conexion.crearConexion();

        try {

            Venta venta = em.find(Venta.class, id);

            return venta;
        } catch (IllegalStateException ise) {
            System.err.println("No fue posible consultar la venta");
            return null;
        }
    }

    @Override
    public List<Venta> consultarTodos() {
        List<Venta> ventas = null;
        EntityManager em = conexion.crearConexion();

        try {

            em.getTransaction().begin();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Venta> criteria = builder.createQuery(Venta.class);
            TypedQuery<Venta> query = em.createQuery(criteria);

            ventas = query.getResultList();

            em.getTransaction().commit();
        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar todas las ventas");
            return null;
        }

        return ventas;
    }

    @Override
    public List<Venta> buscarEntre(Calendar inicio, Calendar fin) {
        List<Venta> ventas = null;
        EntityManager em = conexion.crearConexion();

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String fechaInicio = dateFormat.format(inicio.getTimeInMillis());

            String fechaFin = dateFormat.format(fin.getTimeInMillis());

            return em.createQuery(String.format("SELECT v FROM Venta v WHERE v.fecha >= '%s' AND v.fecha <= '%s'", fechaInicio, fechaFin)).getResultList();

        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar las ventas entre las fechas dadas");
            return null;
        }
    }

    @Override
    public List<Venta> buscarEntreCliente(Calendar inicio, Calendar fin, Cliente cliente) {
        List<Venta> ventas = null;
        EntityManager em = conexion.crearConexion();
        
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String fechaInicio = dateFormat.format(inicio.getTimeInMillis());

            String fechaFin = dateFormat.format(fin.getTimeInMillis());

            return em.createQuery(String.format("SELECT v FROM Venta v WHERE v.fecha >= '%s' AND v.fecha <= '%s' AND v.cliente.id = %d", fechaInicio, fechaFin, cliente.getId())).getResultList();

        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar las ventas del cliente en la fecha dada");
            return null;
        }
    }

    @Override
    public boolean actualizar(Venta t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
