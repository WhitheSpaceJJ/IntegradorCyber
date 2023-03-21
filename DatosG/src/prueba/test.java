
package prueba;

import conexion.ConexionBD;
import entidades.Categoria;
import entidades.Producto;
import implementaciones.CategoriasDAO;
import implementaciones.ProductosDAO;
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
        
        //Categoria categoria = new Categoria("Papeleria");
        
        CategoriasDAO categoriasDAO = new CategoriasDAO(conexion);
        
        Categoria categoria = categoriasDAO.consultar(5);
        
        ProductosDAO productosDAO = new ProductosDAO(conexion);
        
        //Producto producto = new Producto("Maza", "Dulce de cacahuate", "De la Rosa", 23, 100, 10, 6, categoria);
        Producto producto = productosDAO.consultar(1);
        
        producto.setCategoria(categoria);
        productosDAO.actualizar(producto);
    }
    
}
