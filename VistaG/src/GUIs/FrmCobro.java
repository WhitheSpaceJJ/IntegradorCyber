/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import fachada.FachadaControl;
import interfaces.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrmCobro extends javax.swing.JFrame {

    IFachadaControl logica = new FachadaControl();
    VentasForm ventasFrm = null;
    FrmCobro frmCobro = null;
    public static FrmCobro frmCobro1;

    /**
     * Creates new form FrmCobro
     */
    private FrmCobro() {
        initComponents();
        this.setLocationRelativeTo(null);
        instanciaVentasForm();
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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

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
        jPanel1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 224, -1, -1));
        jPanel1.add(checkBoxTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        jPanel1.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 420, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMontoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoUsuarioActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        cerrarFormulario();
        ventasFrm.registrarVenta();
        
//         

    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cerrarFormulario();
        ventasFrm.desbloquearCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void mostrarFormulario() {
        instanciaFrmCobro();
        frmCobro.setLocationRelativeTo(null);
        frmCobro.setVisible(true);

    }

    public void cerrarFormulario() {
        this.dispose();
    }

    public VentasForm instanciaVentasForm() {
        if (ventasFrm == null) {
            ventasFrm = VentasForm.getInstance();
        }
        return ventasFrm;
    }

    public FrmCobro instanciaFrmCobro() {
        if (frmCobro == null) {
            frmCobro = new FrmCobro();
        }
        return frmCobro;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRectangulo4;
    private javax.swing.JTextField txtMontoUsuario;
    // End of variables declaration//GEN-END:variables
}
/*


 */
