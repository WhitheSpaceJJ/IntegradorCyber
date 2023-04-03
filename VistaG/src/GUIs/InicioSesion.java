package GUIs;

import GUIs.utils.JTextFieldLimit;
import entidades.Usuario;
import enumeradores.Rol;
import fachada.FachadaControl;
import interfaces.IFachadaControl;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class InicioSesion extends javax.swing.JFrame {

    private IFachadaControl control;
    private static InicioSesion instance;

    private InicioSesion() {
        initComponents();
        this.control = new FachadaControl();
        this.jTextFieldUsuario.setDocument(new JTextFieldLimit(45));
        this.jTextFieldUsuario.setDocument(new JTextFieldLimit(20));
        Usuario usuarioConsulta = this.control.consultarUsuario(1);
        if (usuarioConsulta == null) {
            JOptionPane.showMessageDialog(null, "Bienvenido querido usuario para comenzar el uso del sistema registre un usuario");
            this.jButtonIniciarSesion.setText("Registrar");
            this.jLabel2.setText("Registrar Usuario");
            this.cmbRoles.setSelectedIndex(0);
            this.cmbRoles.setEnabled(false);
        }
    }

    public static InicioSesion getInstance() {
        if (instance == null) {
            instance = new InicioSesion();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordFieldContraseña = new javax.swing.JPasswordField();
        jButtonIniciarSesion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbRoles = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inicio Sesion");
        setMinimumSize(new java.awt.Dimension(450, 350));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Inicio de Sesion");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 10, 290, 50);

        jTextFieldUsuario.setColumns(10);
        jTextFieldUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(160, 70, 260, 40);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Usuario");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 70, 90, 40);
        jPanel1.add(jPasswordFieldContraseña);
        jPasswordFieldContraseña.setBounds(160, 130, 260, 40);

        jButtonIniciarSesion.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButtonIniciarSesion.setText("Iniciar");
        jButtonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSesionActionPerformed(evt);
            }
        });
        jButtonIniciarSesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonIniciarSesionKeyPressed(evt);
            }
        });
        jPanel1.add(jButtonIniciarSesion);
        jButtonIniciarSesion.setBounds(140, 250, 130, 40);

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Rol");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 180, 130, 40);

        cmbRoles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "VENDEDOR", "TECNICO" }));
        cmbRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRolesActionPerformed(evt);
            }
        });
        cmbRoles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbRolesKeyPressed(evt);
            }
        });
        jPanel1.add(cmbRoles);
        cmbRoles.setBounds(160, 180, 260, 40);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Contraseña");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 130, 130, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 350);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarSesionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonIniciarSesionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.iniciarSesion();
        }
    }//GEN-LAST:event_jButtonIniciarSesionKeyPressed

    private void cmbRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRolesActionPerformed

    }//GEN-LAST:event_cmbRolesActionPerformed

    private void cmbRolesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbRolesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            int indiceCombo = this.cmbRoles.getSelectedIndex();
            if (indiceCombo == 2) {
                this.cmbRoles.setSelectedIndex(0);
            } else {
                this.cmbRoles.setSelectedIndex(indiceCombo + 1);
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            int indiceCombo = this.cmbRoles.getSelectedIndex();
            if (indiceCombo == 0) {
                this.cmbRoles.setSelectedIndex(2);
            } else {
                this.cmbRoles.setSelectedIndex(indiceCombo - 1);
            }
        }
    }//GEN-LAST:event_cmbRolesKeyPressed

    private void jButtonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSesionActionPerformed
        this.iniciarSesion();
    }//GEN-LAST:event_jButtonIniciarSesionActionPerformed

    public void iniciarSesion() {
        if (this.jButtonIniciarSesion.getText().equalsIgnoreCase("Registrar")) {
            if (validarCamposVacios()) {
                return;
            }
            String usuarioNombre = this.jTextFieldUsuario.getText();
            String contrasena = this.jPasswordFieldContraseña.getText();
            int indice = this.cmbRoles.getSelectedIndex();
            Rol rol = Rol.valueOf(this.cmbRoles.getItemAt(indice));
            Usuario usuario2 = new Usuario(usuarioNombre, contrasena, rol);
            boolean esta2 = this.control.agregarUsuario(usuario2);
            if (esta2) {
                this.limpiarCampos();
                this.setVisible(false);
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        PrincipalForm.getInstance().establecerSession(usuario2);
                        PrincipalForm.getInstance().setVisible(true);

                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "No se ha determinado la existencia de un usuario");
            }
            this.limpiarCampos();
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                                                                    PrincipalForm.getInstance().establecerSession(usuario2);
                    PrincipalForm.getInstance().setVisible(true);

                }
            });
        } else {
            if (validarCamposVacios()) {
                return;
            }
            String usuarioNombre = this.jTextFieldUsuario.getText();
            String contrasena = this.jPasswordFieldContraseña.getText();
            int indice = this.cmbRoles.getSelectedIndex();
            Rol rol = Rol.valueOf(this.cmbRoles.getItemAt(indice));
            Usuario usuario = new Usuario(usuarioNombre, contrasena, rol);
            boolean esta = this.control.iniciarSesion(usuario);
            if (esta) {
                this.limpiarCampos();
                this.setVisible(false);
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                                                PrincipalForm.getInstance().establecerSession(usuario);
                        PrincipalForm.getInstance().setVisible(true);

                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "No se ha determinado la existencia de un usuario");
            }
        }

    }

    public void limpiarCampos() {
         this.jLabel2.setText("Inicio de Sesion");
        this.jTextFieldUsuario.setText("");
        this.jPasswordFieldContraseña.setText("");
        this.jButtonIniciarSesion.setEnabled(true);
    }

    public boolean validarCamposVacios() {
        if (this.jTextFieldUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el usuario");
            return true;
        }
        if (this.jPasswordFieldContraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el usuario");
            return true;
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbRoles;
    private javax.swing.JButton jButtonIniciarSesion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldContraseña;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
