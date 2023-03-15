package implementaciones;

import entidades.Proveedor;
import fachada.FachadaDAO;
import interfaces.IConexionBD;
import java.util.List;
import interfaces.IControlProveedores;

/**
 *
 * @author Giovanni Garrido
 */
public class ControlProveedores implements IControlProveedores {

 
    private final FachadaDAO fachadaDAO;

    public ControlProveedores(FachadaDAO fachadaDAO) {
        this.fachadaDAO=fachadaDAO;
    }

    @Override
    public boolean agregar(Proveedor proveedor) {
return this.fachadaDAO.agregarProveedor(proveedor);
    }

    @Override
    public boolean actualizar(Proveedor proveedor) {
return this.fachadaDAO.actualizarProveedor(proveedor);
       
    }

    @Override
    public boolean eliminar(int id) {

      return this.fachadaDAO.eliminarProducto(id);
    }

    @Override
    public Proveedor consultar(int id) {

      return this.fachadaDAO.consultarProveedor(id);
    }

    @Override
    public List<Proveedor> consultarTodos() {
     return this.fachadaDAO.consultarTodosProveedores();
    }

}
