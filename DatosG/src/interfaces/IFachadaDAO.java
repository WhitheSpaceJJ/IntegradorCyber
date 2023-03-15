/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import entidades.*;

/**
 *
 * @author Jarol
 */
import java.util.Calendar;
import java.util.List;
public interface IFachadaDAO {
 
    
    
    public boolean agregarCaja(Caja caja);

    public boolean actualizarCaja(Caja caja);

    public boolean eliminarCaja(int id);

    public Caja consultarCaja(int id);

    public List<Caja> consultarCajas();

    //Gastos
    public int agregarGasto(Gasto gasto);
    
    public Gasto consultar(int id);

    public List<Gasto> consultarTodas();

    public List<Gasto> buscarGastosEntreFechas(Calendar inicio, Calendar fin);

    //Categorias
    public boolean agregarCategoria(Categoria categoria);

    public boolean actualizarCategoria(Categoria categoria);

    public boolean eliminarCategoria(int id);

    public Categoria consultarCategoria(int id);

    public List<Categoria> consultarTodasCategorias();

    //Clientes
    public boolean agregarCliente(Cliente cliente);

    public boolean actualizarCliente(Cliente cliente);

    public boolean eliminarCliente(int id);

    public Cliente consultarCliente(int id);

    public List<Cliente> consultarTodosClientes() ;
    //Proveedores
    public boolean agregarProveedor(Proveedor proveedor);
    
    public boolean actualizarProveedor(Proveedor proveedor);

    public boolean eliminarProveedor(int id);

    public Proveedor consultarProveedor(int id);

    public List<Proveedor> consultarTodosProveedores();

    // Venta
    public List<Venta> buscarVentasEntreFechas(Calendar inicio, Calendar fin);

    public List<Venta> buscarVentasEntreFechasPorCliente(Calendar inicio, Calendar fin, Cliente cliente);

    public Venta consultarVenta(int id);

    public List<Venta> consultarVentas();

    public int agregarVenta(Venta venta);

    //Detalle Venta
    public boolean agregarDetalleVenta(DetalleVenta detalleVenta);

    //compra Detalle
    public boolean agregarDetalleCompra(Compra entradaAlmacen);

    public Compra consultarDetalleCompra(int id);

    public List<Compra> consultarTodasEntradasAlmacen();

    public List<Compra> buscarEntradasAlmacenEntreFechas(Calendar inicio, Calendar fin);

    public List<Compra> buscarEntradasAlmacenEntreFechasYProveedor(Calendar inicio, Calendar fin, Proveedor proveedor);

    public List<Compra> buscarEntradasAlmacenEntreFechasYProducto(Calendar inicio, Calendar fin, Producto producto);

//Producto
    public Producto consultarProducto(int id);

    public boolean agregarProducto(Producto producto);

    public boolean actualizarProducto(Producto producto);

    public boolean eliminarProducto(int id);

    public boolean quitarStockProducto(Producto producto, int stock);

    public boolean agregarStockProducto(Producto producto, int stock);

    public List<Producto> buscarProductosPorNombre(String nombre);

    public List<Producto> consultarTodosProductos();
    //Usuario
    public boolean agregarUsuario(Usuario usuario);

    public boolean actualizarUsuario(Usuario usuario);

    public boolean eliminarUsuario(int id);

    public Usuario consultarUsuario(int id);

    public List<Usuario> consultarTodosUsuarios();

}
