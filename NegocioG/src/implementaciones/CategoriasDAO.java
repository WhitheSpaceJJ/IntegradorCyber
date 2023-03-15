package implementaciones;

import entidades.Categoria;
import entidades.Cliente;
import fachada.FachadaDAO;
import interfaces.IConexionBD;
import java.util.List;
import interfaces.IControlCategorias;

public class CategoriasDAO implements IControlCategorias {

    private final FachadaDAO fachadaDAO;

    public CategoriasDAO(FachadaDAO fachadaDAO) {
        this.fachadaDAO=fachadaDAO;
    }

    @Override
    public boolean agregar(Categoria categoria) {
        return fachadaDAO.agregarCategoria(categoria);
    }

    @Override
    public boolean actualizar(Categoria categoria) {
 return fachadaDAO.actualizarCategoria(categoria);
    }

    @Override
    public boolean eliminar(int id) {
 return fachadaDAO.eliminarCategoria(id);    }

    @Override
    public Categoria consultar(int id) {
 return fachadaDAO.consultarCategoria(id);
    }

    @Override
    public List<Categoria> consultarTodos() {
 return fachadaDAO.consultarTodasCategorias();
    }

   

}
