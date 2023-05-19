/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIs;

import entidades.Caja;
import entidades.Usuario;
import enumeradores.Estado;
import fachada.FachadaControl;
import interfaces.IFachadaControl;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author jarol
 */
public class CerrarCajaForm extends javax.swing.JFrame  {

       private static CerrarCajaForm cerrarCaja;
    private IFachadaControl logica;
        Caja caja = new Caja();
        Usuario usuario=new Usuario();
    /**
     * Creates new form CerrarCajaForm
     */
    public CerrarCajaForm() {
        initComponents();
          this.logica = new FachadaControl();
     txtOperador.setEditable(false);
      txtFecha.setEditable(false);
      
      llenarCampos();
     
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtOperador = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtSaldoCierre = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblRectangulo4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("CIERRE DE CAJA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Operador:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Fecha Cierre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Saldo Cierre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        txtOperador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOperadorKeyTyped(evt);
            }
        });
        jPanel1.add(txtOperador, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 140, 30));

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 260, 30));

        txtSaldoCierre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoCierreKeyTyped(evt);
            }
        });
        jPanel1.add(txtSaldoCierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 140, 30));

        btnCancelar.setBackground(new java.awt.Color(0, 0, 255));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), java.awt.Color.white, java.awt.Color.white));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 120, 40));

        btnCerrar.setBackground(new java.awt.Color(0, 0, 255));
        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), java.awt.Color.white, java.awt.Color.white));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 120, 40));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 80, 50));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 80, 50));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 80, 50));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 80, 50));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 150, 30));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        jPanel1.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 500, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public static CerrarCajaForm instanciaCerrarCaja() {
        if (cerrarCaja == null) {
            cerrarCaja = new CerrarCajaForm();
        }
        return cerrarCaja;
    }
      public void mostrarFormulario() {
        cerrarCaja.setLocationRelativeTo(null);
        cerrarCaja.setVisible(true);

    }
      
        public void cerrarCajaForm() {
        cerrarCaja.dispose();
        PrincipalForm.getInstance().setVisible(true);
    }

    private void txtOperadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOperadorKeyTyped
    }//GEN-LAST:event_txtOperadorKeyTyped

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed

    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();     
    }//GEN-LAST:event_btnCancelarActionPerformed

     public void llenarCampos() {
        Calendar fechaC = Calendar.getInstance();
        Date fecha = fechaC.getTime();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = formatoFecha.format(fecha);
           caja=logica.consultarCajaAbierta() ;
        usuario=caja.getUsuario();
        usuario=logica.consultarUsuario(usuario.getId());
        
        txtOperador.setText(usuario.toString());
        this.txtFecha.setText(fechaFormateada);
    }

    
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
       if (validarDatos()) {
            return;
        }
       float saldoCierre;
        Caja c = new Caja();
        c=logica.consultarCajaAbierta();
        if (c != null) {
        saldoCierre=Float.parseFloat(txtSaldoCierre.getText().trim());
        c.setSaldoCierre(saldoCierre);
        c.setEstado(Estado.CERRADA);
         c.setFechaApertura(Calendar.getInstance());
         c.setTotalIngresos(saldoCierre-c.getSaldoInicial());
        
         try{
            logica.cerrarCaja(c);
          JOptionPane.showMessageDialog(null, "Caja cerrada con exito");
            this.cerrarCajaForm();
         }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cerrar caja");
        }
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

      
      public boolean validarDatos() {
        String regexFloat = "\\d+(\\.\\d+)?";
        if (!txtSaldoCierre.getText().matches(regexFloat) || Float.parseFloat(txtSaldoCierre.getText()) <= 0 || Float.parseFloat(txtSaldoCierre.getText()) > 999999999) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el saldo de cierre");
            return true;
        }
        return false;
    }
    
    private void txtSaldoCierreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoCierreKeyTyped
        numeroDecimal(evt);
    }//GEN-LAST:event_txtSaldoCierreKeyTyped

     public void numeroDecimal(java.awt.event.KeyEvent evt) {
        char car = evt.getKeyChar();
        if (Character.isDigit(car) || car == '.') {

        } else {
            evt.consume();
            getToolkit().beep();
        }
    }
     public void limpiarCampos() {
        cerrarCaja.txtSaldoCierre.setText("");
       
    }
       
      
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         limpiarCampos();
        setVisible(false);
      
        dispose();
        PrincipalForm.getInstance().setVisible(true);
        
         
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRectangulo4;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtOperador;
    private javax.swing.JTextField txtSaldoCierre;
    // End of variables declaration//GEN-END:variables

}