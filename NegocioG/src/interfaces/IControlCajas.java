/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import entidades.Caja;
import java.util.List;

public interface IControlCajas {
    
    boolean agregar(Caja caja);
    
    boolean actualizar(Caja caja);
    
    boolean eliminar(int id);
    
    Caja consultar(int id);
    
    List<Caja> consultarTodos();
}