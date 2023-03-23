/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import entidades.DetalleVenta;
import entidades.Venta;
import fachada.FachadaControl;
import interfaces.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrmCobro extends javax.swing.JFrame {

    IFachadaControl logica = new FachadaControl();
    VentasForm ventasFrm = null;
    private FrmCobro frmCobro = null;
    private Venta venta = new Venta();
    public static FrmCobro frmCobro1;

    /**
     * Creates new form FrmCobro
     */
    public FrmCobro() {
        initComponents();
        this.setLocationRelativeTo(null);
        instanciaVentasForm();

    }

    public FrmCobro(Venta venta) {
        initComponents();
        this.setLocationRelativeTo(null);
        instanciaVentasForm();
        this.venta = venta;

    }

    public static FrmCobro getInstance() {
        if (frmCobro1 == null) {
            frmCobro1 = new FrmCobro();
        }
        return frmCobro1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMontoUsuario = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        checkBoxTicket = new javax.swing.JCheckBox();
        lblRectangulo4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTicket = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cobro");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("REALIZAR COBRO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ticket:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Monto Usuario: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        txtMontoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoUsuarioActionPerformed(evt);
            }
        });
        txtMontoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoUsuarioKeyReleased(evt);
            }
        });
        jPanel1.add(txtMontoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 170, -1));

        btnCancelar.setBackground(new java.awt.Color(0, 0, 255));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        btnContinuar.setBackground(new java.awt.Color(0, 0, 255));
        btnContinuar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/continuar.png"))); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));
        jPanel1.add(checkBoxTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        jPanel1.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 420, 130));

        txtTicket.setColumns(20);
        txtTicket.setRows(5);
        jScrollPane1.setViewportView(txtTicket);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 280, 400));

        jLabel4.setText("Cambio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));
        jPanel1.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMontoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoUsuarioActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed

        if (validaDatos() == true) {

            ventasFrm.registrarTodoVenta();
            cerrarFormulario();
        }

//         

    }//GEN-LAST:event_btnContinuarActionPerformed

    public boolean validaDatos() {
        if ("".equals(txtMontoUsuario.getText().trim())) {

            JOptionPane.showMessageDialog(null, "Campo vacio");
            return false;
        } else if (Float.parseFloat(txtMontoUsuario.getText()) < venta.getTotalventa()) {

            JOptionPane.showMessageDialog(null, "Monto ingresado menor al total de la venta");
            return false;
        }

        return true;
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cerrarFormulario();
//        ventasFrm.desbloquearCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtMontoUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoUsuarioKeyReleased
        if (txtMontoUsuario.getText().trim() != "") {
            if (txtMontoUsuario.getText().isEmpty()) {
                txtCambio.setText("");
            } else {
                if (Float.parseFloat(txtMontoUsuario.getText()) >= venta.getTotalventa()) {
                    float cambio = Float.parseFloat(txtMontoUsuario.getText()) - venta.getTotalventa();
                    this.txtCambio.setText(String.valueOf(cambio));
                } else {
                    txtCambio.setText("");
                }
            }

        } else {
            this.txtCambio.setText("");
        }
    }//GEN-LAST:event_txtMontoUsuarioKeyReleased

    public void mostrarFormulario(VentasForm ventas, Venta venta, List<DetalleVenta> detalles) {
        instanciaFrmCobro(venta);
        frmCobro.mostrarTicket(venta, detalles);
        frmCobro.setLocationRelativeTo(null);
        frmCobro.setVisible(true);
        this.venta = venta;
        this.ventasFrm = ventas;

    }

    public void mostrarTicket(Venta venta, List<DetalleVenta> detalles) {

        String ticket = "";
        int espacioNombre = 0;
        int espacioCantidad = 0;
        int espacioPrecio = 0;
        int espacioImporte = 0;
        // Formatear los datos de cada producto en una sola línea y agregarlos al ticket
        ticket += "-------------------------------------------------------------------\n";
        ticket += "                            TICKET DE VENTA                        \n";
        ticket += "-------------------------------------------------------------------\n";
        ticket += "Producto            Cantidad       Precio     importe              \n";
        ticket += "-------------------------------------------------------------------\n";
        for (DetalleVenta d : detalles) {

            int longitudNombre = d.getProducto().getNombre().length();
            int longitudCantidad = String.valueOf(d.getCantidad()).length();
            int longitudPrecio = String.valueOf(d.getProducto().getPrecio()).length();
            int longitudImporte = String.valueOf(d.getImporte()).length();
            espacioNombre = 15;
            espacioCantidad = 20 - longitudNombre;
            espacioPrecio = 20 - longitudCantidad;
            espacioImporte = 25 - longitudImporte;

            String linea = String.format("%-" + espacioNombre + "s %" + espacioCantidad + "s %" + espacioPrecio + "s %" + espacioImporte + "s\n", d.getProducto().getNombre(), d.getCantidad(), d.getProducto().getPrecio(), d.getImporte());
            ticket += linea;
        }
        ticket += "-------------------------------------------------------------------\n";
        String lineaTotal = String.format("%70s %10.2f\n", "Total:", venta.getTotalventa());
        ticket += lineaTotal;
        ticket += "-------------------------------------------------------------------\n";

        txtTicket.setText(ticket);
        txtTicket.setEditable(false);

    }

    public void cerrarFormulario() {
        limpiar();
        this.dispose();

    }

    public VentasForm instanciaVentasForm() {
        if (ventasFrm == null) {
            ventasFrm = VentasForm.getInstance();
        }
        return ventasFrm;
    }

    public FrmCobro instanciaFrmCobro(Venta venta) {
        if (frmCobro == null) {
            frmCobro = new FrmCobro(venta);
        }
        return frmCobro;
    }

    public void limpiar() {
        txtMontoUsuario.setText("");
        txtCambio.setText("");
        
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JCheckBox checkBoxTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRectangulo4;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtMontoUsuario;
    private javax.swing.JTextArea txtTicket;
    // End of variables declaration//GEN-END:variables
}
/*


 */
