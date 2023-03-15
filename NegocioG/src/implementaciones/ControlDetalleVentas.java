package implementaciones;

import entidades.DetalleVenta;
import entidades.Producto;
import entidades.Venta;
import fachada.FachadaDAO;
import interfaces.IConexionBD;
import interfaces.IControlDetalleVentas;
import interfaces.IControlProductos;

public class ControlDetalleVentas implements IControlDetalleVentas {


    private final FachadaDAO fachadaDAO;

    public ControlDetalleVentas(FachadaDAO fachadaDAO) {
        this.fachadaDAO=fachadaDAO;
    }
    
    @Override
    public boolean agregar(DetalleVenta venta){
      
     return this.fachadaDAO.agregarDetalleVenta(venta);
    }


}
