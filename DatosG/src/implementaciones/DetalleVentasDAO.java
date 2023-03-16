package implementaciones;

import entidades.DetalleVenta;
import entidades.Producto;
import entidades.Venta;
import interfaces.IConexionBD;
import interfaces.IDetalleVentasDAO;
import interfaces.IProductosDAO;
import javax.persistence.EntityManager;

public class DetalleVentasDAO implements IDetalleVentasDAO {

   private final IConexionBD conexion;
    
    
    public DetalleVentasDAO(IConexionBD conexion){
        this.conexion = conexion;
    }
    
    @Override
    public boolean agregar(DetalleVenta venta){
        
       try{
           EntityManager em = this.conexion.crearConexion();
           em.getTransaction().begin();
           
      
           
           em.persist(venta);
           
           
           
           em.getTransaction().commit();
           return true;
       }catch (IllegalStateException ise){
           System.err.println("No fue posible guardar la venta");
           ise.printStackTrace();
           return false;
       }
    }


}
