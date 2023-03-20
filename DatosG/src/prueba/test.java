
package prueba;

import conexion.ConexionBD;
import entidades.Categoria;
import implementaciones.CategoriasDAO;
import interfaces.IConexionBD;

/**
 *
 * @author giova
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IConexionBD conexion = new ConexionBD();
        
        Categoria categoria = new Categoria("Dulces");
        
        CategoriasDAO categoriasDAO = new CategoriasDAO(conexion);
        
        categoriasDAO.agregar(categoria);
        
    }
    
}
