
package interfaces;

import entidades.DetalleCompra;
import entidades.Producto;
import java.util.List;

public interface IControlProductos {

    boolean agregar(Producto producto);
    
    boolean actualizar(Producto producto);
    
    boolean eliminar(int id);
    
  
    Producto consultar(int id);
    
    List<Producto> consultarPorNombre(String nombre);
    
    List<Producto> consultarTodos();
    
    
}
