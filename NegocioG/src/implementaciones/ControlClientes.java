package implementaciones;

import entidades.Cliente;
import fachada.FachadaDAO;
import interfaces.IConexionBD;
import java.util.List;
import interfaces.IControlClientes;


public class ControlClientes implements IControlClientes {

    private final FachadaDAO fachadaDAO;

    public ControlClientes(FachadaDAO fachadaDAO) {
        this.fachadaDAO=fachadaDAO;
    }
    @Override
    public boolean agregar(Cliente cliente) {
return this.fachadaDAO.agregarCliente(cliente);
    }

    @Override
    public boolean actualizar(Cliente cliente) {
return this.fachadaDAO.actualizarCliente(cliente);
    }

    @Override
    public boolean eliminar(int id) {
return this.fachadaDAO.eliminarCliente(id);
    }

    @Override
    public Cliente consultar(int id) {
        return this.fachadaDAO.consultarCliente(id);
    }

    @Override
    public List<Cliente> consultarTodos() {
       return this.fachadaDAO.consultarTodosClientes();
    }
}
