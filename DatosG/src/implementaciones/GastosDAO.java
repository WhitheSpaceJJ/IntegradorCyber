package implementaciones;

import entidades.Gasto;
import interfaces.IConexionBD;
import interfaces.IGastosDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public class GastosDAO implements IGastosDAO {

    private final IConexionBD conexion;

    public GastosDAO(IConexionBD conexion) {
        this.conexion = conexion;

    }

    @Override
    public boolean agregar(Gasto gasto) {
        EntityManager em = conexion.crearConexion();

        try {
            em.getTransaction().begin();
            em.persist(gasto);
            em.getTransaction().commit();
            return true;

        } catch (IllegalStateException ex) {
            System.err.println("No se pudo agregar el gasto");
            return false;
        }
    }

    @Override
    public Gasto consultar(int id) {
        try {
            EntityManager em = this.conexion.crearConexion();

            Gasto gasto = em.find(Gasto.class, id);

            return gasto;
        } catch (IllegalStateException ise) {
            System.err.println("No fue posible consultar el gasto");
            return null;
        }
    }
    
    @Override
    public List<Gasto> consultarTodos() {
        List<Gasto> ventas = null;

        try {

            EntityManager em = conexion.crearConexion();

            em.getTransaction().begin();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Gasto> criteria = builder.createQuery(Gasto.class);
            TypedQuery<Gasto> query = em.createQuery(criteria);

            ventas = query.getResultList();

            em.getTransaction().commit();
        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar todos los gastos");
            return null;
        }

        return ventas;
    }


    @Override
    public List<Gasto> buscarEntre(Calendar inicio, Calendar fin) {
        List<Gasto> gastos = null;

        try {

            EntityManager em = conexion.crearConexion();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String fechaInicio = dateFormat.format(inicio.getTimeInMillis());

            String fechaFin = dateFormat.format(fin.getTimeInMillis());

            return em.createQuery(String.format("SELECT v FROM Gasto v WHERE v.fecha >= '%s' AND v.fecha <= '%s'", fechaInicio, fechaFin)).getResultList();

        } catch (IllegalStateException ex) {
            System.err.println("No se pudieron consultar los gastos entre las fechas dadas");
            return null;
        }
    }

    @Override
    public boolean actualizar(Gasto gasto) {
        EntityManager em = conexion.crearConexion();

        try {
            em.getTransaction().begin();

            Gasto gastoBD = em.find(Gasto.class, gasto.getId());

            gastoBD.setFechaGasto(gasto.getFechaGasto());
            gastoBD.setConcepto(gasto.getConcepto());
            gastoBD.setCosto(gasto.getCosto());
            gastoBD.setAutoriza(gasto.getAutoriza());

            em.getTransaction().commit();
            return true;

        } catch (IllegalStateException ex) {
            System.err.println("No fue posible actualizar la caja");
            return false;
        }}

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
