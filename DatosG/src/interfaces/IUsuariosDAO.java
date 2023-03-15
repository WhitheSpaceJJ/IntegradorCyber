package interfaces;

import entidades.Usuario;
import java.util.List;


public interface IUsuariosDAO {

    boolean agregar(Usuario usuario);

    boolean actualizar(Usuario usuario);

    boolean eliminar(int id);

    Usuario consultar(int id);

    List<Usuario> consultarTodos();


}
