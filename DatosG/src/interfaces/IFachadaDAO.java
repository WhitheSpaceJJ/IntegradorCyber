package interfaces;

import entidades.*;

import java.util.Calendar;
import java.util.List;

public interface IFachadaDAO {

    //Caja
    public boolean agregarCaja(Caja caja);

    public boolean actualizarCaja(Caja caja);

    public boolean eliminarCaja(int id);

    public Caja consultarCaja(int id);

    public List<Caja> consultarCajas();

    //Gastos
    public boolean agregarGasto(Gasto gasto);

    public boolean actualizarGasto(Gasto gasto);

    public Gasto consultar(int id);

    public List<Gasto> consultarTodos();

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

    public List<Cliente> consultarTodosClientes();

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

    public List<Venta> consultarTodasVentas();

    public boolean agregarVenta(Venta venta);

    //Detalle Venta
    public boolean agregarDetalleVenta(DetalleVenta detalleVenta);

    // Detalle Compra
    public boolean agregarDetalleCompra(DetalleCompra detalleCompra);

    // Detalle Merma
    public boolean agregarDetalleMerma(DetalleMerma detalleMerma);

    //Compra
    public boolean agregarCompra(Compra compra);

    public Compra consultarCompra(int id);

    public List<Compra> consultarTodasCompras();

    public List<Compra> buscarComprasEntreFechas(Calendar inicio, Calendar fin);

    public List<Compra> buscarComprasEntreFechasYProveedor(Calendar inicio, Calendar fin, Proveedor proveedor);

//Producto
    public Producto consultarProducto(int id);

    public boolean agregarProducto(Producto producto);

    public boolean actualizarProducto(Producto producto);

    public boolean eliminarProducto(int id);

    public List<Producto> buscarProductosPorNombre(String nombre);

    public List<Producto> consultarTodosProductos();

    //Usuario
    public boolean agregarUsuario(Usuario usuario);

    public boolean actualizarUsuario(Usuario usuario);

    public boolean eliminarUsuario(int id);

    public Usuario consultarUsuario(int id);

    public List<Usuario> consultarTodosUsuarios();

    //Merma
    public boolean agregarMerma(Merma merma);

    public Merma consultarMerma(int id);

    public List<Merma> consultarTodasMermas();

    public List<Merma> buscarMermasEntreFechas(Calendar inicio, Calendar fin);

}
