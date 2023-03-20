package prueba;

import conexion.ConexionBD;
import entidades.Caja;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleCompra;
import entidades.DetalleVenta;
import entidades.Gasto;
import entidades.Producto;
import entidades.Proveedor;
import entidades.Usuario;
import entidades.Venta;
import enumeradores.Estado;
import enumeradores.Rol;
import fachada.FachadaDAO;
import implementaciones.ClientesDAO;
import implementaciones.UsuariosDAO;
import implementaciones.VentasDAO;
import interfaces.IClientesDAO;
import interfaces.IUsuariosDAO;
import interfaces.IVentasDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FachadaDAO fachada = new FachadaDAO();
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jose", "JoseJesus12$", Rol.VENDEDOR));
        usuarios.add(new Usuario("Jesus", "JoseJesus123", Rol.VENDEDOR));
//
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria("Libretas"));
        categorias.add(new Categoria("Cuadernos"));
        categorias.add(new Categoria("Lápices"));
        categorias.add(new Categoria("Lapiceros"));
        categorias.add(new Categoria("Reglas"));
        categorias.add(new Categoria("Gomas"));
        List<Producto> productos = new ArrayList<>();
//        productos.add(new Producto("Libreta tamaño carta", "Libreta tamaño carta de 80 hojas", 10.0f, 50, 4.5f, categorias.get(0)));
//        productos.add(new Producto("Cuaderno universitario", "Cuaderno universitario de 100 hojas", 12.5f, 40, 4.0f, categorias.get(1)));
//        productos.add(new Producto("Lápiz HB", "Lápiz con mina HB para escritura", 1.0f, 500, 4.2f, categorias.get(2)));
//        productos.add(new Producto("Lapicero azul", "Lapicero de tinta azul para escritura", 2.0f, 300, 4.3f, categorias.get(3)));
//        productos.add(new Producto("Regla de plástico", "Regla de 30 cm de largo hecha de plástico resistente", 5.0f, 100, 4.1f, categorias.get(4)));
//        productos.add(new Producto("Goma de borrar blanca", "Goma de borrar blanca para lápices y carboncillos", 0.5f, 1000, 4.6f, categorias.get(5)));
//        productos.add(new Producto("Libreta tamaño media carta", "Libreta tamaño media carta de 50 hojas", 6.0f, 80, 4.4f, categorias.get(0)));
//        productos.add(new Producto("Cuaderno profesional", "Cuaderno profesional de 200 hojas", 20.0f, 30, 4.7f, categorias.get(1)));
//        productos.add(new Producto("Lápiz 2B", "Lápiz con mina 2B para dibujo y sombreado", 1.2f, 400, 4.3f, categorias.get(2)));
//        productos.add(new Producto("Lapicero rojo", "Lapicero de tinta roja para escritura y corrección", 2.2f, 250, 4.2f, categorias.get(3)));
//        productos.add(new Producto("Regla de metal", "Regla de 20 cm de largo hecha de metal resistente", 8.0f, 50, 4.5f, categorias.get(4)));
//        productos.add(new Producto("Goma de borrar para tinta", "Goma de borrar para tinta de bolígrafo y pluma", 1.0f, 800, 4.8f, categorias.get(5)));
        List<Proveedor> proveedores = new ArrayList<>();
//        proveedores.add(new Proveedor("Proveedor 1", "Dirección 1", "11111111", "proveedor1@example.com", "Contacto 1"));
//        proveedores.add(new Proveedor("Proveedor 2", "Dirección 2", "22222222", "proveedor2@example.com", "Contacto 2"));
//        proveedores.add(new Proveedor("Proveedor 3", "Dirección 3", "33333333", "proveedor3@example.com", "Contacto 3"));
//        proveedores.add(new Proveedor("Proveedor 4", "Dirección 4", "44444444", "proveedor4@example.com", "Contacto 4"));
//        proveedores.add(new Proveedor("Proveedor 5", "Dirección 5", "55555555", "proveedor5@example.com", "Contacto 5"));
//        proveedores.add(new Proveedor("Proveedor 6", "Dirección 6", "66666666", "proveedor6@example.com", "Contacto 6"));
//        List<DetalleCompra> detallesCompra = new ArrayList<>();
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 100, 8.0f, proveedores.get(0), productos.get(0)));
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 80, 10.0f, proveedores.get(1), productos.get(1)));
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 500, 0.5f, proveedores.get(2), productos.get(2)));
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 300, 1.0f, proveedores.get(3), productos.get(3)));
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 200, 4.0f, proveedores.get(4), productos.get(4)));
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 1000, 0.2f, proveedores.get(5), productos.get(5)));
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 50, 15.0f, proveedores.get(0), productos.get(6)));
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 30, 25.0f, proveedores.get(1), productos.get(7)));
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 400, 1.2f, proveedores.get(2), productos.get(8)));
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 250, 2.2f, proveedores.get(3), productos.get(9)));
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 50, 10.0f, proveedores.get(4), productos.get(10)));
//        detallesCompra.add(new DetalleCompra(Calendar.getInstance(), 800, 1.0f, proveedores.get(5), productos.get(11)));
//
//        FachadaDAO fachada = new FachadaDAO();
//        //Crea Usuario

//        for (int i = 0; i < proveedores.size(); i++) {
//            Proveedor get = proveedores.get(i);
//            fachada.agregarProveedor(get);
//        }
//        for (int i = 0; i < categorias.size(); i++) {
//            Categoria get = categorias.get(i);
//            fachada.agregarCategoria(get);
//        }
//        for (DetalleCompra detalle : detallesCompra) {
//            fachada.agregarDetalleCompra(detalle);
//        }
//Prueba 1 Llenado
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario get = usuarios.get(i);
            fachada.agregarUsuario(get);
        }
        System.out.println("Usuarios se han insertado correctamente");
        System.out.println("------------------------");
        for (int i = 0; i < productos.size(); i++) {
            Producto get = productos.get(i);
            fachada.agregarProducto(get);
        }
        System.out.println("Productos se han insertado correctamente");
        System.out.println("Las cayegorias igualmente fueron agregadas exitosamente");

        for (int i = 0; i < proveedores.size(); i++) {
            Proveedor get = proveedores.get(i);
            fachada.agregarProveedor(get);
        }
        System.out.println("Los proevedores se han agregado corectamente");
//Prueba 2 Obtencion
        List<Usuario> usuariosO = fachada.consultarTodosUsuarios();
        System.out.println("Usuarios Obtenidos");
        for (int i = 0; i < usuariosO.size(); i++) {
            Usuario get = usuariosO.get(i);
            System.out.println(get.toString());
        }
        System.out.println("------------------------");
        System.out.println("Productos obtenidos");
        List<Producto> productosO = fachada.consultarTodosProductos();
        for (int i = 0; i < productosO.size(); i++) {
            Producto get = productosO.get(i);
            System.out.println(get.toString());
        }
        System.out.println("------------------------");
        System.out.println("Categorias obtenidos");
        List<Categoria> categoriasO = fachada.consultarTodasCategorias();
        for (int i = 0; i < categoriasO.size(); i++) {
            Categoria get = categoriasO.get(i);
            System.out.println(get.toString());
        }

        System.out.println("------------------------");
        System.out.println("Provedores Obtenidos");
        List<Proveedor> proveedoresO = fachada.consultarTodosProveedores();
        for (int i = 0; i < proveedoresO.size(); i++) {
            Proveedor get = proveedoresO.get(i);
            System.out.println(get.toString());
        }
       System.out.println("------------------------");
        System.out.println("Cliente Creacion");
        Cliente cliente =new Cliente("Jose", "OOHJ020110UU$", "jose.orozco@gmail.com", "6442138093");
        fachada.agregarCliente(cliente);
        System.out.println("Caja abierta");
        Caja caja = new Caja(Calendar.getInstance(), 1900, 0, 0, 0, Estado.ABIERTA, usuariosO.get(0));
        fachada.agregarCaja(caja);
        System.out.println("Caja Agregada estatus; " + fachada.consultarCajas().get(fachada.consultarCajas().size() - 1).getEstado());
    
        System.out.println("Cliente y caja obtenidos sera con id ya que solo es un unico elemento");
        Cliente clienteO=fachada.consultarCliente(1);
        System.out.println(clienteO.toString());
        Caja caja1=fachada.consultarCaja(1);
        System.out.println(caja1.toString());
        System.out.println("------------------------");
        Producto obtenido2 = productos.get(0);
        //DetalleCompra compra = new DetalleCompra(
               // Calendar.getInstance(), 400, obtenido2.getPrecioCompra(),
//                proveedoresO.get(
//                        new Random().nextInt(proveedoresO.size() - 1)),
//                obtenido2);
//        fachada.agregarDetalleCompra(compra);
//        fachada.agregarStockProducto(compra.getProducto(), compra.getCantidadComprada());
        System.out.println("Compra agregada yy el stock del producto se ha aumentado");
        System.out.println("Compras");
      //  List<DetalleCompra> compras = fachada.consultarTodasEntradasAlmacen();
        //for (int i = 0; i < compras.size(); i++) {
        //    DetalleCompra get = compras.get(i);
        //    System.out.println(get.toString());
       // }
        System.out.println("Productos obtenidos");
        productosO = fachada.consultarTodosProductos();
        for (int i = 0; i < productosO.size(); i++) {
            Producto get = productosO.get(i);
            System.out.println(get.toString());
        }
 
        System.out.println("Venta agregada");
        Venta venta=new Venta(100, Calendar.getInstance(), 400, cliente, caja);
        fachada.agregarVenta(venta);
        System.out.println("Venta; "+fachada.consultarTodasVentas().toString());
        System.out.println("Producto Venta; "+fachada.consultarProducto(1));
       
        DetalleVenta detalleVenta=new DetalleVenta(40, 10, 400, venta, productosO.get(0));
        fachada.agregarDetalleVenta(detalleVenta);
        System.out.println("Ahora a consultar la base pero antes, realizamos un gasto");
        Gasto gasto=new Gasto(Calendar.getInstance(), "nomina empleado", 400, "Jose", caja);
        fachada.agregarGasto(gasto);
        System.out.println("Gastos, "+fachada.consultarTodos().toString());
        Caja caja2=fachada.consultarCaja(1);
        caja2.setTotalIngresos(venta.getTotalventa());
        caja2.setTotalGastos(gasto.getCosto());
        fachada.actualizarCaja(caja);
    }

}
