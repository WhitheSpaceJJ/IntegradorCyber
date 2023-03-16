/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

import implementaciones.*;
import conexion.ConexionBD;
import fachada.FachadaControl;
import fachada.FachadaDAO;
import interfaces.IFachadaDAO;

public class FabricaControl {

    private static FabricaControl instancia;
    private ControlCategoria instanceCategoriasDAO;
    private ControlClientes instanceClientesDAO;
    private ControlProductos instancePRoductosDAO;
    private ControlProveedores instanceProveedoresDAO;
    private ControlUsuarios instanceUsuariosDAO;
    private ControlVentas instanceVentasDAO;
    private ControlDetalleVentas instanceDetalleVentasDAO;
    private ControlCompra instanceDetalleCompraDAO;
    private ControlCajas instanceCajaDAO;
private ControlGastos instanceGastosDAO;
private IFachadaDAO fachadaDAO;
    private FabricaControl() {
        fachadaDAO=new FachadaDAO();
    }
  public ControlCajas getCajasDAO(){
      if(instanceCajaDAO==null){
          instanceCajaDAO=new ControlCajas(fachadaDAO);
      }
      return instanceCajaDAO;
  }
  public ControlGastos getGastosDAO(){
      if(instanceGastosDAO==null){
          instanceGastosDAO=new ControlGastos(fachadaDAO);
      }
      return instanceGastosDAO;
  }
    public static FabricaControl getInstancia() {
        if (instancia == null) {
            instancia = new FabricaControl();
        }
        return instancia;
    }

    public ControlDetalleVentas getDetalleVentasDAO() {
        if (instanceDetalleVentasDAO == null) {
            instanceDetalleVentasDAO = new ControlDetalleVentas(fachadaDAO);
        }
        return instanceDetalleVentasDAO;
    }

    public ControlCompra getDetalleCompraDAO() {
        if (instanceDetalleCompraDAO == null) {
            instanceDetalleCompraDAO = new ControlCompra(fachadaDAO);
        }
        return instanceDetalleCompraDAO;
    }

    public ControlCategoria getCategoriasDAO() {
        if (instanceCategoriasDAO == null) {
            instanceCategoriasDAO = new ControlCategoria(fachadaDAO);
        }
        return instanceCategoriasDAO;
    }

    public ControlClientes getClientesDAO() {
        if (instanceClientesDAO == null) {
            instanceClientesDAO = new ControlClientes(fachadaDAO);
        }
        return instanceClientesDAO;
    }

    public ControlProductos getProductosDAO() {

        if (instancePRoductosDAO == null) {
            instancePRoductosDAO = new ControlProductos(fachadaDAO);
        }

        return instancePRoductosDAO;
    }

    public ControlProveedores getProveedoresDAO() {
        if (instanceProveedoresDAO == null) {
            instanceProveedoresDAO = new ControlProveedores(fachadaDAO);
        }
        return instanceProveedoresDAO;
    }

    public ControlUsuarios getUsuariosDAO() {
        if (instanceUsuariosDAO == null) {
            instanceUsuariosDAO = new ControlUsuarios(fachadaDAO);
        }
        return instanceUsuariosDAO;
    }

    public ControlVentas getVentasDAO() {
        if (instanceVentasDAO == null) {
            instanceVentasDAO = new ControlVentas(fachadaDAO);
        }
        return instanceVentasDAO;
    }
}
