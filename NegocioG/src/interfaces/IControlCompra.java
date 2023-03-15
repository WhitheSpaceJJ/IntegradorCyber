package interfaces;

import entidades.Compra;
import entidades.Producto;
import entidades.Proveedor;
import java.util.Calendar;
import java.util.List;

public interface IControlCompra {

    boolean agregar(Compra entradaAlmacen);

    Compra consultar(int id);

    List<Compra> consultarTodos();
    
    List<Compra> buscarEntre (Calendar inicio, Calendar fin);
    
    List<Compra> buscarEntreProveedores (Calendar inicio, Calendar fin, Proveedor proveedor);
    
    List<Compra> buscarEntreProductos (Calendar inicio, Calendar fin, Producto producto);
    
}
