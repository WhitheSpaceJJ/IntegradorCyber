package fachada;

import entidades.Caja;
import entidades.Categoria;
import entidades.Cliente;
import entidades.Compra;
import entidades.DetalleVenta;
import entidades.Gasto;
import entidades.Producto;
import entidades.Proveedor;
import entidades.Usuario;
import entidades.Venta;
import fabrica.FabricaDAO;
import interfaces.ICajasDAO;
import interfaces.ICategoriasDAO;
import interfaces.IClientesDAO;
import interfaces.ICompraDAO;
import interfaces.IDetalleVentasDAO;
import interfaces.IGastosDAO;
import interfaces.IProductosDAO;
import interfaces.IProveedoresDAO;
import interfaces.IUsuariosDAO;
import interfaces.IVentasDAO;
import java.util.List;
import java.util.Calendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class FachadaDAO {

    private final FabricaDAO fabrica = FabricaDAO.getInstancia();

    //Cajas
    public boolean agregarCaja(Caja caja) {
        try {
            ICajasDAO cajasDAO = fabrica.getCajasDAO();
            return cajasDAO.agregar(caja);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarCaja(Caja caja) {
        try {
            ICajasDAO cajasDAO = fabrica.getCajasDAO();
            return cajasDAO.actualizar(caja);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarCaja(int id) {
        try {
            ICajasDAO cajasDAO = fabrica.getCajasDAO();
            return cajasDAO.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Caja consultarCaja(int id) {
        try {
            ICajasDAO cajasDAO = fabrica.getCajasDAO();
            return cajasDAO.consultar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Caja> consultarCajas() {
        try {
            ICajasDAO cajasDAO = fabrica.getCajasDAO();
            return cajasDAO.consultarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Gastos
    public int agregarGasto(Gasto gasto) {
        try {
            IGastosDAO gastosDAO = fabrica.getGastosDAO();
            return gastosDAO.agregar(gasto);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Gasto consultar(int id) {
        try {
            IGastosDAO gastosDAO = fabrica.getGastosDAO();
            return gastosDAO.consultar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Gasto> consultarTodas() {
        try {
            IGastosDAO gastosDAO = fabrica.getGastosDAO();
            return gastosDAO.consultarTodas();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Gasto> buscarGastosEntreFechas(Calendar inicio, Calendar fin) {
        try {
            IGastosDAO gastosDAO = fabrica.getGastosDAO();
            return gastosDAO.buscarEntre(inicio, fin);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Categorias
    public boolean agregarCategoria(Categoria categoria) {
        try {
            ICategoriasDAO categoriasDAO = fabrica.getCategoriasDAO();
            return categoriasDAO.agregar(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarCategoria(Categoria categoria) {
        try {
            ICategoriasDAO categoriasDAO = fabrica.getCategoriasDAO();
            return categoriasDAO.actualizar(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarCategoria(int id) {
        try {
            ICategoriasDAO categoriasDAO = fabrica.getCategoriasDAO();
            return categoriasDAO.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Categoria consultarCategoria(int id) {
        try {
            ICategoriasDAO categoriasDAO = fabrica.getCategoriasDAO();
            return categoriasDAO.consultar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Categoria> consultarTodasCategorias() {
        try {
            ICategoriasDAO categoriasDAO = fabrica.getCategoriasDAO();
            return categoriasDAO.consultarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Clientes
    public boolean agregarCliente(Cliente cliente) {
        try {
            IClientesDAO clientesDAO = fabrica.getClientesDAO();
            return clientesDAO.agregar(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarCliente(Cliente cliente) {
        try {
            IClientesDAO clientesDAO = fabrica.getClientesDAO();
            return clientesDAO.actualizar(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarCliente(int id) {
        try {
            IClientesDAO clientesDAO = fabrica.getClientesDAO();
            return clientesDAO.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Cliente consultarCliente(int id) {
        try {
            IClientesDAO clientesDAO = fabrica.getClientesDAO();
            return clientesDAO.consultar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cliente> consultarTodosClientes() {
        try {
            IClientesDAO clientesDAO = fabrica.getClientesDAO();
            return clientesDAO.consultarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Proveedores
    public boolean agregarProveedor(Proveedor proveedor) {
        try {
            IProveedoresDAO proveedoresDAO = fabrica.getProveedoresDAO();
            return proveedoresDAO.agregar(proveedor);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarProveedor(Proveedor proveedor) {
        try {
            IProveedoresDAO proveedoresDAO = fabrica.getProveedoresDAO();
            return proveedoresDAO.actualizar(proveedor);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProveedor(int id) {
        try {
            IProveedoresDAO proveedoresDAO = fabrica.getProveedoresDAO();
            return proveedoresDAO.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Proveedor consultarProveedor(int id) {
        try {
            IProveedoresDAO proveedoresDAO = fabrica.getProveedoresDAO();
            return proveedoresDAO.consultar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Proveedor> consultarTodosProveedores() {
        try {
            IProveedoresDAO proveedoresDAO = fabrica.getProveedoresDAO();
            return proveedoresDAO.consultarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Venta
    public List<Venta> buscarVentasEntreFechas(Calendar inicio, Calendar fin) {
        try {
            IVentasDAO ventasDAO = fabrica.getVentasDAO();
            return ventasDAO.buscarEntre(inicio, fin);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Venta> buscarVentasEntreFechasPorCliente(Calendar inicio, Calendar fin, Cliente cliente) {
        try {
            IVentasDAO ventasDAO = fabrica.getVentasDAO();
            return ventasDAO.buscarEntreCliente(inicio, fin, cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Venta consultarVenta(int id) {
        try {
            IVentasDAO ventasDAO = fabrica.getVentasDAO();
            return ventasDAO.consultar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Venta> consultarVentas() {
        try {
            IVentasDAO ventasDAO = fabrica.getVentasDAO();
            return ventasDAO.consultarTodas();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int agregarVenta(Venta venta) {
        try {
            IVentasDAO ventasDAO = fabrica.getVentasDAO();
            return ventasDAO.agregar(venta);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //Detalle Venta
    public boolean agregarDetalleVenta(DetalleVenta detalleVenta) {
        try {
            IDetalleVentasDAO detalleVentasDAO = fabrica.getDetalleVentasDAO();
            return detalleVentasDAO.agregar(detalleVenta);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //compra Detalle
    public boolean agregarDetalleCompra(Compra entradaAlmacen) {
        try {
            ICompraDAO detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.agregar(entradaAlmacen);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Compra consultarDetalleCompra(int id) {
        try {
            ICompraDAO detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.consultar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Compra> consultarTodasEntradasAlmacen() {
        try {
            ICompraDAO detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.consultarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Compra> buscarEntradasAlmacenEntreFechas(Calendar inicio, Calendar fin) {
        try {
            ICompraDAO detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.buscarEntre(inicio, fin);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Compra> buscarEntradasAlmacenEntreFechasYProveedor(Calendar inicio, Calendar fin, Proveedor proveedor) {
        try {
            ICompraDAO detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.buscarEntreProveedores(inicio, fin, proveedor);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Compra> buscarEntradasAlmacenEntreFechasYProducto(Calendar inicio, Calendar fin, Producto producto) {
        try {
            ICompraDAO detalleCompraDAO = fabrica.getDetalleCompraDAO();
            return detalleCompraDAO.buscarEntreProductos(inicio, fin, producto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//Producto
    public Producto consultarProducto(int id) {
        try {
            IProductosDAO productosDAO = fabrica.getProductosDAO();
            return productosDAO.consultar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean agregarProducto(Producto producto) {
        try {
            IProductosDAO productosDAO = fabrica.getProductosDAO();
            return productosDAO.agregar(producto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarProducto(Producto producto) {
        try {
            IProductosDAO productosDAO = fabrica.getProductosDAO();
            return productosDAO.actualizar(producto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(int id) {
        try {
            IProductosDAO productosDAO = fabrica.getProductosDAO();
            return productosDAO.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean quitarStockProducto(Producto producto, int stock) {
        try {
            IProductosDAO productosDAO = fabrica.getProductosDAO();
            return productosDAO.quitarStock(producto, stock);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean agregarStockProducto(Producto producto, int stock) {
        try {
            IProductosDAO productosDAO = fabrica.getProductosDAO();
            return productosDAO.agregarStock(producto, stock);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Producto> buscarProductosPorNombre(String nombre) {
        try {
            IProductosDAO productosDAO = fabrica.getProductosDAO();
            return productosDAO.consultarPorNombre(nombre);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Producto> consultarTodosProductos() {
        try {
            IProductosDAO productosDAO = fabrica.getProductosDAO();
            return productosDAO.consultarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Usuario
    public boolean agregarUsuario(Usuario usuario) {
        try {
            IUsuariosDAO usuariosDAO = fabrica.getUsuariosDAO();
            return usuariosDAO.agregar(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarUsuario(Usuario usuario) {
        try {
            IUsuariosDAO usuariosDAO = fabrica.getUsuariosDAO();
            return usuariosDAO.actualizar(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarUsuario(int id) {
        try {
            IUsuariosDAO usuariosDAO = fabrica.getUsuariosDAO();
            return usuariosDAO.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario consultarUsuario(int id) {
        try {
            IUsuariosDAO usuariosDAO = fabrica.getUsuariosDAO();
            return usuariosDAO.consultar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Usuario> consultarTodosUsuarios() {
        try {
            IUsuariosDAO usuariosDAO = fabrica.getUsuariosDAO();
            return usuariosDAO.consultarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
