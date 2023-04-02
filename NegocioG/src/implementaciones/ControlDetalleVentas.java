package implementaciones;

import entidades.DetalleVenta;

import interfaces.IControlDetalleVentas;
import interfaces.IFachadaDAO;

public class ControlDetalleVentas implements IControlDetalleVentas {


    private final IFachadaDAO fachadaDAO;

    public ControlDetalleVentas(IFachadaDAO fachadaDAO) {
        this.fachadaDAO=fachadaDAO;
    }
    
    @Override
    public boolean agregar(DetalleVenta venta){
      
     return this.fachadaDAO.agregarDetalleVenta(venta);
    }


}
