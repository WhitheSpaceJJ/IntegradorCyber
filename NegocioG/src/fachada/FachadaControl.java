package fachada;

import entidades.Caja;
import entidades.Categoria;
import entidades.*;
import entidades.DetalleCompra;
import entidades.DetalleVenta;
import entidades.Gasto;
import entidades.Producto;
import entidades.Proveedor;
import entidades.Usuario;
import entidades.Venta;
import enumeradores.Estado;
import fabrica.FabricaControl;
import java.util.List;
import java.util.Calendar;
import interfaces.IControlCajas;
import interfaces.IControlCategorias;
import interfaces.IControlCompra;
import interfaces.IControlClientes;
import interfaces.IControlDetalleVentas;
import interfaces.IControlGastos;
import interfaces.IControlProductos;
import interfaces.IControlProveedores;
import interfaces.IControlUsuarios;
import interfaces.IControlVentas;
import interfaces.IFachadaControl;
import java.util.ArrayList;


public class FachadaControl implements IFachadaControl {

    private final FabricaControl fabrica;
   

    public FachadaControl() {
        this.fabrica=FabricaControl.getInstancia();
    }

    

    // Venta
     @Override
    public List<Venta> buscarVentasEntreFechas(Calendar inicio, Calendar fin) {
        try {
            IControlVentas ventasDAO = fabrica.getVentasDAO();
            return ventasDAO.buscarEntre(inicio, fin);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<Venta> buscarVentasEntreFechasPorCliente(Calendar inicio, Calendar fin, Cliente cliente) {
        try {
            IControlVentas ventasDAO = fabrica.getVentasDAO();
            return ventasDAO.buscarEntreCliente(inicio, fin, cliente);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public Venta consultarVenta(int id) {
        try {
            IControlVentas ventasDAO = fabrica.getVentasDAO();
            return ventasDAO.consultar(id);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<Venta> consultarVentas() {
        try {
            IControlVentas ventasDAO = fabrica.getVentasDAO();
            return ventasDAO.consultarTodas();
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<Venta> buscarVentasEntreFechasYCliente(Calendar inicio, Calendar fin, Cliente cliente) {
        try {
            IControlVentas ventasDAO = fabrica.getVentasDAO();
            return ventasDAO.buscarEntreCliente(inicio, fin, cliente);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public int agregarVenta(Venta venta) {
        try {
            IControlVentas ventasDAO = fabrica.getVentasDAO();
            return ventasDAO.agregar(venta);
        } catch (Exception e) {
            return -1;
        }
    }

    //Detalle Venta
    @Override
    public boolean agregarDetalleVenta(DetalleVenta detalleVenta) {
        try {
            IControlDetalleVentas detalleVentasDAO = fabrica.getDetalleVentasDAO();
            return detalleVentasDAO.agregar(detalleVenta);
        } catch (Exception e) {
            return false;
        }
    }

    //compra Detalle
     @Override
    public boolean agregarDetalleCompra(DetalleCompra entradaAlmacen) {
        try {
            IControlCompra detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.agregar(entradaAlmacen);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public DetalleCompra consultarDetalleCompra(int id) {
        try {
            IControlCompra detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.consultar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

     @Override
    public List<DetalleCompra> consultarTodasEntradasAlmacen() {
        try {
            IControlCompra detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.consultarTodos();
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<DetalleCompra> buscarEntradasAlmacenEntreFechas(Calendar inicio, Calendar fin) {
        try {
            IControlCompra detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.buscarEntre(inicio, fin);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<DetalleCompra> buscarEntradasAlmacenEntreFechasYProveedor(Calendar inicio, Calendar fin, Proveedor proveedor) {
        try {
            IControlCompra detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.buscarEntreProveedores(inicio, fin, proveedor);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<DetalleCompra> buscarEntradasAlmacenEntreFechasYProducto(Calendar inicio, Calendar fin, Producto producto) {
        try {
            IControlCompra detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.buscarEntreProductos(inicio, fin, producto);
        } catch (Exception e) {
            return null;
        }
    }

//Producto 
    @Override
    public Producto consultarProducto(int id) {
        try {
            IControlProductos productosDAO = fabrica.getProductosDAO();
            return productosDAO.consultar(id);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public boolean agregarProducto(Producto producto) {
        try {
            IControlProductos productosDAO = fabrica.getProductosDAO();
            return productosDAO.agregar(producto);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public boolean actualizarProducto(Producto producto) {
        try {
            IControlProductos productosDAO = fabrica.getProductosDAO();
            return productosDAO.actualizar(producto);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public boolean eliminarProducto(int id) {
        try {
            IControlProductos productosDAO = fabrica.getProductosDAO();
            return productosDAO.eliminar(id);
        } catch (Exception e) {
            return false;
        }
    }


     @Override
    public List<Producto> buscarProductosPorNombre(String nombre) {
        try {
            IControlProductos productosDAO = fabrica.getProductosDAO();
            return productosDAO.consultarPorNombre(nombre);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<Producto> consultarTodosProductos() {
        try {
            IControlProductos productosDAO = fabrica.getProductosDAO();
            return productosDAO.consultarTodos();
        } catch (Exception e) {
            return null;
        }
    }
//Clases  que sean de agregar,actualizar eliminar, consultar ID, consultar todos
    //Usuarios
     @Override
    public boolean agregarUsuario(Usuario usuario) {
        try {
            IControlUsuarios usuariosDAO = fabrica.getUsuariosDAO();
            return usuariosDAO.agregar(usuario);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public boolean actualizarUsuario(Usuario usuario) {
        try {
            IControlUsuarios usuariosDAO = fabrica.getUsuariosDAO();
            return usuariosDAO.actualizar(usuario);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public boolean eliminarUsuario(int id) {
        try {
            IControlUsuarios usuariosDAO = fabrica.getUsuariosDAO();
            return usuariosDAO.eliminar(id);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public Usuario consultarUsuario(int id) {
        try {
            IControlUsuarios usuariosDAO = fabrica.getUsuariosDAO();
            return usuariosDAO.consultar(id);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<Usuario> consultarTodosUsuarios() {
        try {
            IControlUsuarios usuariosDAO = fabrica.getUsuariosDAO();
            return usuariosDAO.consultarTodos();
        } catch (Exception e) {
            return null;
        }
    }

    //Proveedores
     @Override
    public boolean agregarProveedor(Proveedor proveedor) {
        try {
            IControlProveedores proveedoresDAO = fabrica.getProveedoresDAO();
            return proveedoresDAO.agregar(proveedor);
        } catch (Exception e) {
            return false;
        }
    }
 @Override
    public boolean actualizarProveedor(Proveedor proveedor) {
        try {
            IControlProveedores proveedoresDAO = fabrica.getProveedoresDAO();
            return proveedoresDAO.actualizar(proveedor);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public boolean eliminarProveedor(int id) {
        try {
            IControlProveedores proveedoresDAO = fabrica.getProveedoresDAO();
            return proveedoresDAO.eliminar(id);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public Proveedor consultarProveedor(int id) {
        try {
            IControlProveedores proveedoresDAO = fabrica.getProveedoresDAO();
            return proveedoresDAO.consultar(id);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<Proveedor> consultarTodosProveedores() {
        try {
            IControlProveedores proveedoresDAO = fabrica.getProveedoresDAO();
            return proveedoresDAO.consultarTodos();
        } catch (Exception e) {
            return null;
        }
    }

    //Categorias
     @Override
    public boolean agregarCategoria(Categoria categoria) {
        try {
            IControlCategorias categoriasDAO = fabrica.getCategoriasDAO();
            return categoriasDAO.agregar(categoria);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public boolean actualizarCategoria(Categoria categoria) {
        try {
            IControlCategorias categoriasDAO = fabrica.getCategoriasDAO();
            return categoriasDAO.actualizar(categoria);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public boolean eliminarCategoria(int id) {
        try {
            IControlCategorias categoriasDAO = fabrica.getCategoriasDAO();
            return categoriasDAO.eliminar(id);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public Categoria consultarCategoria(int id) {
        try {
            IControlCategorias categoriasDAO = fabrica.getCategoriasDAO();
            return categoriasDAO.consultar(id);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<Categoria> consultarTodasCategorias() {
        try {
            IControlCategorias categoriasDAO = fabrica.getCategoriasDAO();
            return categoriasDAO.consultarTodos();
        } catch (Exception e) {
            return null;
        }
    }

    //Clientes
     @Override
    public boolean agregarCliente(Cliente cliente) {
        try {
            IControlClientes clientesDAO = fabrica.getClientesDAO();
            return clientesDAO.agregar(cliente);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public boolean actualizarCliente(Cliente cliente) {
        try {
            IControlClientes clientesDAO = fabrica.getClientesDAO();
            return clientesDAO.actualizar(cliente);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public boolean eliminarCliente(int id) {
        try {
            IControlClientes clientesDAO = fabrica.getClientesDAO();
            return clientesDAO.eliminar(id);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public Cliente consultarCliente(int id) {
        try {
            IControlClientes clientesDAO = fabrica.getClientesDAO();
            return clientesDAO.consultar(id);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<Cliente> consultarTodosClientes() {
        try {
            IControlClientes clientesDAO = fabrica.getClientesDAO();
            return clientesDAO.consultarTodos();
        } catch (Exception e) {
            return null;
        }
    }
    
    //Cajas
    @Override
    public boolean agregarCaja(Caja caja) {
        try {
            IControlCajas cajasDAO = fabrica.getCajasDAO();
            return cajasDAO.agregar(caja);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean actualizarCaja(Caja caja) {
        try {
            IControlCajas cajasDAO = fabrica.getCajasDAO();
            return cajasDAO.actualizar(caja);
        } catch (Exception e) {
            return false;
        }
    }

     @Override
    public boolean eliminarCaja(int id) {
        try {
            IControlCajas cajasDAO = fabrica.getCajasDAO();
            return cajasDAO.eliminar(id);
        } catch (Exception e) {
            return false;
        }
    }

    
     @Override
    public Caja consultarCaja(int id) {
        try {
            IControlCajas cajasDAO = fabrica.getCajasDAO();
            return cajasDAO.consultar(id);
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
     public Caja consultarCajaAbierta(){
         List<Caja> cajasObtenidas= new ArrayList();
       
         try {
            IControlCajas cajasDAO = fabrica.getCajasDAO();
            cajasObtenidas=cajasDAO.consultarTodos();
            for(int i=0;i<cajasObtenidas.size();i++){
                if(cajasObtenidas.get(i).getEstado()== Estado.ABIERTA){
                    return cajasObtenidas.get(i);
                    
                }
           
            }
        } catch (Exception e) {
            return null;
        }
        return null;
         
     }

     @Override
    public List<Caja> consultarCajas() {
        try {
            IControlCajas cajasDAO = fabrica.getCajasDAO();
            return cajasDAO.consultarTodos();
        } catch (Exception e) {
            return null;
        }
    }

    //Gastos
     @Override
    public int agregarGasto(Gasto gasto) {
        try {
            IControlGastos gastosDAO = fabrica.getGastosDAO();
            return gastosDAO.agregar(gasto);
        } catch (Exception e) {
            return -1;
        }
    }

     @Override
    public Gasto consultar(int id) {
        try {
            IControlGastos gastosDAO = fabrica.getGastosDAO();
            return gastosDAO.consultar(id);
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<Gasto> consultarTodas() {
        try {
            IControlGastos gastosDAO = fabrica.getGastosDAO();
            return gastosDAO.consultarTodas();
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<Gasto> buscarGastosEntreFechas(Calendar inicio, Calendar fin) {
        try {
            IControlGastos gastosDAO = fabrica.getGastosDAO();
            return gastosDAO.buscarEntre(inicio, fin);
        } catch (Exception e) {
            return null;
        }
    }

}
