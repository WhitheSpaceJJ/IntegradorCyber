package implementaciones;

import entidades.Compra;
import entidades.Producto;
import entidades.Proveedor;
import fachada.FachadaDAO;

import interfaces.IConexionBD;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import interfaces.IControlCompra;
import interfaces.IControlProductos;
import interfaces.IControlProveedores;

public class ControlCompra implements IControlCompra {

    private final FachadaDAO fachadaDAO;

    public ControlCompra(FachadaDAO fachadaDAO) {
        this.fachadaDAO = fachadaDAO;
    }

    @Override
    public boolean agregar(Compra entradaAlmacen) {
return this.fachadaDAO.agregarDetalleCompra(entradaAlmacen);
    }

    @Override
    public Compra consultar(int id) {
return this.fachadaDAO.consultarDetalleCompra(id);
    }

    @Override
    public List<Compra> consultarTodos() {
return this.fachadaDAO.consultarTodasEntradasAlmacen();
    }

    @Override
    public List<Compra> buscarEntre(Calendar inicio, Calendar fin) {
return this.fachadaDAO.buscarEntradasAlmacenEntreFechas(inicio, fin);
    }

    @Override
    public List<Compra> buscarEntreProveedores(Calendar inicio, Calendar fin, Proveedor proveedor) {
return this.fachadaDAO.buscarEntradasAlmacenEntreFechasYProveedor(inicio, fin, proveedor);
    }

    @Override
    public List<Compra> buscarEntreProductos(Calendar inicio, Calendar fin, Producto producto) {
        return this.fachadaDAO.buscarEntradasAlmacenEntreFechasYProducto(inicio, fin, producto);
    }

}
