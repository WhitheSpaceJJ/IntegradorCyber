package GUIs;

import interfaces.*;
import entidades.*;

import fachada.FachadaControl;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentasForm extends javax.swing.JFrame {

    private static VentasForm ventasForm;

    private List<Producto> productos;
    private List<DetalleVenta> detalleV;

    private float precio;
    public static VentasForm frmVentas;
    public BusquedaArticuloForm frmBusArt;

    private IFachadaControl logica;
    private List<Cliente> clientes;

    private VentasForm() {
        initComponents();
        this.logica = new FachadaControl();
        this.productos = new ArrayList<>();
        this.detalleV = new ArrayList<>();
        this.precio = (float) 0.00;
        llenarCBoxClientes();
        llenarCampos();
        txtCategoria.setEditable(false);
        this.txtImporte.setEditable(false);
        this.txtTotalProducto.setEditable(false);
        this.txtDisponibilidad.setEditable(false);
        this.txtDescripcion.setEditable(false);
        this.txtTotalCobrar.setEditable(false);
        this.txtFecha.setEditable(false);
        this.txtNumTicket.setEditable(false);
        this.txtOperador.setEditable(false);
        this.cajaTxt.setEditable(false);
    }

    public static VentasForm getInstance() {
        if (ventasForm == null) {
            ventasForm = new VentasForm();
        }
        return ventasForm;
    }
//Funcionales

    private void llenarCBoxClientes() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        clientes = logica.consultarTodosClientes();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente get = clientes.get(i);
            model.addElement("Nombre; " + get.getNombre());
        }
        clientesC.setModel(model);
    }
    private Caja caja;

    public void establecerCaja(Caja cajaAbierta) {
        cajaTxt.setText("" + cajaAbierta.getId());
        txtOperador.setText("" + cajaAbierta.getUsuario().getNombre());
        this.caja = cajaAbierta;
    }

//    public void bloquearCampos() {
//
//        btnCobrar.setEnabled(false);
//        clientesC.setEnabled(false);
//        btnAgregar.setEnabled(false);
//        btnBuscarProducto.setEnabled(false);
//        btnQuitar.setEnabled(false);
//    }
//
    public void registrarVenta() {
//
//      Venta venta=new Venta(numTicket, fecha, totalVenta, cliente, detalleV, caja)
        List<Venta> ventas = logica.consultarVentas();
        int numTicket;
        if (ventas == null) {
            numTicket = 0;
        } else {
            numTicket =ventas.get(ventas.size()-1).getId() + 1;
        }
        Calendar fecha = Calendar.getInstance();
        Float totalVenta = Float.valueOf(txtTotalCobrar.getText());
        int indiceCliente = clientesC.getSelectedIndex();
        Cliente cliente = clientes.get(indiceCliente);
        Venta venta = new Venta(numTicket, fecha, totalVenta, cliente, caja);
        boolean ventaAgregada = logica.agregarVenta(venta);
        if (ventaAgregada) {
            venta.setId(numTicket);
            for (int i = 0; i < detalleV.size(); i++) {
                detalleV.get(i).setVenta(venta);
                logica.agregarDetalleVenta(detalleV.get(i));
            }
            JOptionPane.showMessageDialog(null, "La venta fue agregada exitosamente");
            limpiarCampos();
        }

//
//        ventaT = ventas.get(ventas.size() - 1);
//        String fecha = frmVentas.txtFecha.getText();
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
//        Calendar fechaCalendar = Calendar.getInstance();
//
//        try {
//            fechaCalendar.setTime(formatoFecha.parse(fecha));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
////        //cliente= (Cliente) clientesC.getSelectedItem();
////        Cliente c = new Cliente();
////        Integer id = 1;
////        c.setId(id);
////        c.setRfc("HSHGDGS6A77");
////        c.setNombre("Jose");
//        Calendar fechaActual = Calendar.getInstance();
//        Caja caja = new Caja();
//        caja = logica.consultarCaja(1);
//
//        venta.setNumTicket(ventaT.getNumTicket() + 1);
//        venta.setFecha(fechaActual);
//        venta.setTotalventa(Float.parseFloat(txtTotalCobrar.getText()));
//        int indiceCliente = clientesC.getSelectedIndex();
//        venta.setCliente(clientes.get(indiceCliente));
//        venta.setCaja(caja);
//        logica.agregarVenta(venta);
//        for (int i = 0; i < detalleV.size(); i++) {
//            DetalleVenta detalleVenta = new DetalleVenta();
//            detalleVenta = detalleV.get(i);
//            detalleV.remove(i);
//            detalleVenta.setVenta(venta);
//            logica.agregarDetalleVenta(detalleVenta);
//        }
//        boolean ventaAgregada = logica.agregarVenta(venta);
//        if (ventaAgregada) {
//            JOptionPane.showMessageDialog(null, "La venta fue agregada exitosamente");
//            limpiarCampos();
//        }
//        System.out.println("Se registro la venta");
//        desbloquearCampos();

    }

    public void llenarCampos() {
        Calendar fechaC = Calendar.getInstance();

        Date fecha = fechaC.getTime();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

        String fechaFormateada = formatoFecha.format(fecha);

        this.txtFecha.setText(fechaFormateada);
    }
//
//    public void desbloquearCampos() {
//        instanciaFrmVentas();
//
//        frmVentas.btnCobrar.setEnabled(true);
//        frmVentas.clientesC.setEnabled(true);
//        frmVentas.btnAgregar.setEnabled(true);
//        frmVentas.btnBuscarProducto.setEnabled(true);
//        frmVentas.btnQuitar.setEnabled(true);
//
//    }

    public void limpiarCampos() {
        txtCantidad.setText("");
        txtCategoria.setText("");
        txtCodigoArticulo.setText("");
        txtDescripcion.setText("");
        txtDisponibilidad.setText("");
        txtImporte.setText("");
        txtObservaciones.setText("");
        txtTotalProducto.setText("");
    }

    public void adminitirSoloNumeros(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if (Character.isDigit(car)) {

        } else {
            evt.consume();
            getToolkit().beep();
        }
    }

    /**
     * Metodo para solo poder introducir texto en un textField
     */
    public void admitirSoloTexto(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if (Character.isLetter(car) || car == ' ') {

        } else {
            evt.consume();
            getToolkit().beep();
        }
    }

    private Producto getProductoSeleccionado() {
        int indiceFilaSeleccionada = this.tblProductos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblProductos.getModel();
            int indiceColumnaNombre = 0;
            String nombreSeleccionado = (String) modeloTabla.getValueAt(indiceFilaSeleccionada, indiceColumnaNombre);
            List<Producto> productoSelec = logica.buscarProductosPorNombre(nombreSeleccionado);
            return productoSelec.get(0);
        } else {
            return null;
        }
    }

    private Producto agregarProducto() {
        if (txtCodigoArticulo.getText() != "") {
            Producto productoAgregar = logica.consultarProducto(Integer.parseInt(txtCodigoArticulo.getText()));
            return productoAgregar;
        } else {
            return null;
        }
    }
    private Producto articuloBuscado;

    //Bien
    public void agregarArtBuscado(Producto productoS) {
        articuloBuscado = productoS;
//        productos.add(productoS);
//        if (!productos.isEmpty()) {
        cargarCampos(articuloBuscado);
//        }
    }

    public void cargarCampos(Producto productoCargado) {
        txtCodigoArticulo.setText(productoCargado.getId() + "");
        txtDescripcion.setText(productoCargado.getDescripcion());
        txtCategoria.setText(productoCargado.getCategoria().getNombre());
        txtDisponibilidad.setText(productoCargado.getStock() + "");
        txtImporte.setText(productoCargado.getPrecio() + "");
        txtTotalProducto.setText(productoCargado.getPrecio() + "");
    }

    //
    public void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblProductos.getModel();
        modeloTabla.setRowCount(0);
        detalleV.forEach(producto -> {
            Object[] fila = new Object[5];
            fila[0] = producto.getProducto().getNombre();
            fila[1] = producto.getProducto().getDescripcion();
            fila[2] = producto.getCantidad();
            fila[3] = producto.getPrecioVendido();
            fila[4] = producto.getImporte();
            modeloTabla.addRow(fila);
        });

    }

    private void actualizarPrecioTotal() {
        float suma = 0;
        for (int i = 0; i < detalleV.size(); i++) {
            DetalleVenta get = detalleV.get(i);
            suma = suma + get.getImporte();
        }
        precio = suma;
        txtTotalCobrar.setText(precio + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumTicket = new javax.swing.JTextField();
        lblNumTicket = new javax.swing.JLabel();
        tblVenta = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        lblGeneral = new javax.swing.JLabel();
        lblCargaDeArticulos = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblOperador = new javax.swing.JLabel();
        btnBuscarProducto = new javax.swing.JButton();
        txtOperador = new javax.swing.JTextField();
        lblCliente1 = new javax.swing.JLabel();
        lblCliente2 = new javax.swing.JLabel();
        lblCliente3 = new javax.swing.JLabel();
        lblCliente4 = new javax.swing.JLabel();
        lblCliente5 = new javax.swing.JLabel();
        lblCliente6 = new javax.swing.JLabel();
        lblCliente8 = new javax.swing.JLabel();
        btnCobrar = new javax.swing.JButton();
        txtDisponibilidad = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtObservaciones = new javax.swing.JTextField();
        txtTotalProducto = new javax.swing.JTextField();
        txtImporte = new javax.swing.JTextField();
        txtCodigoArticulo = new javax.swing.JTextField();
        lblCliente9 = new javax.swing.JLabel();
        lblCliente11 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        lblRectangulo4 = new javax.swing.JLabel();
        txtTotalCobrar = new javax.swing.JTextField();
        clientesC = new javax.swing.JComboBox<>();
        txtCaja = new javax.swing.JLabel();
        cajaTxt = new javax.swing.JTextField();

        txtNumTicket.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblNumTicket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNumTicket.setText("No. Ticket:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tblVenta.setBackground(new java.awt.Color(255, 255, 255));
        tblVenta.setPreferredSize(new java.awt.Dimension(1000, 750));
        tblVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente.setText("Cliente:");
        tblVenta.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        lblGeneral.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblGeneral.setForeground(new java.awt.Color(153, 153, 153));
        lblGeneral.setText("General");
        tblVenta.add(lblGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 60, -1));

        lblCargaDeArticulos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCargaDeArticulos.setForeground(new java.awt.Color(153, 153, 153));
        lblCargaDeArticulos.setText("Carga de Artículos");
        tblVenta.add(lblCargaDeArticulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 160, -1));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setText("Fecha:");
        tblVenta.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        txtFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        tblVenta.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 200, -1));

        lblOperador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblOperador.setText("Operador:");
        tblVenta.add(lblOperador, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, -1, -1));

        btnBuscarProducto.setBackground(new java.awt.Color(0, 0, 255));
        btnBuscarProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        btnBuscarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(204, 204, 255), java.awt.Color.white));
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        tblVenta.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 204, 40, 30));

        txtOperador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtOperador, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 150, -1));

        lblCliente1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente1.setText("Descripción:");
        tblVenta.add(lblCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        lblCliente2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente2.setText("Cantidad:");
        tblVenta.add(lblCliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        lblCliente3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente3.setText("Disponible:");
        tblVenta.add(lblCliente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        lblCliente4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente4.setText("Categoria");
        tblVenta.add(lblCliente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, -1, -1));

        lblCliente5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente5.setText("Total: ");
        tblVenta.add(lblCliente5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        lblCliente6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente6.setText("importe:");
        tblVenta.add(lblCliente6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        lblCliente8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente8.setText("Código Artículo: ");
        tblVenta.add(lblCliente8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        btnCobrar.setBackground(new java.awt.Color(0, 0, 255));
        btnCobrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCobrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCobrar.setText("Cobrar");
        btnCobrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), java.awt.Color.white, java.awt.Color.white));
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });
        tblVenta.add(btnCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 620, 160, 50));

        txtDisponibilidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtDisponibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 205, 50, -1));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 245, 410, -1));

        txtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 205, 180, -1));

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        tblVenta.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 285, 40, -1));

        txtObservaciones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 325, 710, -1));

        txtTotalProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtTotalProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 285, 100, -1));

        txtImporte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 285, 100, -1));

        txtCodigoArticulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtCodigoArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 205, 180, -1));

        lblCliente9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente9.setText("Observaciones:");
        tblVenta.add(lblCliente9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        lblCliente11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente11.setText("Total a Cobrar");
        tblVenta.add(lblCliente11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 640, -1, -1));

        btnQuitar.setBackground(new java.awt.Color(0, 0, 255));
        btnQuitar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("Quitar");
        btnQuitar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(204, 204, 255), java.awt.Color.white));
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        tblVenta.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 110, 30));

        btnAgregar.setBackground(new java.awt.Color(0, 0, 255));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(204, 204, 255), java.awt.Color.white));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        tblVenta.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 110, 30));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(null);

        tblProductos.setBackground(new java.awt.Color(204, 204, 255));
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Artículo", "Descripción", "Cantidad", "Precio", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        tblVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 900, 220));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        tblVenta.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 900, 180));

        txtTotalCobrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotalCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalCobrarActionPerformed(evt);
            }
        });
        tblVenta.add(txtTotalCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 635, 150, -1));

        clientesC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clientesC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesCActionPerformed(evt);
            }
        });
        tblVenta.add(clientesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 200, -1));

        txtCaja.setBackground(new java.awt.Color(204, 204, 204));
        txtCaja.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCaja.setForeground(new java.awt.Color(204, 204, 204));
        txtCaja.setText("Caja");
        tblVenta.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        cajaTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(cajaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 997, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tblVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tblVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed

    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        if (txtCodigoArticulo.getText().equals("")) {
//            bloquearCampos();
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    BusquedaArticuloForm.getInstance().setVisible(true);
                }
            });
        } else {
            try {
                int idProducto = Integer.parseInt(txtCodigoArticulo.getText());
                articuloBuscado = logica.consultarProducto(idProducto);
                if (articuloBuscado != null) {
                    cargarCampos(articuloBuscado);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Venta", JOptionPane.ERROR_MESSAGE);
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Para realizar una busqueda directa con el id se requiere que ingrese solo digitos(12,1,2)", "Venta", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void clientesCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesCActionPerformed

    }//GEN-LAST:event_clientesCActionPerformed

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
//        instanciaFrmVentas();
//        bloquearCampos();
        registrarVenta();
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        adminitirSoloNumeros(evt);
    }//GEN-LAST:event_txtCantidadKeyTyped

    public boolean validarDatos() {
        String regexNumeros = "\\d+";

        if (!txtCantidad.getText().matches(regexNumeros) || Integer.parseInt(txtCantidad.getText()) <= 0 || Integer.parseInt(txtCantidad.getText()) > 999999999) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese un numero entero mayor a 0 y no mayor a 9999999910, en la cantidad a comprar");
            return true;
        }

        return false;
    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (validarDatos()) {
            return;
        }
        Producto productoAgregar = articuloBuscado;
        DetalleVenta dv = new DetalleVenta();
        dv.setCantidad(Integer.parseInt(txtCantidad.getText()));
        dv.setImporte(Float.parseFloat(txtTotalProducto.getText()));
        dv.setPrecioVendido(Float.parseFloat(txtImporte.getText()));
        dv.setProducto(productoAgregar);
        detalleV.add(dv);
        actualizarPrecioTotal();
        cargarTabla();
        limpiarCampos();
        articuloBuscado = null;
        BusquedaArticuloForm.getInstance().resetBusquedas();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int indice = tblProductos.getSelectedRow();
        if (indice != -1) {
            detalleV.remove(indice);
            cargarTabla();
            actualizarPrecioTotal();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un artículo, para eliminarlo der la lista", "Eliminacion articulo", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        String cantidad = txtCantidad.getText();
        if (!cantidad.equals("") && cantidad.matches("[0-9]*")) {
            float total = Float.parseFloat(txtImporte.getText()) * Integer.parseInt(cantidad);
            txtTotalProducto.setText(total + "");
        }
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setVisible(false);
        dispose();
        PrincipalForm.getInstance().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtTotalCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalCobrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalCobrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JTextField cajaTxt;
    private javax.swing.JComboBox<String> clientesC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCargaDeArticulos;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCliente1;
    private javax.swing.JLabel lblCliente11;
    private javax.swing.JLabel lblCliente2;
    private javax.swing.JLabel lblCliente3;
    private javax.swing.JLabel lblCliente4;
    private javax.swing.JLabel lblCliente5;
    private javax.swing.JLabel lblCliente6;
    private javax.swing.JLabel lblCliente8;
    private javax.swing.JLabel lblCliente9;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGeneral;
    private javax.swing.JLabel lblNumTicket;
    private javax.swing.JLabel lblOperador;
    private javax.swing.JLabel lblRectangulo4;
    private javax.swing.JTable tblProductos;
    private javax.swing.JPanel tblVenta;
    private javax.swing.JLabel txtCaja;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodigoArticulo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDisponibilidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtNumTicket;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtOperador;
    private javax.swing.JTextField txtTotalCobrar;
    private javax.swing.JTextField txtTotalProducto;
    // End of variables declaration//GEN-END:variables
}
