package GUIs;

import interfaces.*;
import entidades.*;
import fachada.FachadaControl;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DetalleCompraForm extends javax.swing.JFrame implements IBusqueda{
 private float precio;
    private Producto articuloBuscado;
    private List<DetalleVenta> detalleV;
    private List<Cliente> clientes;
    private IFachadaControl logica;
    private Caja caja;
    private List<Producto> productos;
    private BusquedaArticuloForm busqueda;
    private FrmCobro cobro;
    
    public DetalleCompraForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblVenta2 = new javax.swing.JPanel();
        lblCliente2 = new javax.swing.JLabel();
        lblGeneral2 = new javax.swing.JLabel();
        lblCargaDeArticulos2 = new javax.swing.JLabel();
        lblFecha2 = new javax.swing.JLabel();
        txtFecha2 = new javax.swing.JTextField();
        lblOperador2 = new javax.swing.JLabel();
        btnBuscarProducto2 = new javax.swing.JButton();
        txtOperador = new javax.swing.JTextField();
        lblCliente3 = new javax.swing.JLabel();
        lblCliente4 = new javax.swing.JLabel();
        lblCliente5 = new javax.swing.JLabel();
        lblCliente6 = new javax.swing.JLabel();
        lblCliente7 = new javax.swing.JLabel();
        lblCliente8 = new javax.swing.JLabel();
        lblCliente9 = new javax.swing.JLabel();
        txtDisponibilidad = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtObservaciones = new javax.swing.JTextField();
        txtTotalProducto = new javax.swing.JTextField();
        txtImporte = new javax.swing.JTextField();
        txtCodigoArticulo = new javax.swing.JTextField();
        lblCliente10 = new javax.swing.JLabel();
        lblCliente11 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        lblRectangulo4 = new javax.swing.JLabel();
        txtTotalCobrar = new javax.swing.JTextField();
        clientesC = new javax.swing.JComboBox<>();
        btnCobrar1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblRectangulo5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblVenta2.setBackground(new java.awt.Color(255, 255, 255));
        tblVenta2.setPreferredSize(new java.awt.Dimension(1000, 750));
        tblVenta2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCliente2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente2.setText("Provedores");
        tblVenta2.add(lblCliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        lblGeneral2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblGeneral2.setForeground(new java.awt.Color(153, 153, 153));
        lblGeneral2.setText("General");
        tblVenta2.add(lblGeneral2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 60, -1));

        lblCargaDeArticulos2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCargaDeArticulos2.setForeground(new java.awt.Color(153, 153, 153));
        lblCargaDeArticulos2.setText("Carga de Artículos");
        tblVenta2.add(lblCargaDeArticulos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 160, -1));

        lblFecha2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha2.setText("Fecha:");
        tblVenta2.add(lblFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        txtFecha2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta2.add(txtFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 200, -1));

        lblOperador2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblOperador2.setText("Operador:");
        tblVenta2.add(lblOperador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        btnBuscarProducto2.setBackground(new java.awt.Color(0, 0, 255));
        btnBuscarProducto2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscarProducto2.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarProducto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        btnBuscarProducto2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(204, 204, 255), java.awt.Color.white));
        btnBuscarProducto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProducto2ActionPerformed(evt);
            }
        });
        tblVenta2.add(btnBuscarProducto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 204, 40, 30));

        txtOperador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta2.add(txtOperador, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 150, -1));

        lblCliente3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente3.setText("Descripción:");
        tblVenta2.add(lblCliente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        lblCliente4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente4.setText("Cantidad:");
        tblVenta2.add(lblCliente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        lblCliente5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente5.setText("Disponible:");
        tblVenta2.add(lblCliente5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        lblCliente6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente6.setText("Categoria");
        tblVenta2.add(lblCliente6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        lblCliente7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente7.setText("Total: ");
        tblVenta2.add(lblCliente7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        lblCliente8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente8.setText("importe:");
        tblVenta2.add(lblCliente8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        lblCliente9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente9.setText("Código Artículo: ");
        tblVenta2.add(lblCliente9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        txtDisponibilidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta2.add(txtDisponibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 205, 50, -1));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta2.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 245, 410, -1));

        txtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta2.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 180, -1));

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        tblVenta2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 285, 40, -1));

        txtObservaciones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta2.add(txtObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 325, 140, -1));

        txtTotalProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotalProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalProductoActionPerformed(evt);
            }
        });
        tblVenta2.add(txtTotalProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 285, 100, -1));

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
        tblVenta2.add(txtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 285, 100, -1));

        txtCodigoArticulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodigoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoArticuloActionPerformed(evt);
            }
        });
        tblVenta2.add(txtCodigoArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 205, 180, -1));

        lblCliente10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente10.setText("Observaciones:");
        tblVenta2.add(lblCliente10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        lblCliente11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente11.setText("Gasto total");
        tblVenta2.add(lblCliente11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 640, -1, -1));

        btnQuitar.setBackground(new java.awt.Color(0, 0, 255));
        btnQuitar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("Quitar Producto");
        btnQuitar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(204, 204, 255), java.awt.Color.white));
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        tblVenta2.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 150, 30));

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
        tblVenta2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 110, 30));

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
        tblProductos.setToolTipText("1 click edtar, 2 click remover");
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        tblVenta2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 900, 210));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        tblVenta2.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 280, 190));

        txtTotalCobrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotalCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalCobrarActionPerformed(evt);
            }
        });
        tblVenta2.add(txtTotalCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 635, 150, -1));

        clientesC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta2.add(clientesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 200, -1));

        btnCobrar1.setBackground(new java.awt.Color(0, 0, 255));
        btnCobrar1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCobrar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCobrar1.setText("Guardar");
        btnCobrar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), java.awt.Color.white, java.awt.Color.white));
        btnCobrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrar1ActionPerformed(evt);
            }
        });
        tblVenta2.add(btnCobrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 620, 160, 50));

        btnCancelar.setBackground(new java.awt.Color(0, 51, 255));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar Detalle");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        tblVenta2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 620, 180, 50));

        lblRectangulo5.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo5.setOpaque(true);
        tblVenta2.add(lblRectangulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 590, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tblVenta2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tblVenta2, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProducto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProducto2ActionPerformed
        if (txtCodigoArticulo.getText().equals("")) {
            if (busqueda == null) {
                busqueda = new BusquedaArticuloForm(this);
            }
            establecerVisibilidad(false);
            busqueda.resetBusquedas();
            busqueda.llenarCategorias();
            busqueda.setVisible(true);
        } else {
            try {
                long idProducto = Long.parseLong(txtCodigoArticulo.getText());
                articuloBuscado = logica.consultarCodigo(idProducto);
                if (articuloBuscado == null) {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Venta", JOptionPane.ERROR_MESSAGE);
                    limpiarCampos();
                } else {
                    cargarBusqueda(articuloBuscado);
                }

            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Para realizar una busqueda directa con el codigo se requiere que ingrese solo digitos(12,1,2)", "Venta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarProducto2ActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        String cantidad = txtCantidad.getText();
        if (!cantidad.equals("") && cantidad.matches("[0-9]*")) {
            float total = Float.parseFloat(txtImporte.getText()) * Integer.parseInt(cantidad);
            txtTotalProducto.setText(total + "");
        }
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        adminitirSoloNumeros(evt);
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
        adminitirFlotante(evt);
    }//GEN-LAST:event_txtImporteKeyTyped

    private void txtCodigoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoArticuloActionPerformed

    }//GEN-LAST:event_txtCodigoArticuloActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int indice = tblProductos.getSelectedRow();
        if (indice != -1) {
            detalleV.remove(indice);
            productos.remove(indice);
            cargarTabla();
            actualizarPrecioTotal();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un artículo, para eliminarlo der la lista", "Eliminacion articulo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarProductoTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        if (evt.getClickCount() == 1) {
            int indice = tblProductos.getSelectedRow();
            if (indice != -1) {
                cargarBusqueda(productos.get(indice));
            }
        }
        if (evt.getClickCount() == 2) {
            int indice = tblProductos.getSelectedRow();
            if (indice != -1) {
                detalleV.remove(indice);
                productos.remove(indice);
                cargarTabla();
                actualizarPrecioTotal();
            }
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void txtTotalCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalCobrarActionPerformed

    }//GEN-LAST:event_txtTotalCobrarActionPerformed

    private void btnCobrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrar1ActionPerformed
        if (!detalleV.isEmpty()) {

            Calendar fecha = Calendar.getInstance();
            Float totalVenta = Float.valueOf(txtTotalCobrar.getText());

            int indiceCliente = clientesC.getSelectedIndex();
            Cliente cliente = new Cliente();
            if (indiceCliente >= 0) {
                cliente = clientes.get(indiceCliente);
            }
            Venta venta = new Venta(
                //                    0,
                fecha, totalVenta, cliente, caja);
            venta.setDetalleVentas(detalleV);
            venta.setHora(Calendar.getInstance().getTime());
            if (cobro == null) {
//                cobro = new FrmCobro(this);
            }
            establecerVisibilidad(false);
            cobro.establecerVenta(venta);
            cobro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No ha agregado productos");
        }
    }//GEN-LAST:event_btnCobrar1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        confirmacion();
    }//GEN-LAST:event_btnCancelarActionPerformed


     @Override
    public void establecerVisibilidad(boolean operacion) {
        setVisible(operacion);
        fechaVenta();

    }

    public void fechaVenta() {
        Calendar fecha = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechaFormateada = dateFormat.format(fecha.getTime());
    }

    public void llenarCBoxClientes() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        clientes = new ArrayList<>();
        clientes = logica.consultarTodosClientes();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente get = clientes.get(i);
            model.addElement(get.getNombre());
        }
        clientesC.setModel(model);
    }

    public void adminitirSoloNumeros(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if (Character.isDigit(car)) {

        } else {
            evt.consume();
            getToolkit().beep();
        }
    }

    public void admitirSoloTexto(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if (Character.isLetter(car) || car == ' ') {

        } else {
            evt.consume();
            getToolkit().beep();
        }
    }

    public void adminitirFlotante(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter != '.' || txtImporte.getText().contains("."))) {
            evt.consume();
            getToolkit().beep();
        }
    }

    public void establecerCaja(Caja cajaAbierta) { 
        txtOperador.setText("" + cajaAbierta.getUsuario().getNombre());
        this.caja = cajaAbierta;
    }

    public void llenarCampos() {
        Calendar fechaC = Calendar.getInstance();
        Date fecha = fechaC.getTime();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = formatoFecha.format(fecha);
    }

    public void limpiarCampos() {
        txtCodigoArticulo.setText("");
        txtDisponibilidad.setText("");
        txtCategoria.setText("");
        txtDescripcion.setText("");
        txtCantidad.setText("");
        txtImporte.setText("");
        txtTotalProducto.setText("");
        txtObservaciones.setText("");
        articuloBuscado = null;
    }

    public void agregarArtBuscado(Producto productoS) {
        articuloBuscado = productoS;
        cargarBusqueda(articuloBuscado);
    }

    @Override
    public void cargarBusqueda(Producto producto) {
        //Agregar Excepciondes de productos como por asi decirlo Dulcer Variados
        articuloBuscado = producto;
        int indice = productos.indexOf(articuloBuscado);
        if ((indice == -1)) {
            txtCodigoArticulo.setText(articuloBuscado.getId() + "");
            txtDescripcion.setText(articuloBuscado.getDescripcion());
            txtCategoria.setText(articuloBuscado.getCategoria().getNombre());
            txtDisponibilidad.setText(articuloBuscado.getStock() + "");
            txtImporte.setText(articuloBuscado.getPrecio() + "");
            txtTotalProducto.setText("");
            txtCantidad.setText("1");
        } else {
            cargarDetalleVenta(detalleV.get(indice));
        }
    }

    public void cargarDetalleVenta(DetalleVenta detalleVenta) {
        //Agregar Excepciondes de productos como por asi decirlo Dulcer Variados

        Producto producto = detalleVenta.getProducto();
        txtCodigoArticulo.setText(producto.getId() + "");
        txtDescripcion.setText(producto.getDescripcion());
        txtCategoria.setText(producto.getCategoria().getNombre());
        txtDisponibilidad.setText(producto.getStock() + "");
        txtImporte.setText(producto.getPrecio() + "");
        txtTotalProducto.setText(detalleVenta.getPrecioVendido() + "");
        txtCantidad.setText(detalleVenta.getCantidad() + "");
    }

    private void agregarProductoTabla() {
        //Agregar Excepciondes de productos como por asi decirlo Dulcer Variados

        if (articuloBuscado == null) {
            JOptionPane.showMessageDialog(null, "No ha buscado o seleccionado producto");
        } else {
            if (validarDatos()) {
                return;
            }

            int indice = productos.indexOf(articuloBuscado);
            if ((indice == -1)) {
                int cantidad = Integer.parseInt(txtCantidad.getText());
                String importe = txtImporte.getText();
                if (!importe.equals("")) {
                    float total = Float.parseFloat(importe) * Integer.parseInt(txtCantidad.getText());
                    txtTotalProducto.setText(total + "");
                }
                float totalProducto = Float.parseFloat(txtTotalProducto.getText());
                if ((cantidad) > articuloBuscado.getStock()) {
                    String mensaje = "Stock Producto: " + articuloBuscado.getStock();
                    JOptionPane.showMessageDialog(null, mensaje, "Excede el stock", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    DetalleVenta dv = new DetalleVenta();
                    dv.setCantidad(cantidad);
                    dv.setImporte(totalProducto);
                    dv.setPrecioVendido(Float.parseFloat(txtImporte.getText()));
                    dv.setProducto(articuloBuscado);
                    detalleV.add(dv);
                    productos.add(articuloBuscado);
                    actualizarPrecioTotal();
                    cargarTabla();
                    limpiarCampos();
                }
            } else {
                int cantidad = Integer.parseInt(txtCantidad.getText());
                float totalProducto = Float.parseFloat(txtTotalProducto.getText());
                if ((cantidad) > articuloBuscado.getStock()) {
                    int restante = (int) (articuloBuscado.getStock() - detalleV.get(indice).getCantidad());
                    String mensaje = "Stock Producto: " + articuloBuscado.getStock() + "\nCantidad actual agregada: " + detalleV.get(indice).getCantidad() + "\nRestante: " + restante;
                    JOptionPane.showMessageDialog(null, mensaje, "Excede el stock", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    detalleV.get(indice).setCantidad(cantidad);
                    detalleV.get(indice).setImporte(totalProducto);
                    actualizarPrecioTotal();
                    cargarTabla();
                    limpiarCampos();
                }
            }
        }

    }

    private void confirmacion() {

        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea cancelar la venta?", "Salir", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            setVisible(false);
            PrincipalForm.getInstance().setVisible(true);
//            PrincipalForm.getInstance().eliminarVenta(this);
        }
    }

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

    public boolean validarDatos() {
        String regexNumeros = "\\d+";

        if (!txtCantidad.getText().matches(regexNumeros) || Integer.parseInt(txtCantidad.getText()) <= 0 || Integer.parseInt(txtCantidad.getText()) > 999999999) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese un numero entero mayor a 0 y no mayor a 999999999, en la cantidad a comprar");
            return true;
        }

        return false;
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
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarProducto2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCobrar1;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox<String> clientesC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCargaDeArticulos2;
    private javax.swing.JLabel lblCliente10;
    private javax.swing.JLabel lblCliente11;
    private javax.swing.JLabel lblCliente2;
    private javax.swing.JLabel lblCliente3;
    private javax.swing.JLabel lblCliente4;
    private javax.swing.JLabel lblCliente5;
    private javax.swing.JLabel lblCliente6;
    private javax.swing.JLabel lblCliente7;
    private javax.swing.JLabel lblCliente8;
    private javax.swing.JLabel lblCliente9;
    private javax.swing.JLabel lblFecha2;
    private javax.swing.JLabel lblGeneral2;
    private javax.swing.JLabel lblOperador2;
    private javax.swing.JLabel lblRectangulo4;
    private javax.swing.JLabel lblRectangulo5;
    private javax.swing.JTable tblProductos;
    private javax.swing.JPanel tblVenta2;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodigoArticulo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDisponibilidad;
    private javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtOperador;
    private javax.swing.JTextField txtTotalCobrar;
    private javax.swing.JTextField txtTotalProducto;
    // End of variables declaration//GEN-END:variables
}