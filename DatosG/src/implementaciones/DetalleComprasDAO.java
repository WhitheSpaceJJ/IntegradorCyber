package implementaciones;

import entidades.DetalleCompra;
import interfaces.IConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import interfaces.IDetalleCompraDAO;

public class DetalleComprasDAO implements IDetalleCompraDAO {

   private final IConexionBD conexion;
    
    
    public DetalleComprasDAO(IConexionBD conexion){
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(DetalleCompra detalleCompra) {
       try{
           EntityManager em = this.conexion.crearConexion();
           em.getTransaction().begin();

           em.persist(detalleCompra);

           em.getTransaction().commit();
           return true;
       }catch (IllegalStateException ise){
           System.err.println("No fue posible guardar la venta.");
           return false;
       }}

    @Override
    public boolean actualizar(DetalleCompra t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleCompra consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DetalleCompra> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    


}
