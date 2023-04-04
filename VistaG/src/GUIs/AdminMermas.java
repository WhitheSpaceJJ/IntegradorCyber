/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import GUIs.BusquedaArticuloForm;
import entidades.Cliente;
import entidades.DetalleMerma;
import entidades.Producto;
import entidades.Usuario;
import entidades.Venta;
import fachada.FachadaControl;
import interfaces.IFachadaControl;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josej
 */
public class AdminMermas extends javax.swing.JFrame {

    private IFachadaControl logica;

    /**
     * Creates new form AdminMermas
     */
    private AdminMermas() {
        initComponents();
        this.detallesMermas = new ArrayList<>();
        this.logica = new FachadaControl();
        this.bloquearCampos();
    }
    private Usuario usuario;

    public void establecerSesion(Usuario usuario) {
        this.usuario = usuario;
    }
    private static AdminMermas instance;

    public static AdminMermas getInstance() {

        if (instance == null) {
            instance = new AdminMermas();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOperador = new javax.swing.JLabel();
        txtOperador = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        clientesC = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        cajaTxt = new javax.swing.JTextField();
        txtCaja = new javax.swing.JLabel();
        lblGeneral = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnCobrar = new javax.swing.JButton();
        lblCliente11 = new javax.swing.JLabel();
        txtTotalCobrar = new javax.swing.JTextField();
        lblCliente10 = new javax.swing.JLabel();
        tblVenta = new javax.swing.JPanel();
        lblCargaDeArticulos = new javax.swing.JLabel();
        btnBuscarProducto = new javax.swing.JButton();
        lblCliente1 = new javax.swing.JLabel();
        lblCliente2 = new javax.swing.JLabel();
        lblCliente3 = new javax.swing.JLabel();
        lblCliente4 = new javax.swing.JLabel();
        lblCliente5 = new javax.swing.JLabel();
        lblCliente6 = new javax.swing.JLabel();
        lblCliente8 = new javax.swing.JLabel();
        txtDisponibilidad = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtTotalProducto = new javax.swing.JTextField();
        txtImporte = new javax.swing.JTextField();
        txtCodigoArticulo = new javax.swing.JTextField();
        txtMotivo = new javax.swing.JTextField();
        lblCliente9 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTotalMerma = new javax.swing.JTextField();
        lblRectangulo4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos1 = new javax.swing.JTable();
        lblCliente7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblRectangulo5 = new javax.swing.JLabel();
        btnRegistrarMermas = new javax.swing.JButton();
        lblCliente12 = new javax.swing.JLabel();
        lblCargaDeArticulos1 = new javax.swing.JLabel();

        lblOperador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblOperador.setText("Operador:");

        txtOperador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setText("Fecha:");

        clientesC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clientesC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesCActionPerformed(evt);
            }
        });

        lblCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente.setText("Cliente:");

        cajaTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCaja.setBackground(new java.awt.Color(204, 204, 204));
        txtCaja.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCaja.setForeground(new java.awt.Color(204, 204, 204));
        txtCaja.setText("Caja");

        lblGeneral.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblGeneral.setForeground(new java.awt.Color(153, 153, 153));
        lblGeneral.setText("General");

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
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos);

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

        lblCliente11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente11.setText("Total a Cobrar");

        txtTotalCobrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotalCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalCobrarActionPerformed(evt);
            }
        });

        lblCliente10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente10.setText("Cantidad:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Mermas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        tblVenta.setBackground(new java.awt.Color(255, 255, 255));
        tblVenta.setPreferredSize(new java.awt.Dimension(1000, 750));
        tblVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCargaDeArticulos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCargaDeArticulos.setForeground(new java.awt.Color(153, 153, 153));
        lblCargaDeArticulos.setText("Producto Buscado");
        tblVenta.add(lblCargaDeArticulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 180, -1));

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
        tblVenta.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 40, 30));

        lblCliente1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente1.setText("Nombre");
        tblVenta.add(lblCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        lblCliente2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente2.setText("Motivo");
        tblVenta.add(lblCliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, -1));

        lblCliente3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente3.setText("Disponible:");
        tblVenta.add(lblCliente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, -1, -1));

        lblCliente4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente4.setText("Total Merma");
        tblVenta.add(lblCliente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 580, -1, -1));

        lblCliente5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente5.setText("Total: ");
        tblVenta.add(lblCliente5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, -1, -1));

        lblCliente6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente6.setText("importe:");
        tblVenta.add(lblCliente6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

        lblCliente8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente8.setText("Código Artículo: ");
        tblVenta.add(lblCliente8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txtDisponibilidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtDisponibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 50, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 280, -1));

        txtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 140, -1));

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
        tblVenta.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 180, -1));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 440, -1));

        txtTotalProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotalProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalProductoActionPerformed(evt);
            }
        });
        tblVenta.add(txtTotalProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 80, -1));

        txtImporte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImporteActionPerformed(evt);
            }
        });
        txtImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImporteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtImporteKeyTyped(evt);
            }
        });
        tblVenta.add(txtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, 70, -1));

        txtCodigoArticulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodigoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoArticuloActionPerformed(evt);
            }
        });
        tblVenta.add(txtCodigoArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 180, -1));

        txtMotivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 230, -1));

        lblCliente9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente9.setText("Descripcion");
        tblVenta.add(lblCliente9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

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
        tblVenta.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 110, 30));

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
        tblVenta.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 110, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Producto");
        tblVenta.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 216, -1));

        txtTotalMerma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtTotalMerma, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 580, 230, -1));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        tblVenta.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 560, 200));

        jScrollPane2.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane2.setBorder(null);

        tblProductos1.setBackground(new java.awt.Color(204, 204, 255));
        tblProductos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Artículo", "Motivo", "Cantidad", "Precio", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProductos1);

        tblVenta.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 950, 230));

        lblCliente7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente7.setText("Cantidad:");
        tblVenta.add(lblCliente7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Mermas");
        tblVenta.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 216, -1));

        lblRectangulo5.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo5.setOpaque(true);
        tblVenta.add(lblRectangulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 370, 200));

        btnRegistrarMermas.setBackground(new java.awt.Color(0, 0, 255));
        btnRegistrarMermas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistrarMermas.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarMermas.setText("Registrar Merma");
        btnRegistrarMermas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), java.awt.Color.white, java.awt.Color.white));
        btnRegistrarMermas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMermasActionPerformed(evt);
            }
        });
        tblVenta.add(btnRegistrarMermas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, 180, 40));

        lblCliente12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente12.setText("Categoria");
        tblVenta.add(lblCliente12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        lblCargaDeArticulos1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCargaDeArticulos1.setForeground(new java.awt.Color(153, 153, 153));
        lblCargaDeArticulos1.setText("Registro Mermas");
        tblVenta.add(lblCargaDeArticulos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, -1));

        getContentPane().add(tblVenta);
        tblVenta.setBounds(0, 0, 980, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed

    }//GEN-LAST:event_txtFechaActionPerformed
    public void bloquearCampos() {
        this.txtNombre.setEnabled(false);
        this.txtDisponibilidad.setEnabled(false);
        this.txtDescripcion.setEnabled(false);
        this.txtCategoria.setEnabled(false);
        this.txtImporte.setEnabled(false);
        this.txtTotalMerma.setEnabled(false);
        this.txtTotalProducto.setEnabled(false);
    }
    private Producto articuloBuscado;
    private List<DetalleMerma> listaMermas;

    public void limpiarCamposTodo() {
        this.txtNombre.setText("");
        this.txtDisponibilidad.setText("");
        this.txtDescripcion.setText("");
        this.txtCategoria.setText("");
        this.txtImporte.setText("");
        this.txtTotalProducto.setText("");
    }

    public void cargarCampos(Producto productoCargado) {
        boolean encontrado = false;
        double totalMerma = 0.0;
        int cantidadMerma = 0;
        for (int i = 0; i < listaMermas.size(); i++) {
            DetalleMerma get = listaMermas.get(i);
            if (get.getProducto().equals(productoCargado)) {
                encontrado = true;
                totalMerma = get.getImporte();
                cantidadMerma = get.getCantidad();
            }
        }
        if (encontrado) {
            this.txtNombre.setText(productoCargado.getNombre() + "");
            this.txtDisponibilidad.setText("" + productoCargado.getStock());
            this.txtDescripcion.setText("" + productoCargado.getDescripcion());
            this.txtCategoria.setText("" + productoCargado.getCategoria().getNombre());
            this.txtImporte.setText("" + productoCargado.getPrecio());
            this.txtTotalProducto.setText(totalMerma + "");
            this.txtCantidad.setText("" + cantidadMerma);
        } else {
            this.txtNombre.setText(productoCargado.getNombre() + "");
            this.txtDisponibilidad.setText("" + productoCargado.getStock());
            this.txtDescripcion.setText("" + productoCargado.getDescripcion());
            this.txtCategoria.setText("" + productoCargado.getCategoria().getNombre());
            this.txtImporte.setText("" + productoCargado.getPrecio());
            this.txtTotalProducto.setText("");
            this.txtCantidad.setText("");
        }

    }
    private List<DetalleMerma> detallesMermas;

    public void agregarArtBuscado(Producto productoS) {
        articuloBuscado = productoS;
        cargarCampos(articuloBuscado);
    }
    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        if (txtCodigoArticulo.getText().equals("")) {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(() -> {
                BusquedaArticuloForm.getInstance().setVisible(true);
                BusquedaArticuloForm.getInstance().resetBusquedas();
                BusquedaArticuloForm.getInstance().establecerBuscador(1);
            });

        } else {
            try {
                int idProducto = Integer.parseInt(txtCodigoArticulo.getText());
                articuloBuscado = logica.consultarProducto(idProducto);
                if (articuloBuscado == null) {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Venta", JOptionPane.ERROR_MESSAGE);
                } else {
                    articuloBuscado = logica.consultarProducto(idProducto);
                    if (articuloBuscado != null) {
                        cargarCampos(articuloBuscado);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Venta", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Para realizar una busqueda directa con el id se requiere que ingrese solo digitos(12,1,2)", "Venta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed

    }//GEN-LAST:event_btnCobrarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed

    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        String cantidad = txtCantidad.getText();
        if (!cantidad.equals("") && cantidad.matches("^[1-9]\\d{0,8}$")) {
            int cantidadInt = Integer.parseInt(cantidad);
            if (cantidadInt >= 1 && cantidadInt <= 9999999) {
                float total = Float.parseFloat(txtImporte.getText()) * cantidadInt;
                txtTotalProducto.setText(total + "");
            } else {
                JOptionPane.showMessageDialog(null, "", "La cantidad está fuera del rango permitido", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "", "Mermas", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped

    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtTotalProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalProductoActionPerformed

    }//GEN-LAST:event_txtTotalProductoActionPerformed

    private void txtImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImporteActionPerformed

    }//GEN-LAST:event_txtImporteActionPerformed

    private void txtImporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyReleased
        String importe = txtImporte.getText();
        if (!importe.equals("") && importe.matches("^[0-9]*\\.?[0-9]$")) {
            float total = Float.parseFloat(importe) * Integer.parseInt(txtCantidad.getText());
            txtTotalProducto.setText(total + "");
        } else {
            txtTotalProducto.setText("");
        }
    }//GEN-LAST:event_txtImporteKeyReleased


    private void txtImporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyTyped

//        adminitirFlotante(evt);
    }//GEN-LAST:event_txtImporteKeyTyped

    private void txtCodigoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoArticuloActionPerformed

    }//GEN-LAST:event_txtCodigoArticuloActionPerformed
    private void actualizarPrecioTotal() {
        float suma = 0;
        for (int i = 0; i < detallesMermas.size(); i++) {
            DetalleMerma get = detallesMermas.get(i);
            suma = suma + get.getImporte();
        }
        float precio = suma;
        this.txtTotalMerma.setText(precio + "");
    }

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int indice = tblProductos.getSelectedRow();
        if (indice != -1) {
            detallesMermas.remove(indice);
            cargarTabla();
            actualizarPrecioTotal();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un artículo, para eliminarlo der la lista", "Eliminacion articulo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String cantidad = txtCantidad.getText();
        if (!cantidad.equals("") && cantidad.matches("^[1-9]\\d{0,8}$")) {
            int cantidadInt = Integer.parseInt(cantidad);
            if (cantidadInt >= 1 && cantidadInt <= 9999999) {
                DetalleMerma detalleMerma = new DetalleMerma();
                int cantidadOficial = Integer.parseInt(txtCantidad.getText());
                float totalProductoOficial = Float.parseFloat(txtTotalProducto.getText());
                String motivo = this.txtMotivo.getText();
                detalleMerma.setCantidad(cantidadOficial);
                detalleMerma.setCosto(articuloBuscado.getCosto());
                detalleMerma.setImporte(totalProductoOficial);
                detalleMerma.setProducto(articuloBuscado);
                detalleMerma.setMotivo(motivo);
                listaMermas.add(detalleMerma);
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "", "La cantidad está fuera del rango permitido", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "", "Mermas", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    public void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblProductos.getModel();
        modeloTabla.setRowCount(0);
        detallesMermas.forEach(merma -> {
            Object[] fila = new Object[5];
            fila[0] = merma.getProducto().getNombre();
            fila[1] = merma.getMotivo();
            fila[2] = merma.getCantidad();
            fila[3] = merma.getProducto().getPrecio();
            fila[4] = merma.getImporte();
            modeloTabla.addRow(fila);
        });
    }

    private void txtTotalCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalCobrarActionPerformed

    }//GEN-LAST:event_txtTotalCobrarActionPerformed

    private void clientesCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesCActionPerformed

    }//GEN-LAST:event_clientesCActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setVisible(false);
        dispose();
        PrincipalForm.getInstance().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnRegistrarMermasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMermasActionPerformed

        if (detallesMermas.size() > 0) {
//            List<> ventas = logica.consultarVentas();
//            int numTicket;
//            if (ventas.isEmpty()) {
//                numTicket = 1;
//            } else {
//                numTicket = ventas.get(ventas.size() - 1).getId() + 1;
//            }
//            Calendar fecha = Calendar.getInstance();
//            Float totalVenta = Float.valueOf(txtTotalCobrar.getText());
//            int indiceCliente = clientesC.getSelectedIndex();
//            Cliente cliente = clientes.get(indiceCliente);
//            venta = new Venta(numTicket, fecha, totalVenta, cliente, caja);
//            venta.setDetalleVentas(detalleV);
//
//            this.setVisible(false);
//            java.awt.EventQueue.invokeLater(new Runnable() {
//                public void run() {
//                    FrmCobro.getInstance().setVisible(true);
//                    FrmCobro.getInstance().establecerVenta(venta);
//                }
//            });

        } else {
            JOptionPane.showMessageDialog(null, "No ha agregado productos");
        }
    }//GEN-LAST:event_btnRegistrarMermasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistrarMermas;
    private javax.swing.JTextField cajaTxt;
    private javax.swing.JComboBox<String> clientesC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCargaDeArticulos;
    private javax.swing.JLabel lblCargaDeArticulos1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCliente1;
    private javax.swing.JLabel lblCliente10;
    private javax.swing.JLabel lblCliente11;
    private javax.swing.JLabel lblCliente12;
    private javax.swing.JLabel lblCliente2;
    private javax.swing.JLabel lblCliente3;
    private javax.swing.JLabel lblCliente4;
    private javax.swing.JLabel lblCliente5;
    private javax.swing.JLabel lblCliente6;
    private javax.swing.JLabel lblCliente7;
    private javax.swing.JLabel lblCliente8;
    private javax.swing.JLabel lblCliente9;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGeneral;
    private javax.swing.JLabel lblOperador;
    private javax.swing.JLabel lblRectangulo4;
    private javax.swing.JLabel lblRectangulo5;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblProductos1;
    private javax.swing.JPanel tblVenta;
    private javax.swing.JLabel txtCaja;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodigoArticulo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDisponibilidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOperador;
    private javax.swing.JTextField txtTotalCobrar;
    private javax.swing.JTextField txtTotalMerma;
    private javax.swing.JTextField txtTotalProducto;
    // End of variables declaration//GEN-END:variables
}
