package GUIs;

import entidades.Usuario;
import enumeradores.Rol;
import fachada.FachadaControl;
import interfaces.IFachadaControl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class PrincipalForm extends javax.swing.JFrame {

    private IFachadaControl fachadaControl;
    private static PrincipalForm principalForm;
    private Usuario usuarioSesion;

    private PrincipalForm() {
        initComponents();
        this.usuarioSesion = null;
        this.fachadaControl = new FachadaControl();
    }

    public static PrincipalForm getInstance() {
        if (principalForm == null) {
            principalForm = new PrincipalForm();
        }
        return principalForm;
    }

    public void establecerSession(Usuario usuario) {
        this.usuarioSesion = usuario;
        this.jLabelTitulo.setText("Usuario; " + this.usuarioSesion.getNombre() + " Rol; " + this.usuarioSesion.getRol());
        if (usuario.getRol() == Rol.ADMINISTRADOR) {
        }
        if (usuario.getRol() == Rol.TECNICO) {
            this.jButtonUsuarios.setEnabled(false);
            this.jButtonCatehorias.setEnabled(false);
            this.jButtonProductos.setEnabled(false);
            this.jButtonRealizarVenta.setEnabled(false);
            this.jButtonClientes.setEnabled(false);
            this.jButtonProveedores.setEnabled(false);
        }
        if (usuario.getRol() == Rol.VENDEDOR) {
            this.jButtonUsuarios.setEnabled(false);
            this.jButtonCatehorias.setEnabled(false);
            this.jButtonProductos.setEnabled(false);
            this.jButtonRealizarVenta.setEnabled(false);
            this.jButtonClientes.setEnabled(false);
            this.jButtonProveedores.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonRealizarVenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonClientes = new javax.swing.JButton();
        jButtonProductos = new javax.swing.JButton();
        jButtonCatehorias = new javax.swing.JButton();
        jButtonProveedores = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCaja1 = new javax.swing.JMenu();
        menuCajaNuevoTicket1 = new javax.swing.JMenuItem();
        menuCajaAbrirCaja1 = new javax.swing.JMenuItem();
        menuCajaCierreCaja1 = new javax.swing.JMenuItem();
        MenuAdmin = new javax.swing.JMenu();
        MenuAdminCategoria = new javax.swing.JMenuItem();
        MenuAdminClientes = new javax.swing.JMenuItem();
        MenuAdminProductos = new javax.swing.JMenuItem();
        MenuAdminProveedores = new javax.swing.JMenuItem();
        MenuAdminUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administración");

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(1000, 750));
        pnlPrincipal.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        pnlPrincipal.add(jLabelTitulo);
        jLabelTitulo.setBounds(40, 20, 920, 60);

        jButtonRealizarVenta.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonRealizarVenta.setText("Realizar Venta");
        jButtonRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizarVentaActionPerformed(evt);
            }
        });
        pnlPrincipal.add(jButtonRealizarVenta);
        jButtonRealizarVenta.setBounds(470, 320, 220, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        pnlPrincipal.add(jLabel1);
        jLabel1.setBounds(10, 130, 390, 410);

        jButtonClientes.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonClientes.setText("Clientes");
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });
        pnlPrincipal.add(jButtonClientes);
        jButtonClientes.setBounds(730, 420, 220, 60);

        jButtonProductos.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonProductos.setText("Productos");
        jButtonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductosActionPerformed(evt);
            }
        });
        pnlPrincipal.add(jButtonProductos);
        jButtonProductos.setBounds(470, 220, 220, 60);

        jButtonCatehorias.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonCatehorias.setText("Categorias");
        jButtonCatehorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCatehoriasActionPerformed(evt);
            }
        });
        pnlPrincipal.add(jButtonCatehorias);
        jButtonCatehorias.setBounds(470, 420, 220, 60);

        jButtonProveedores.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonProveedores.setText("Proveedores");
        jButtonProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProveedoresActionPerformed(evt);
            }
        });
        pnlPrincipal.add(jButtonProveedores);
        jButtonProveedores.setBounds(730, 220, 220, 60);

        jButtonUsuarios.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonUsuarios.setText("Usuarios");
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });
        pnlPrincipal.add(jButtonUsuarios);
        jButtonUsuarios.setBounds(730, 320, 220, 60);

        jMenuBar1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        MenuCaja1.setText("Venta");
        MenuCaja1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        menuCajaNuevoTicket1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        menuCajaNuevoTicket1.setText("Nueva Venta");
        menuCajaNuevoTicket1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCajaNuevoTicket1ActionPerformed(evt);
            }
        });
        MenuCaja1.add(menuCajaNuevoTicket1);

        menuCajaAbrirCaja1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        menuCajaAbrirCaja1.setText("Abrir Nueva Caja");
        menuCajaAbrirCaja1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCajaAbrirCaja1ActionPerformed(evt);
            }
        });
        MenuCaja1.add(menuCajaAbrirCaja1);

        menuCajaCierreCaja1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        menuCajaCierreCaja1.setText("Cierre de Caja");
        menuCajaCierreCaja1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCajaCierreCaja1ActionPerformed(evt);
            }
        });
        MenuCaja1.add(menuCajaCierreCaja1);

        jMenuBar1.add(MenuCaja1);

        MenuAdmin.setText("Administrador");
        MenuAdmin.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        MenuAdminCategoria.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminCategoria.setText("Categorias");
        MenuAdminCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminCategoriaActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuAdminCategoria);

        MenuAdminClientes.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminClientes.setText("Clientes");
        MenuAdminClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminClientesActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuAdminClientes);

        MenuAdminProductos.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminProductos.setText("Productos");
        MenuAdminProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminProductosActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuAdminProductos);

        MenuAdminProveedores.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminProveedores.setText("Proveedores");
        MenuAdminProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminProveedoresActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuAdminProveedores);

        MenuAdminUsuario.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
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

    private void MenuAdminUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminUsuarioActionPerformed

    }//GEN-LAST:event_MenuAdminUsuarioActionPerformed

    private void MenuAdminCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminCategoriaActionPerformed

    }//GEN-LAST:event_MenuAdminCategoriaActionPerformed

    private void MenuAdminClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminClientesActionPerformed

    }//GEN-LAST:event_MenuAdminClientesActionPerformed

    private void MenuAdminProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminProductosActionPerformed

    }//GEN-LAST:event_MenuAdminProductosActionPerformed

    private void MenuAdminProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminProveedoresActionPerformed


    }//GEN-LAST:event_MenuAdminProveedoresActionPerformed

    private void menuCajaNuevoTicket1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCajaNuevoTicket1ActionPerformed

    }//GEN-LAST:event_menuCajaNuevoTicket1ActionPerformed

    private void menuCajaAbrirCaja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCajaAbrirCaja1ActionPerformed

    }//GEN-LAST:event_menuCajaAbrirCaja1ActionPerformed

    private void menuCajaCierreCaja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCajaCierreCaja1ActionPerformed

    }//GEN-LAST:event_menuCajaCierreCaja1ActionPerformed

    private void jButtonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductosActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiProductoForm.getInstance().setVisible(true);
            }
        });

    }//GEN-LAST:event_jButtonProductosActionPerformed

    private void jButtonRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizarVentaActionPerformed

    }//GEN-LAST:event_jButtonRealizarVentaActionPerformed

    private void jButtonCatehoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCatehoriasActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiCategoria.getInstance().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonCatehoriasActionPerformed

    private void jButtonProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProveedoresActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiProveedorForm.getInstance().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonProveedoresActionPerformed

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed

        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiUsuarioForm.getInstance().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiClienteForm.getInstance().setVisible(true);

            }
        });
    }//GEN-LAST:event_jButtonClientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAdmin;
    private javax.swing.JMenuItem MenuAdminCategoria;
    private javax.swing.JMenuItem MenuAdminClientes;
    private javax.swing.JMenuItem MenuAdminProductos;
    private javax.swing.JMenuItem MenuAdminProveedores;
    private javax.swing.JMenuItem MenuAdminUsuario;
    private javax.swing.JMenu MenuCaja1;
    private javax.swing.JButton jButtonCatehorias;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonProductos;
    private javax.swing.JButton jButtonProveedores;
    private javax.swing.JButton jButtonRealizarVenta;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCajaAbrirCaja1;
    private javax.swing.JMenuItem menuCajaCierreCaja1;
    private javax.swing.JMenuItem menuCajaNuevoTicket1;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
