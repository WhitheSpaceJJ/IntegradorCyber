package implementaciones;

import entidades.Usuario;
import fachada.FachadaDAO;
import interfaces.IConexionBD;
import java.util.List;

import interfaces.IControlUsuarios;


public class ControlUsuarios implements IControlUsuarios{

  
    private final FachadaDAO fachadaDAO;

    public ControlUsuarios(FachadaDAO fachadaDAO) {
        this.fachadaDAO=fachadaDAO;
    }

    @Override
    public boolean agregar(Usuario usuario) {
return this.fachadaDAO.agregarUsuario(usuario);
    }

    @Override
    public boolean actualizar(Usuario usuario) {
return this.fachadaDAO.actualizarUsuario(usuario);
    }

    @Override
    public boolean eliminar(int id) {
return this.fachadaDAO.eliminarUsuario(id);
    }

    @Override
    public Usuario consultar(int id) {
return this.fachadaDAO.consultarUsuario(id);
    }

    @Override
    public List<Usuario> consultarTodos() {
 return this.fachadaDAO.consultarTodosUsuarios();
    }
}
