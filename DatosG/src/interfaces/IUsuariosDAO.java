package interfaces;

import entidades.Usuario;


public interface IUsuariosDAO extends IDAO<Usuario>{
 public boolean iniciarSesion(Usuario usuario) ;

}
