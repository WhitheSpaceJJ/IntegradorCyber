package GUIs;

import entidades.Caja;
import fachada.FachadaControl;
import interfaces.IFachadaControl;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author giova
 */
public class PrincipalForm extends javax.swing.JFrame {

    private VentasForm ventasForm = new VentasForm();
    IFachadaControl logica = new FachadaControl();
    AbrirCajaForm abrirCaja = new AbrirCajaForm();
    public static PrincipalForm principalFrm = null;

    /**
     * Creates new form PrincipalForm
     */
    public PrincipalForm() {
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

        pnlPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuCaja = new javax.swing.JMenu();
        menuCajaNuevoTicket = new javax.swing.JMenuItem();
        menuCajaAbrirCaja = new javax.swing.JMenuItem();
        menuCajaCierreCaja = new javax.swing.JMenuItem();
        MenuAdmin = new javax.swing.JMenu();
        MenuAdminCategoria = new javax.swing.JMenuItem();
        MenuAdminClientes = new javax.swing.JMenuItem();
        MenuAdminProductos = new javax.swing.JMenuItem();
        MenuAdminProveedores = new javax.swing.JMenuItem();
        MenuAdminUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setPreferredSize(new java.awt.Dimension(1000, 750));
        pnlPrincipal.setLayout(new java.awt.CardLayout());

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        MenuCaja.setText("Caja");

        menuCajaNuevoTicket.setText("Nuevo Ticket");
        menuCajaNuevoTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCajaNuevoTicketActionPerformed(evt);
            }
        });
        MenuCaja.add(menuCajaNuevoTicket);

        menuCajaAbrirCaja.setText("Abrir Nueva Caja");
        MenuCaja.add(menuCajaAbrirCaja);

        menuCajaCierreCaja.setText("Cierre de Caja");
        MenuCaja.add(menuCajaCierreCaja);

        jMenuBar1.add(MenuCaja);

        MenuAdmin.setText("Administrar");

        MenuAdminCategoria.setText("Categorias");
        MenuAdminCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminCategoriaActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuAdminCategoria);

        MenuAdminClientes.setText("Clientes");
        MenuAdmin.add(MenuAdminClientes);

        MenuAdminProductos.setText("Productos");
        MenuAdmin.add(MenuAdminProductos);

        MenuAdminProveedores.setText("Proveedores");
        MenuAdmin.add(MenuAdminProveedores);

        MenuAdminUsuario.setText("Usuario");
        MenuAdminUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminUsuarioActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuAdminUsuario);

        jMenuBar1.add(MenuAdmin);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCajaNuevoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCajaNuevoTicketActionPerformed
        // TODO add your handling code here:
        Caja caja = new Caja();
        caja = logica.consultarCajaAbierta();
        if (caja == null) {
            abrirCaja.instanciaAbrirCaja().mostrarFormulario();

        } else {
            ventasForm = ventasForm.instanciaFrmVentas();
            ventasForm.setCaja(caja);
            mostrarPanel(ventasForm);
        }


    }//GEN-LAST:event_menuCajaNuevoTicketActionPerformed

    private void MenuAdminUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAdminUsuarioActionPerformed

    private void MenuAdminCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminCategoriaActionPerformed
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdmiCategoria().setVisible(true);
            }
        });
    }//GEN-LAST:event_MenuAdminCategoriaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                instanciaFrmPrincipal().setVisible(true);

            }
        });

    }

    public void mostrarPanel(JPanel panelActual) {

        instanciaFrmPrincipal();
        principalFrm.pnlPrincipal.removeAll();
        principalFrm.pnlPrincipal.add(panelActual);
        principalFrm.pnlPrincipal.repaint();
        principalFrm.pnlPrincipal.revalidate();

    }

    public static PrincipalForm instanciaFrmPrincipal() {
        if (principalFrm == null) {
            principalFrm = new PrincipalForm();
        }
        return principalFrm;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAdmin;
    private javax.swing.JMenuItem MenuAdminCategoria;
    private javax.swing.JMenuItem MenuAdminClientes;
    private javax.swing.JMenuItem MenuAdminProductos;
    private javax.swing.JMenuItem MenuAdminProveedores;
    private javax.swing.JMenuItem MenuAdminUsuario;
    private javax.swing.JMenu MenuCaja;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCajaAbrirCaja;
    private javax.swing.JMenuItem menuCajaCierreCaja;
    private javax.swing.JMenuItem menuCajaNuevoTicket;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
