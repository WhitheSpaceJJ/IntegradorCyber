package implementaciones;

import entidades.DetalleVenta;
import interfaces.IConexionBD;
import interfaces.IDetalleVentasDAO;
import java.util.List;
import javax.persistence.EntityManager;

public class DetalleVentasDAO implements IDetalleVentasDAO {

   private final IConexionBD conexion;
    
    
    public DetalleVentasDAO(IConexionBD conexion){
        this.conexion = conexion;
    }
    
    @Override
    public boolean agregar(DetalleVenta detalleVenta){
        
       try{
           EntityManager em = this.conexion.crearConexion();
           em.getTransaction().begin();

           em.persist(detalleVenta);

           em.getTransaction().commit();
           return true;
       }catch (IllegalStateException ise){
           System.err.println("No fue posible guardar la venta.");
           return false;
       }
    }

    @Override
    public boolean actualizar(DetalleVenta t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleVenta consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DetalleVenta> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
