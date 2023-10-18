package GUIs;

import interfaces.*;
import entidades.*;
import fachada.FachadaControl;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentasForm extends javax.swing.JFrame {

    private Producto articuloBuscado;
    private List<DetalleVenta> detalleV;
    private static VentasForm ventasForm;
    private List<Cliente> clientes;
    private IFachadaControl logica;
    private Caja caja;

    private VentasForm() {
        initComponents();
    }

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
        btnCobrar1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblRectangulo5 = new javax.swing.JLabel();

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
        tblVenta.add(lblCliente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        lblCliente5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente5.setText("Total: ");
        tblVenta.add(lblCliente5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        lblCliente6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente6.setText("importe:");
        tblVenta.add(lblCliente6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        lblCliente8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCliente8.setText("Código Artículo: ");
        tblVenta.add(lblCliente8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        txtDisponibilidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtDisponibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 205, 50, -1));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 245, 410, -1));

        txtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 180, -1));

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        tblVenta.add(txtObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 325, 140, -1));

        txtTotalProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotalProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalProductoActionPerformed(evt);
            }
        });
        tblVenta.add(txtTotalProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 285, 100, -1));

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
        tblVenta.add(txtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 285, 100, -1));

        txtCodigoArticulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodigoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoArticuloActionPerformed(evt);
            }
        });
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
        btnQuitar.setText("Quitar Producto");
        btnQuitar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(204, 204, 255), java.awt.Color.white));
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        tblVenta.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 150, 30));

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
        tblVenta.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 110, 30));

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

        tblVenta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 900, 210));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        tblVenta.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 280, 190));

        txtTotalCobrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotalCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalCobrarActionPerformed(evt);
            }
        });
        tblVenta.add(txtTotalCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 635, 150, -1));

        clientesC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(clientesC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 200, -1));

        txtCaja.setBackground(new java.awt.Color(204, 204, 204));
        txtCaja.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCaja.setForeground(new java.awt.Color(204, 204, 204));
        txtCaja.setText("Caja");
        tblVenta.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        cajaTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVenta.add(cajaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 150, -1));

        btnCobrar1.setBackground(new java.awt.Color(0, 0, 255));
        btnCobrar1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCobrar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCobrar1.setText("Cobrar");
        btnCobrar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), java.awt.Color.white, java.awt.Color.white));
        btnCobrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrar1ActionPerformed(evt);
            }
        });
        tblVenta.add(btnCobrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 620, 160, 50));

        btnCancelar.setBackground(new java.awt.Color(0, 51, 255));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        tblVenta.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 150, 50));

        lblRectangulo5.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo5.setOpaque(true);
        tblVenta.add(lblRectangulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 590, 190));

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

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        if (txtCodigoArticulo.getText().equals("")) {
            this.setVisible(false);

        } else {
            try {

                int idProducto = Integer.parseInt(txtCodigoArticulo.getText());
                articuloBuscado = logica.consultarProducto(idProducto);
                if (articuloBuscado == null) {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Venta", JOptionPane.ERROR_MESSAGE);
                    limpiarCampos();
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

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        adminitirSoloNumeros(evt);
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // agregarProductoTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int indice = tblProductos.getSelectedRow();
        if (indice != -1) {
            //       detalleV.remove(indice);
            //     cargarTabla();
            //   actualizarPrecioTotal();
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
        /*
        JOptionPane.showConfirmDialog(this, venta);
        setVisible(false);
        detalleV.clear();
        cargarTabla();
        
        dispose();
        PrincipalForm.getInstance().setVisible(true);*/
        //   confirmacion();
    }//GEN-LAST:event_formWindowClosing

    private void txtTotalCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalCobrarActionPerformed

    }//GEN-LAST:event_txtTotalCobrarActionPerformed

    private void txtTotalProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalProductoActionPerformed

    }//GEN-LAST:event_txtTotalProductoActionPerformed

    private void txtCodigoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoArticuloActionPerformed

    }//GEN-LAST:event_txtCodigoArticuloActionPerformed

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

    private void btnCobrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrar1ActionPerformed
        /*
        if (detalleV.size() > 0) {
            List<Venta> ventas = logica.consultarVentas();
            int numTicket;
            if (ventas.size() < 1) {
                numTicket = 0;
            } else {
                numTicket = ventas.get(ventas.size() - 1).getId() + 1;
            }
            Calendar fecha = Calendar.getInstance();
            Float totalVenta = Float.valueOf(txtTotalCobrar.getText());

            int indiceCliente = clientesC.getSelectedIndex();
            Cliente cliente = new Cliente();
            if (indiceCliente >= 0) {
                cliente = clientes.get(indiceCliente);
            }
            venta = new Venta(numTicket, fecha, totalVenta, cliente, caja);

            venta.setDetalleVentas(detalleV);

            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    FrmCobro.getInstance().setVisible(true);
                    FrmCobro.getInstance().establecerVenta(venta);
                }
            });

        } else {
            JOptionPane.showMessageDialog(null, "No ha agregado productos");
        }
         */
    }//GEN-LAST:event_btnCobrar1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
          confirmacion();
    }//GEN-LAST:event_btnCancelarActionPerformed

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

    public void llenarCBoxClientes() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        clientes = logica.consultarTodosClientes();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente get = clientes.get(i);
            model.addElement(get.getNombre());
        }
        clientesC.setModel(model);
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

    public static VentasForm getInstance() {
        if (ventasForm == null) {
            ventasForm = new VentasForm();
        }
        return ventasForm;
    }

    public void establecerCaja(Caja cajaAbierta) {
        cajaTxt.setText("" + cajaAbierta.getId());
        txtOperador.setText("" + cajaAbierta.getUsuario().getNombre());
        this.caja = cajaAbierta;
    }

    public void llenarCampos() {
        Calendar fechaC = Calendar.getInstance();
        Date fecha = fechaC.getTime();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = formatoFecha.format(fecha);
        this.txtFecha.setText(fechaFormateada);
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
    }

    public void agregarArtBuscado(Producto productoS) {
        articuloBuscado = productoS;
        cargarCampos(articuloBuscado);
    }

    public void cargarCampos(Producto productoCargado) {
        txtCodigoArticulo.setText(productoCargado.getId() + "");
        txtDescripcion.setText(productoCargado.getDescripcion());
        txtCategoria.setText(productoCargado.getCategoria().getNombre());
        txtDisponibilidad.setText(productoCargado.getStock() + "");
        txtImporte.setText(productoCargado.getPrecio() + "");
        txtTotalProducto.setText(productoCargado.getPrecio() + "");
        txtCantidad.setText("1");
        this.articuloBuscado = productoCargado;
    }
   private void confirmacion() {

        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea cancelar la venta?", "Salir", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
//            this.limpiarCamposTodo();
            // setVisible(false);
            detalleV.clear();
  //          cargarTabla();

            dispose();
            PrincipalForm.getInstance().setVisible(true);
        }
    }
    /*
    private FrmCobro frmCobro;
    Venta venta = null;

    private float precio;
    public BusquedaArticuloForm frmBusArt;
        public static VentasForm frmVentas;

        this.logica = new FachadaControl();
        //this.productos = new ArrayList<>();
        this.detalleV = new ArrayList<>();
        this.precio = (float) 0.00;
        llenarCBoxClientes();
        llenarCampos();
        txtCategoria.setEditable(false);
        //this.txtImporte.setEditable(false);
        this.txtTotalProducto.setEditable(false);
        this.txtDisponibilidad.setEditable(false);
        this.txtDescripcion.setEditable(false);
        this.txtTotalCobrar.setEditable(false);
        this.txtFecha.setEditable(false);
        this.txtNumTicket.setEditable(false);
        this.txtOperador.setEditable(false);
        this.cajaTxt.setEditable(false);
    public boolean validarDatos() {
        String regexNumeros = "\\d+";

        if (!txtCantidad.getText().matches(regexNumeros) || Integer.parseInt(txtCantidad.getText()) <= 0 || Integer.parseInt(txtCantidad.getText()) > 999999999) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese un numero entero mayor a 0 y no mayor a 999999999, en la cantidad a comprar");
            return true;
        }

        return false;
    }
    
  

  

    public void limpiarCamposTodo() {
        txtCantidad.setText("");
        txtCategoria.setText("");
        txtCodigoArticulo.setText("");
        txtDescripcion.setText("");
        txtDisponibilidad.setText("");
        txtImporte.setText("");
        txtTotalCobrar.setText("");
        txtObservaciones.setText("");
        txtTotalProducto.setText("");
        detalleV.clear();
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
    private void agregarProductoTabla() {
        if (validarDatos()) {
            return;
        }
        if ((txtCodigoArticulo.getText().trim() != "") && (!txtTotalProducto.getText().isEmpty())) {
            int cantidad = Integer.parseInt(txtCantidad.getText());
            float totalProducto = Float.parseFloat(txtTotalProducto.getText());
            Producto productoAgregar = articuloBuscado;
            boolean repetido = false;
            if (cantidad <= productoAgregar.getStock()) {
                for (int i = 0; i < detalleV.size(); i++) {
                    if (productoAgregar.getId() == detalleV.get(i).getProducto().getId()) {
                        if (productoAgregar.getStock() < cantidad + detalleV.get(i).getCantidad()) {
                            int restante = (int) (productoAgregar.getStock() - detalleV.get(i).getCantidad());
                            repetido = true;

                            String mensaje = "Stock Producto: " + productoAgregar.getStock() + "\nCantidad actual agregada: " + detalleV.get(i).getCantidad() + "\nRestante: " + restante;
                            JOptionPane.showMessageDialog(null, mensaje, "Excede el stock", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        } else if (productoAgregar.getId() == detalleV.get(i).getProducto().getId()) {
                            detalleV.get(i).setCantidad(detalleV.get(i).getCantidad() + cantidad);
                            detalleV.get(i).setImporte(detalleV.get(i).getImporte() + totalProducto);
                            actualizarPrecioTotal();
                            cargarTabla();
                            limpiarCampos();
                            repetido = true;
                            break;
                        } else {

                        }
                    }
                }
                if (repetido == false) {
                    DetalleVenta dv = new DetalleVenta();
                    dv.setCantidad(cantidad);
                    dv.setImporte(totalProducto);
                    dv.setPrecioVendido(Float.parseFloat(txtImporte.getText()));
                    dv.setProducto(productoAgregar);
                    detalleV.add(dv);
                    actualizarPrecioTotal();
                    cargarTabla();
                    limpiarCampos();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Se ingreso una cantidad mayor al stock");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese producto");
        }
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

 
    public void registrarTodoVenta() {

        try {
            registrarVenta();

        } catch (Exception e) {

        }
        limpiarCamposTodo();
        detalleV.clear();
        cargarTabla();
    }

    public void registrarVenta() {

        if (detalleV.size() > 0) {
            List<Venta> ventas = logica.consultarVentas();
            int numTicket;
            if (ventas.size() < 1) {
                numTicket = 0;
            } else {
                numTicket = ventas.get(ventas.size() - 1).getId() + 1;
            }
            Calendar fecha = Calendar.getInstance();
            Float totalVenta = Float.valueOf(txtTotalCobrar.getText());
            int indiceCliente = clientesC.getSelectedIndex();
            Cliente cliente = clientes.get(indiceCliente);
            venta = new Venta(numTicket, fecha, totalVenta, cliente, caja);
            boolean ventaAgregada = logica.agregarVenta(venta, detalleV);

            if (ventaAgregada == true) {

                JOptionPane.showMessageDialog(null, "La venta fue agregada exitosamente");
                this.limpiarCampos();
            }
        }

    }
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCobrar1;
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
    private javax.swing.JLabel lblRectangulo5;
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
