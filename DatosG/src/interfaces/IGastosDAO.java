/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import entidades.Gasto;
import java.util.Calendar;
import java.util.List;

public interface IGastosDAO {
    
    int agregar(Gasto gasto);
    
    Gasto consultar(int id);
    
    List<Gasto> consultarTodas();
    
    List<Gasto> buscarEntre(Calendar inicio , Calendar fin);   
    
}