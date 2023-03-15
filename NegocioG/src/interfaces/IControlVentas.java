package interfaces;

import entidades.Cliente;
import entidades.Venta;
import java.util.Calendar;
import java.util.List;

public interface IControlVentas {

    int agregar(Venta venta);
    
    Venta consultar(int id);
    
    List<Venta> consultarTodas();
    
    List<Venta> buscarEntre(Calendar inicio , Calendar fin);   
    
    List<Venta> buscarEntreCliente(Calendar inicio, Calendar fin, Cliente cliente);
    
    
}
