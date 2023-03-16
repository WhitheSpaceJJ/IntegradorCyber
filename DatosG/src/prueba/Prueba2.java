/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

import entidades.Caja;
import entidades.Categoria;
import entidades.Cliente;
import entidades.Proveedor;
import entidades.Usuario;
import enumeradores.Estado;
import enumeradores.Rol;
import fabrica.FabricaDAO;
import interfaces.ICajasDAO;
import interfaces.ICategoriasDAO;
import interfaces.IClientesDAO;
import interfaces.IProveedoresDAO;
import interfaces.IUsuariosDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Prueba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("|---------- Menú de Pruebas ---------|");
            System.out.println("Seleccione una opción:");
            System.out.println("2. Prueba_CategoriasDAO");
            System.out.println("3. Prueba_ClientesDAO");
            System.out.println("8. Prueba_UsuariosDAO");
            System.out.println("9. Prueba_ProveedoresDAO");
            System.out.println("0. Salir");
            System.out.println("|------------------------------------|");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 2 ->
                    prueba_CategoriasDAO();
                case 3 ->
                    prueba_ClientesDAO();
             
                case 8 ->
                    prueba_UsuariosDAO();
                case 9 ->
                    prueba_ProveedoresDAO();
         
                case 0 ->
                    System.out.println("Saliendo del programa...");
                default ->
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    public static void prueba_CategoriasDAO() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        ICategoriasDAO categoriasDAO = FabricaDAO.getInstancia().getCategoriasDAO();

        do {
            System.out.println("|---------- Menú de CategoriasDAO ---------|");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar Categoria");
            System.out.println("2. Actualizar Categoria");
            System.out.println("3. Eliminar Categoria");
            System.out.println("4. Consultar Categoria ID");
            System.out.println("5. Consultar Categorias");
            System.out.println("0. Salir");
            System.out.println("|------------------------------------|");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    Categoria categoria = new Categoria();
                    System.out.println("Ingresa el nombre de la categoria:");
                    scanner.nextLine(); // Consumimos el salto de linea que queda en el buffer
                    categoria.setNombre(scanner.nextLine());
                    System.out.println("Se agrego la categoria: " + categoriasDAO.agregar(categoria));
                }
                case 2 -> {
                    System.out.println("Ingrese el ID de la categoria a actualizar:");
                    int idActualizar = scanner.nextInt();
                    Categoria categoriaActualizar = categoriasDAO.consultar(idActualizar);
                    if (categoriaActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre de la categoria:");
                        scanner.nextLine(); // Consumimos el salto de linea que queda en el buffer
                        categoriaActualizar.setNombre(scanner.nextLine());
                        categoriasDAO.actualizar(categoriaActualizar);
                        System.out.println("Se actualizo la categoria");
                    } else {
                        System.out.println("No se encontro la categoria con ese ID");
                    }
                }
                case 3 -> {
                    System.out.println("Ingrese el ID de la categoria a eliminar:");
                    int idEliminar = scanner.nextInt();
                    Categoria categoriaEliminar = categoriasDAO.consultar(idEliminar);
                    if (categoriaEliminar != null) {
                        categoriasDAO.eliminar(idEliminar);
                        System.out.println("Se elimino la categoria");
                    } else {
                        System.out.println("No se encontro la categoria con ese ID");
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese el ID de la categoria a buscar:");
                    int idBuscar = scanner.nextInt();
                    Categoria categoriaBuscar = categoriasDAO.consultar(idBuscar);
                    if (categoriaBuscar != null) {
                        System.out.println("Categoria encontrada: " + categoriaBuscar);
                    } else {
                        System.out.println("No se encontro la categoria con ese ID");
                    }
                }
                case 5 -> {
                    List<Categoria> categorias = categoriasDAO.consultarTodos();
                    if (categorias.isEmpty()) {
                        System.out.println("No hay categorias registradas");
                    } else {
                        System.out.println("|---------- Listado de Categorias ---------|");
                        for (Categoria c : categorias) {
                            System.out.println(c.getId() + " - " + c.getNombre());
                        }
                        System.out.println("|------------------------------------|");
                    }
                }
                case 0 ->
                    System.out.println("Saliendo del programa...");
                default ->
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();

    }

    public static void prueba_ClientesDAO() {

        Scanner scanner = new Scanner(System.in);
        IClientesDAO clientesDAO = FabricaDAO.getInstancia().getClientesDAO();
        int opcion;

        do {
            System.out.println("|---------- Menú de clientes ---------|");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Consultar Cliente ID");
            System.out.println("5. Consultar Clientes");
            System.out.println("0. Salir");
            System.out.println("|------------------------------------|");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    // Agregar Cliente
                    System.out.println("Ingrese el nombre del cliente:");
                    String nombre = scanner.next();
                    System.out.println("Ingrese el RFC del cliente:");
                    String rfc = scanner.next();
                    System.out.println("Ingrese el email del cliente:");
                    String email = scanner.next();
                    System.out.println("Ingrese el teléfono del cliente:");
                    String telefono = scanner.next();
                    Cliente nuevoCliente = new Cliente(nombre, rfc, email, telefono);
                    clientesDAO.agregar(nuevoCliente);
                    System.out.println("Cliente agregado exitosamente.");
                }
                case 2 -> {
                    // Actualizar Cliente
                    System.out.println("Ingrese el ID del cliente que desea actualizar:");
                    int idActualizar = scanner.nextInt();
                    Cliente clienteActualizar = clientesDAO.consultar(idActualizar);
                    if (clienteActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del cliente (dejar vacío si no desea cambiar):");
                        String nuevoNombre = scanner.next();
                        if (!nuevoNombre.isEmpty()) {
                            clienteActualizar.setNombre(nuevoNombre);
                        }
                        System.out.println("Ingrese el nuevo RFC del cliente (dejar vacío si no desea cambiar):");
                        String nuevoRfc = scanner.next();
                        if (!nuevoRfc.isEmpty()) {
                            clienteActualizar.setRfc(nuevoRfc);
                        }
                        System.out.println("Ingrese el nuevo email del cliente (dejar vacío si no desea cambiar):");
                        String nuevoEmail = scanner.next();
                        if (!nuevoEmail.isEmpty()) {
                            clienteActualizar.setEmail(nuevoEmail);
                        }
                        System.out.println("Ingrese el nuevo teléfono del cliente (dejar vacío si no desea cambiar):");
                        String nuevoTelefono = scanner.next();
                        if (!nuevoTelefono.isEmpty()) {
                            clienteActualizar.setTelefono(nuevoTelefono);
                        }
                        clientesDAO.actualizar(clienteActualizar);
                        System.out.println("Cliente actualizado exitosamente.");
                    } else {
                        System.out.println("No se encontró ningún cliente con ese ID.");
                    }
                }
                case 3 -> {
                    System.out.println("Ingrese el ID del cliente a eliminar:");
                    int idEliminar = scanner.nextInt();
                    try {
                        clientesDAO.eliminar(idEliminar);
                        System.out.println("Cliente eliminado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al eliminar el cliente: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese el ID del cliente a buscar:");
                    int idBuscar = scanner.nextInt();
                    try {
                        Cliente clienteBuscado = clientesDAO.consultar(idBuscar);
                        System.out.println("Cliente encontrado:");
                        System.out.println(clienteBuscado);
                    } catch (Exception e) {
                        System.out.println("Error al buscar el cliente: " + e.getMessage());
                    }
                }
                case 5 -> {
                    try {
                        List<Cliente> clientes = clientesDAO.consultarTodos();
                        System.out.println("Listado de clientes:");
                        for (Cliente cliente : clientes) {
                            System.out.println(cliente);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al listar los clientes: " + e.getMessage());
                    }
                }
                case 0 ->
                    System.out.println("Saliendo del programa...");
                default ->
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

 

    public static void prueba_UsuariosDAO() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        IUsuariosDAO usuariosDAO = FabricaDAO.getInstancia().getUsuariosDAO();
        do {
            System.out.println("|---------- Menú de UsuariosDAO ---------|");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Actualizar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Consultar Usuario ID");
            System.out.println("5. Consultar Usuarios");
            System.out.println("0. Salir");
            System.out.println("|------------------------------------|");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Usuario usuarioNuevo = new Usuario();
                    System.out.println("Ingrese el nombre del usuario:");
                    usuarioNuevo.setNombre(scanner.next());
                    System.out.println("Ingrese la contraseña del usuario:");
                    usuarioNuevo.setPassword(scanner.next());
                    System.out.println("Ingrese el rol del usuario:");
                    usuarioNuevo.setRol(Rol.valueOf(scanner.next().toUpperCase()));
                    usuariosDAO.agregar(usuarioNuevo);
                    break;
                case 2:
                    Usuario usuarioActualizado = new Usuario();
                    System.out.println("Ingrese el ID del usuario a actualizar:");
                    usuarioActualizado.setId(scanner.nextInt());
                    System.out.println("Ingrese el nombre del usuario:");
                    usuarioActualizado.setNombre(scanner.next());
                    System.out.println("Ingrese la contraseña del usuario:");
                    usuarioActualizado.setPassword(scanner.next());
                    System.out.println("Ingrese el rol del usuario:");
                    usuarioActualizado.setRol(Rol.valueOf(scanner.next().toUpperCase()));
                    usuariosDAO.actualizar(usuarioActualizado);
                    break;
                case 3:
                    System.out.println("Ingrese el ID del usuario a eliminar:");
                    int idUsuarioAEliminar = scanner.nextInt();
                    usuariosDAO.eliminar(idUsuarioAEliminar);
                    break;
                case 4:
                    System.out.println("Ingrese el ID del usuario a consultar:");
                    int idUsuarioAConsultar = scanner.nextInt();
                    Usuario usuarioConsultado = usuariosDAO.consultar(idUsuarioAConsultar);
                    if (usuarioConsultado == null) {
                        System.out.println("El usuario con ID " + idUsuarioAConsultar + " no existe.");
                    } else {
                        System.out.println(usuarioConsultado.toString());
                    }
                    break;
                case 5:
                    List<Usuario> usuarios = usuariosDAO.consultarTodos();
                    for (Usuario u : usuarios) {
                        System.out.println(u.toString());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    public static void prueba_ProveedoresDAO() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        IProveedoresDAO proveedoresDAO = FabricaDAO.getInstancia().getProveedoresDAO();
        do {
            System.out.println("|---------- Menú de ProveedoresDAO ---------|");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar Proveedor");
            System.out.println("2. Actualizar Proveedor");
            System.out.println("3. Eliminar Proevedor");
            System.out.println("4. Consultar Proeevedor ID");
            System.out.println("5. Consultar Proeevedores");
            System.out.println("0. Salir");
            System.out.println("|------------------------------------|");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del proveedor:");
                    String nombreProveedor = scanner.next();
                    System.out.println("Ingrese la dirección del proveedor:");
                    String direccionProveedor = scanner.next();
                    System.out.println("Ingrese el número de teléfono del proveedor:");
                    String telefonoProveedor = scanner.next();
                    Proveedor proveedor = new Proveedor(nombreProveedor, direccionProveedor, telefonoProveedor, nombreProveedor, nombreProveedor);
                    proveedoresDAO.agregar(proveedor);
                    System.out.println("Proveedor agregado exitosamente.");
                    break;
                case 2:
                    System.out.println("Ingrese el ID del proveedor a actualizar:");
                    int idProveedorActualizar = scanner.nextInt();
                    Proveedor proveedorActualizar = proveedoresDAO.consultar(idProveedorActualizar);
                    if (proveedorActualizar != null) {
                        System.out.println("Ingrese el nuevo nombre del proveedor:");
                        String nuevoNombreProveedor = scanner.next();
                        System.out.println("Ingrese la nueva dirección del proveedor:");
                        String nuevaDireccionProveedor = scanner.next();
                        System.out.println("Ingrese el nuevo número de teléfono del proveedor:");
                        String nuevoTelefonoProveedor = scanner.next();
                        proveedorActualizar.setNombre(nuevoNombreProveedor);
                        proveedorActualizar.setDireccion(nuevaDireccionProveedor);
                        proveedorActualizar.setTelefono(nuevoTelefonoProveedor);
                        proveedoresDAO.actualizar(proveedorActualizar);
                        System.out.println("Proveedor actualizado exitosamente.");
                    } else {
                        System.out.println("Proveedor no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el ID del proveedor a eliminar:");
                    int idProveedorEliminar = scanner.nextInt();
                    Proveedor proveedorEliminar = proveedoresDAO.consultar(idProveedorEliminar);
                    if (proveedorEliminar != null) {
                        proveedoresDAO.eliminar(idProveedorEliminar);
                        System.out.println("Proveedor eliminado exitosamente.");
                    } else {
                        System.out.println("Proveedor no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el ID del proveedor a consultar:");
                    int idProveedorConsultar = scanner.nextInt();
                    Proveedor proveedorConsultar = proveedoresDAO.consultar(idProveedorConsultar);
                    if (proveedorConsultar != null) {
                        System.out.println("Proveedor encontrado:");
                        System.out.println(proveedorConsultar.toString());
                    } else {
                        System.out.println("Proveedor no encontrado.");
                    }
                    break;
                case 5:
                    List<Proveedor> proveedores = proveedoresDAO.consultarTodos();
                    System.out.println("Proveedores encontrados:");
                    for (Proveedor p : proveedores) {
                        System.out.println(p.toString());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

}
