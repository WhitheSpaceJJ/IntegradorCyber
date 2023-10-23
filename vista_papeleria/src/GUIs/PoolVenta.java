/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIs;

import java.util.ArrayList;
import java.util.List;

public class PoolVenta {

    private List<VentasForm> ventasFrames;
    private List<BusquedaArticuloForm> busquedasFrames;
    private static PoolVenta instance;

    private PoolVenta() {
        this.ventasFrames = new ArrayList<>();
        this.busquedasFrames = new ArrayList<>();
    }

    public static PoolVenta getInstance() {
        if (instance == null) {
            instance = new PoolVenta();
        }
        return instance;
    }

    public VentasForm getVenta(int indice) {
        return ventasFrames.get(indice);
    }

    public void addVentas(VentasForm ventasForm, BusquedaArticuloForm busquedaArticuloForm) {
        ventasFrames.add(ventasForm);
        busquedasFrames.add(busquedaArticuloForm);
    }
}
