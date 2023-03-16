
package fabrica;

import implementaciones.*;
import conexion.ConexionBD;

public class FabricaDAO {

    private static FabricaDAO instancia;
    private CategoriasDAO instanceCategoriasDAO;
    private ClientesDAO instanceClientesDAO;
    private ProductosDAO instancePRoductosDAO;
    private ProveedoresDAO instanceProveedoresDAO;
    private UsuariosDAO instanceUsuariosDAO;
    private VentasDAO instanceVentasDAO;
    private final ConexionBD instanceConexionBD;
    private DetalleVentasDAO instanceDetalleVentasDAO;
    private CompraDAO instanceDetalleCompraDAO;
    private CajasDAO instanceCajaDAO;
private GastosDAO instanceGastosDAO;

    private FabricaDAO() {
        instanceConexionBD = new ConexionBD();

    }
  public CajasDAO getCajasDAO(){
      if(instanceCajaDAO==null){
          instanceCajaDAO=new CajasDAO(instanceConexionBD,getUsuariosDAO());
      }
      return instanceCajaDAO;
  }
  public GastosDAO getGastosDAO(){
      if(instanceGastosDAO==null){
          instanceGastosDAO=new GastosDAO(instanceConexionBD);
      }
      return instanceGastosDAO;
  }
    public static FabricaDAO getInstancia() {
        if (instancia == null) {
            instancia = new FabricaDAO();
        }
        return instancia;
    }

    public DetalleVentasDAO getDetalleVentasDAO() {
        if (instanceDetalleVentasDAO == null) {
            instanceDetalleVentasDAO = new DetalleVentasDAO(instanceConexionBD, getProductosDAO());
        }
        return instanceDetalleVentasDAO;
    }

    public CompraDAO getDetalleCompraDAO() {
        if (instanceDetalleCompraDAO == null) {
            instanceDetalleCompraDAO = new CompraDAO(instanceConexionBD,getProveedoresDAO(),getProductosDAO());
        }
        return instanceDetalleCompraDAO;
    }

    public CategoriasDAO getCategoriasDAO() {
        if (instanceCategoriasDAO == null) {
            instanceCategoriasDAO = new CategoriasDAO(instanceConexionBD);
        }
        return instanceCategoriasDAO;
    }

    public ClientesDAO getClientesDAO() {
        if (instanceClientesDAO == null) {
            instanceClientesDAO = new ClientesDAO(instanceConexionBD);
        }
        return instanceClientesDAO;
    }

    public ProductosDAO getProductosDAO() {

        if (instancePRoductosDAO == null) {
            instancePRoductosDAO = new ProductosDAO(instanceConexionBD);
        }

        return instancePRoductosDAO;
    }

    public ProveedoresDAO getProveedoresDAO() {
        if (instanceProveedoresDAO == null) {
            instanceProveedoresDAO = new ProveedoresDAO(instanceConexionBD);
        }
        return instanceProveedoresDAO;
    }

    public UsuariosDAO getUsuariosDAO() {
        if (instanceUsuariosDAO == null) {
            instanceUsuariosDAO = new UsuariosDAO(instanceConexionBD);
        }
        return instanceUsuariosDAO;
    }

    public VentasDAO getVentasDAO() {
        if (instanceVentasDAO == null) {
            instanceVentasDAO = new VentasDAO(instanceConexionBD);
        }
        return instanceVentasDAO;
    }
}
