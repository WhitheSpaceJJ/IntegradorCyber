package implementaciones;

import entidades.Caja;
import entidades.Usuario;
import fachada.FachadaDAO;
import interfaces.IConexionBD;
import java.util.List;
import interfaces.IControlCajas;
import interfaces.IControlUsuarios;

public class ControlCajas implements IControlCajas {

   
    private final FachadaDAO fachadaDAO;

    public ControlCajas(FachadaDAO fachadaDAO) {
        this.fachadaDAO=fachadaDAO;
    }
    @Override
    public boolean agregar(Caja caja) {
  return this.fachadaDAO.agregarCaja(caja);
    }

    @Override
    public boolean actualizar(Caja caja) {
       return this.fachadaDAO.actualizarCaja(caja);
    }

    @Override
    public boolean eliminar(int id) {
       return this.fachadaDAO.eliminarCaja(id);
    }

    @Override
    public Caja consultar(int id) {
       return this.fachadaDAO.consultarCaja(id);
    }

    @Override
    public List<Caja> consultarTodos() {
      return this.fachadaDAO.consultarCajas();
    }
}
