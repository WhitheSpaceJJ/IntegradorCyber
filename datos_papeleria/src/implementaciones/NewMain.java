/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package implementaciones;

import entidades.Compra;
import entidades.Venta;
import fachada.FachadaDAO;
import interfaces.IFachadaDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author josej
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Object[] parametros = new Object[5];
        parametros[0] = null;
        parametros[1] =  null;

        // Crear una instancia de Calendar y establecer la fecha y hora
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 9, 22, 0, 0, 0); // Asumiendo que 2023 es el año, 9 es octubre (los meses comienzan desde 0), y 24 es el día

                // Crear una instancia de Calendar y establecer la fecha y hora
        Calendar calendar5 = Calendar.getInstance();
        calendar5.set(2023, 9, 24, 0, 0, 0); // Asumiendo que 2023 es el año, 9 es octubre (los meses comienzan desde 0), y 24 es el día

        parametros[2] = null;
        parametros[3] = null;
        parametros[4] = null;

        IFachadaDAO fachadaDAO = new FachadaDAO();
        List<Venta> ventas = fachadaDAO.consultarVentasCoincidencias(parametros);
        System.out.println(ventas == null ? "" + 0 : "" + ventas.size());

        // Crear instancias de Calendar para las fechas de inicio y fin
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2023, 9, 23, 0, 0, 0); // Asumiendo que 2023 es el año, 9 es octubre, y 23 es el día

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2023, 9, 25, 0, 0, 0); // Asumiendo que 2023 es el año, 9 es octubre, y 25 es el día

        List<Venta> venta22 = fachadaDAO.buscarVentasEntreFechas(calendar1, calendar2);
        System.out.println(venta22 == null ? "" + 0 : "" + venta22.size());
    }

}
