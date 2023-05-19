
package interfaces;

import entidades.DetalleVenta;
import java.util.List;

public interface IDetalleVentasDAO extends IDAO<DetalleVenta>{
    
     public List<DetalleVenta> consultarTodas (int idVenta);
       public List<DetalleVenta> consultarTodas ();
    
}
