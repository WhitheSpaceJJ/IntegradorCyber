package interfaces;

import entidades.Compra;
import entidades.Proveedor;
import java.util.Calendar;
import java.util.List;

public interface ICompraDAO extends IDAO<Compra>{

    List<Compra> buscarEntre (Calendar inicio, Calendar fin);
    
    List<Compra> buscarEntreProveedores (Calendar inicio, Calendar fin, Proveedor proveedor);
    
}
