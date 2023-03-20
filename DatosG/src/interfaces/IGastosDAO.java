
package interfaces;

import entidades.Gasto;
import java.util.Calendar;
import java.util.List;

public interface IGastosDAO extends IDAO<Gasto>{
    
    List<Gasto> buscarEntre(Calendar inicio , Calendar fin);   
    
}