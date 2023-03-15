
package implementaciones;

import entidades.Caja;
import entidades.Cliente;
import entidades.Venta;
import fachada.FachadaDAO;
import interfaces.IConexionBD;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import interfaces.IControlCajas;
import interfaces.IControlClientes;
import interfaces.IControlVentas;
import interfaces.IFachadaDAO;

public class ControlVentas implements IControlVentas{
    
    
    private final IFachadaDAO fachadaDAO;

    public ControlVentas(IFachadaDAO fachadaDAO) {
        this.fachadaDAO=fachadaDAO;
    }
    
    @Override
    public int agregar(Venta venta){
    return this.fachadaDAO.agregarVenta(venta);
    }

    @Override
    public Venta consultar(int id) {
       return this.fachadaDAO.consultarVenta(id);
    }

    @Override
    public List<Venta> consultarTodas() {
       return this.fachadaDAO.consultarVentas();
    }

    @Override
    public List<Venta> buscarEntre(Calendar inicio, Calendar fin) {
   return this.fachadaDAO.buscarVentasEntreFechas(inicio, fin);
    }
    
    @Override
    public List<Venta> buscarEntreCliente(Calendar inicio, Calendar fin, Cliente cliente) {
     return this.fachadaDAO.buscarVentasEntreFechasPorCliente(inicio, fin, cliente);
    }
    
}
