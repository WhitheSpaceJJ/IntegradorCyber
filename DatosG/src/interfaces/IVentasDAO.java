package interfaces;

import entidades.Cliente;
import entidades.Venta;
import java.util.Calendar;
import java.util.List;

public interface IVentasDAO extends IDAO<Venta>{

    
    List<Venta> buscarEntre(Calendar inicio , Calendar fin);   
    
    List<Venta> buscarEntreCliente(Calendar inicio, Calendar fin, Cliente cliente);
    
    
}
