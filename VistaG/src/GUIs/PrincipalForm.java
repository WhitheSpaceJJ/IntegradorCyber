package GUIs;

import entidades.Caja;
import entidades.Usuario;
import enumeradores.Rol;
import fachada.FachadaControl;
import interfaces.IFachadaControl;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JOptionPane;

public class PrincipalForm extends javax.swing.JFrame {
    
    private IFachadaControl fachadaControl;
    private static PrincipalForm principalForm;
    private Usuario usuarioSesion;
    
    private PrincipalForm() {
        initComponents();
        this.usuarioSesion = null;
        this.fachadaControl = new FachadaControl();
        
    

jButtonProductos.setPreferredSize(new Dimension(40, 40));
    }
    
    public static PrincipalForm getInstance() {
        if (principalForm == null) {
            principalForm = new PrincipalForm();
        }
        return principalForm;
    }
    
    public void establecerSession(Usuario usuario) {
        this.usuarioSesion = usuario;
        this.jLabelTitulo.setText("Usuario: " + this.usuarioSesion.getNombre() + "\n Rol: " + this.usuarioSesion.getRol());
        if (usuario.getRol() == Rol.ADMINISTRADOR) {
            this.MenuTecnico.setEnabled(false);
            this.jButtonUsuarios.setEnabled(true);
            this.MenuVendedor.setEnabled(false);
        }
        if (usuario.getRol() == Rol.TECNICO) {
            this.jButtonUsuarios.setEnabled(false);
            this.MenuAdmin.setEnabled(false);
            this.MenuVendedor.setEnabled(false);
        }
        if (usuario.getRol() == Rol.VENDEDOR) {
            this.jButtonUsuarios.setEnabled(false);
            this.MenuAdmin.setEnabled(false);
            this.MenuTecnico.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound4 = new GUIs.PanelRound();
        jButtonCatehorias3 = new javax.swing.JButton();
        jButtonClientes3 = new javax.swing.JButton();
        jButtonProductos3 = new javax.swing.JButton();
        jButtonProveedores3 = new javax.swing.JButton();
        jButtonRealizarVenta3 = new javax.swing.JButton();
        jButtonUsuarios3 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        panelRound3 = new GUIs.PanelRound();
        jButtonCatehorias2 = new javax.swing.JButton();
        jButtonClientes2 = new javax.swing.JButton();
        jButtonProductos2 = new javax.swing.JButton();
        jButtonProveedores2 = new javax.swing.JButton();
        jButtonRealizarVenta2 = new javax.swing.JButton();
        jButtonUsuarios2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        panelRound2 = new GUIs.PanelRound();
        jButtonCatehorias1 = new javax.swing.JButton();
        jButtonClientes1 = new javax.swing.JButton();
        jButtonProductos1 = new javax.swing.JButton();
        jButtonProveedores1 = new javax.swing.JButton();
        jButtonRealizarVenta1 = new javax.swing.JButton();
        jButtonUsuarios1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        panelRound5 = new GUIs.PanelRound();
        panelRound1 = new GUIs.PanelRound();
        jButtonCatehorias = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();
        jButtonProductos = new javax.swing.JButton();
        jButtonProveedores = new javax.swing.JButton();
        jButtonRealizarVenta = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        MenuAdminMermas = new javax.swing.JMenuItem();
        MenuTecnico = new javax.swing.JMenu();
        MenuAdminCategoriaTecnico = new javax.swing.JMenuItem();
        MenuAdminClientesTecnico = new javax.swing.JMenuItem();
        MenuAdminProductosTecnico = new javax.swing.JMenuItem();
        MenuAdminProveedoresTecnico = new javax.swing.JMenuItem();
        MenuVendedor = new javax.swing.JMenu();
        MenuAdminCategoriaVendedor = new javax.swing.JMenuItem();
        MenuAdminClientesVendedor = new javax.swing.JMenuItem();
        MenuAdminProductosVendedor = new javax.swing.JMenuItem();
        MenuAdminProveedoresVendedor = new javax.swing.JMenuItem();

        panelRound4.setBackground(new java.awt.Color(204, 204, 255));
        panelRound4.setRoundBottomLeft(50);
        panelRound4.setRoundBottomRight(50);
        panelRound4.setRoundTopLeft(50);
        panelRound4.setRoundTopRight(50);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCatehorias3.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCatehorias3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonCatehorias3.setText("Categorias");
        jButtonCatehorias3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCatehorias3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCatehorias3ActionPerformed(evt);
            }
        });
        panelRound4.add(jButtonCatehorias3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 394, 220, 84));

        jButtonClientes3.setBackground(new java.awt.Color(255, 255, 255));
        jButtonClientes3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonClientes3.setText("Clientes");
        jButtonClientes3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonClientes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientes3ActionPerformed(evt);
            }
        });
        panelRound4.add(jButtonClientes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 394, 220, 84));

        jButtonProductos3.setBackground(new java.awt.Color(255, 255, 255));
        jButtonProductos3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonProductos3.setText("Productos");
        jButtonProductos3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProductos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductos3ActionPerformed(evt);
            }
        });
        panelRound4.add(jButtonProductos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 81, 220, 80));

        jButtonProveedores3.setBackground(new java.awt.Color(255, 255, 255));
        jButtonProveedores3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonProveedores3.setText("Proveedores");
        jButtonProveedores3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProveedores3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProveedores3ActionPerformed(evt);
            }
        });
        panelRound4.add(jButtonProveedores3, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 81, 220, 80));

        jButtonRealizarVenta3.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRealizarVenta3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonRealizarVenta3.setText("Realizar Venta");
        jButtonRealizarVenta3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRealizarVenta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizarVenta3ActionPerformed(evt);
            }
        });
        panelRound4.add(jButtonRealizarVenta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 231, 220, 84));

        jButtonUsuarios3.setBackground(new java.awt.Color(255, 255, 255));
        jButtonUsuarios3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonUsuarios3.setText("Usuarios");
        jButtonUsuarios3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonUsuarios3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuarios3ActionPerformed(evt);
            }
        });
        panelRound4.add(jButtonUsuarios3, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 231, 220, 84));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-proveedor-48.png"))); // NOI18N
        panelRound4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 50, 48));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-recibo-48.png"))); // NOI18N
        jLabel27.setText("jLabel2");
        panelRound4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 62, 48));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-usuarios-48.png"))); // NOI18N
        jLabel28.setText("jLabel2");
        panelRound4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 62, 48));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-categorizar-48.png"))); // NOI18N
        jLabel29.setText("jLabel2");
        panelRound4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 62, 48));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-clientes-48.png"))); // NOI18N
        jLabel30.setText("jLabel2");
        panelRound4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 62, 48));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-agregar-a-carrito-de-compras-48.png"))); // NOI18N
        jLabel31.setText("jLabel2");
        panelRound4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 62, -1));

        jLabel32.setText("jLabel2");
        panelRound4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 76, 62, 48));

        jLabel33.setText("jLabel2");
        panelRound4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 86, 62, 48));

        panelRound3.setBackground(new java.awt.Color(204, 204, 255));
        panelRound3.setRoundBottomLeft(50);
        panelRound3.setRoundBottomRight(50);
        panelRound3.setRoundTopLeft(50);
        panelRound3.setRoundTopRight(50);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCatehorias2.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCatehorias2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonCatehorias2.setText("Categorias");
        jButtonCatehorias2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCatehorias2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCatehorias2ActionPerformed(evt);
            }
        });
        panelRound3.add(jButtonCatehorias2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 394, 220, 84));

        jButtonClientes2.setBackground(new java.awt.Color(255, 255, 255));
        jButtonClientes2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonClientes2.setText("Clientes");
        jButtonClientes2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonClientes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientes2ActionPerformed(evt);
            }
        });
        panelRound3.add(jButtonClientes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 394, 220, 84));

        jButtonProductos2.setBackground(new java.awt.Color(255, 255, 255));
        jButtonProductos2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonProductos2.setText("Productos");
        jButtonProductos2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProductos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductos2ActionPerformed(evt);
            }
        });
        panelRound3.add(jButtonProductos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 81, 220, 80));

        jButtonProveedores2.setBackground(new java.awt.Color(255, 255, 255));
        jButtonProveedores2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonProveedores2.setText("Proveedores");
        jButtonProveedores2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProveedores2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProveedores2ActionPerformed(evt);
            }
        });
        panelRound3.add(jButtonProveedores2, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 81, 220, 80));

        jButtonRealizarVenta2.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRealizarVenta2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonRealizarVenta2.setText("Realizar Venta");
        jButtonRealizarVenta2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRealizarVenta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizarVenta2ActionPerformed(evt);
            }
        });
        panelRound3.add(jButtonRealizarVenta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 231, 220, 84));

        jButtonUsuarios2.setBackground(new java.awt.Color(255, 255, 255));
        jButtonUsuarios2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonUsuarios2.setText("Usuarios");
        jButtonUsuarios2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonUsuarios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuarios2ActionPerformed(evt);
            }
        });
        panelRound3.add(jButtonUsuarios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 231, 220, 84));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-proveedor-48.png"))); // NOI18N
        panelRound3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 50, 48));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-recibo-48.png"))); // NOI18N
        jLabel19.setText("jLabel2");
        panelRound3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 62, 48));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-usuarios-48.png"))); // NOI18N
        jLabel20.setText("jLabel2");
        panelRound3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 62, 48));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-categorizar-48.png"))); // NOI18N
        jLabel21.setText("jLabel2");
        panelRound3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 62, 48));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-clientes-48.png"))); // NOI18N
        jLabel22.setText("jLabel2");
        panelRound3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 62, 48));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-agregar-a-carrito-de-compras-48.png"))); // NOI18N
        jLabel23.setText("jLabel2");
        panelRound3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 62, -1));

        jLabel24.setText("jLabel2");
        panelRound3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 76, 62, 48));

        jLabel25.setText("jLabel2");
        panelRound3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 86, 62, 48));

        panelRound2.setBackground(new java.awt.Color(204, 204, 255));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCatehorias1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCatehorias1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonCatehorias1.setText("Categorias");
        jButtonCatehorias1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCatehorias1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCatehorias1ActionPerformed(evt);
            }
        });
        panelRound2.add(jButtonCatehorias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 394, 220, 84));

        jButtonClientes1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonClientes1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonClientes1.setText("Clientes");
        jButtonClientes1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonClientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientes1ActionPerformed(evt);
            }
        });
        panelRound2.add(jButtonClientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 394, 220, 84));

        jButtonProductos1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonProductos1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonProductos1.setText("Productos");
        jButtonProductos1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProductos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductos1ActionPerformed(evt);
            }
        });
        panelRound2.add(jButtonProductos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 81, 220, 80));

        jButtonProveedores1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonProveedores1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonProveedores1.setText("Proveedores");
        jButtonProveedores1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProveedores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProveedores1ActionPerformed(evt);
            }
        });
        panelRound2.add(jButtonProveedores1, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 81, 220, 80));

        jButtonRealizarVenta1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRealizarVenta1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonRealizarVenta1.setText("Realizar Venta");
        jButtonRealizarVenta1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRealizarVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizarVenta1ActionPerformed(evt);
            }
        });
        panelRound2.add(jButtonRealizarVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 231, 220, 84));

        jButtonUsuarios1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonUsuarios1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonUsuarios1.setText("Usuarios");
        jButtonUsuarios1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonUsuarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuarios1ActionPerformed(evt);
            }
        });
        panelRound2.add(jButtonUsuarios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 231, 220, 84));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-proveedor-48.png"))); // NOI18N
        panelRound2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 50, 48));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-recibo-48.png"))); // NOI18N
        jLabel11.setText("jLabel2");
        panelRound2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 62, 48));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-usuarios-48.png"))); // NOI18N
        jLabel12.setText("jLabel2");
        panelRound2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 62, 48));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-categorizar-48.png"))); // NOI18N
        jLabel13.setText("jLabel2");
        panelRound2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 62, 48));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-clientes-48.png"))); // NOI18N
        jLabel14.setText("jLabel2");
        panelRound2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 62, 48));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-agregar-a-carrito-de-compras-48.png"))); // NOI18N
        jLabel15.setText("jLabel2");
        panelRound2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 62, -1));

        jLabel16.setText("jLabel2");
        panelRound2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 76, 62, 48));

        jLabel17.setText("jLabel2");
        panelRound2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 86, 62, 48));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administración");
        setResizable(false);

        pnlPrincipal.setBackground(new java.awt.Color(239, 237, 237));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(1000, 750));
        pnlPrincipal.setLayout(null);

        jLabelTitulo.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(102, 102, 102));
        pnlPrincipal.add(jLabelTitulo);
        jLabelTitulo.setBounds(50, 20, 920, 60);

        panelRound5.setBackground(new java.awt.Color(70, 4, 129));
        panelRound5.setRoundBottomLeft(70);
        panelRound5.setRoundBottomRight(70);
        panelRound5.setRoundTopLeft(70);
        panelRound5.setRoundTopRight(70);
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(204, 204, 255));
        panelRound1.setRoundBottomLeft(90);
        panelRound1.setRoundBottomRight(90);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCatehorias.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCatehorias.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonCatehorias.setText("Categorias");
        jButtonCatehorias.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCatehorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCatehoriasActionPerformed(evt);
            }
        });
        panelRound1.add(jButtonCatehorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 220, 84));

        jButtonClientes.setBackground(new java.awt.Color(255, 255, 255));
        jButtonClientes.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonClientes.setText("Clientes");
        jButtonClientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });
        panelRound1.add(jButtonClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 220, 84));

        jButtonProductos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonProductos.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonProductos.setText("Productos");
        jButtonProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductosActionPerformed(evt);
            }
        });
        panelRound1.add(jButtonProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 220, 80));

        jButtonProveedores.setBackground(new java.awt.Color(255, 255, 255));
        jButtonProveedores.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonProveedores.setText("Proveedores");
        jButtonProveedores.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProveedoresActionPerformed(evt);
            }
        });
        panelRound1.add(jButtonProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 220, 80));

        jButtonRealizarVenta.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRealizarVenta.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonRealizarVenta.setText("Realizar Venta");
        jButtonRealizarVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizarVentaActionPerformed(evt);
            }
        });
        panelRound1.add(jButtonRealizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 220, 84));

        jButtonUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jButtonUsuarios.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonUsuarios.setText("Usuarios");
        jButtonUsuarios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });
        panelRound1.add(jButtonUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 220, 84));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-proveedor-48.png"))); // NOI18N
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 50, 48));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-recibo-48.png"))); // NOI18N
        jLabel3.setText("jLabel2");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 62, 48));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-usuarios-48.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 62, 48));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-categorizar-48.png"))); // NOI18N
        jLabel5.setText("jLabel2");
        panelRound1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 62, 48));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-clientes-48.png"))); // NOI18N
        jLabel6.setText("jLabel2");
        panelRound1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 62, 48));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-agregar-a-carrito-de-compras-48.png"))); // NOI18N
        jLabel7.setText("jLabel2");
        panelRound1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 62, -1));

        jLabel8.setText("jLabel2");
        panelRound1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 76, 62, 48));

        jLabel9.setText("jLabel2");
        panelRound1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 86, 62, 48));

        panelRound5.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 700, 580));

        pnlPrincipal.add(panelRound5);
        panelRound5.setBounds(130, 120, 700, 620);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sinfondochica.png"))); // NOI18N
        pnlPrincipal.add(jLabel1);
        jLabel1.setBounds(850, -50, 240, 250);

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

        MenuAdminMermas.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminMermas.setText("Mermas");
        MenuAdminMermas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminMermasActionPerformed(evt);
            }
        });
        MenuAdmin.add(MenuAdminMermas);

        jMenuBar1.add(MenuAdmin);

        MenuTecnico.setText("Tecnico");
        MenuTecnico.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        MenuAdminCategoriaTecnico.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminCategoriaTecnico.setText("Categorias");
        MenuAdminCategoriaTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminCategoriaTecnicoActionPerformed(evt);
            }
        });
        MenuTecnico.add(MenuAdminCategoriaTecnico);

        MenuAdminClientesTecnico.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminClientesTecnico.setText("Clientes");
        MenuAdminClientesTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminClientesTecnicoActionPerformed(evt);
            }
        });
        MenuTecnico.add(MenuAdminClientesTecnico);

        MenuAdminProductosTecnico.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminProductosTecnico.setText("Productos");
        MenuAdminProductosTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminProductosTecnicoActionPerformed(evt);
            }
        });
        MenuTecnico.add(MenuAdminProductosTecnico);

        MenuAdminProveedoresTecnico.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminProveedoresTecnico.setText("Proveedores");
        MenuAdminProveedoresTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminProveedoresTecnicoActionPerformed(evt);
            }
        });
        MenuTecnico.add(MenuAdminProveedoresTecnico);

        jMenuBar1.add(MenuTecnico);

        MenuVendedor.setText("Vendedor");
        MenuVendedor.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N

        MenuAdminCategoriaVendedor.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminCategoriaVendedor.setText("Categorias");
        MenuAdminCategoriaVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminCategoriaVendedorActionPerformed(evt);
            }
        });
        MenuVendedor.add(MenuAdminCategoriaVendedor);

        MenuAdminClientesVendedor.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminClientesVendedor.setText("Clientes");
        MenuAdminClientesVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminClientesVendedorActionPerformed(evt);
            }
        });
        MenuVendedor.add(MenuAdminClientesVendedor);

        MenuAdminProductosVendedor.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminProductosVendedor.setText("Productos");
        MenuAdminProductosVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminProductosVendedorActionPerformed(evt);
            }
        });
        MenuVendedor.add(MenuAdminProductosVendedor);

        MenuAdminProveedoresVendedor.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        MenuAdminProveedoresVendedor.setText("Proveedores");
        MenuAdminProveedoresVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminProveedoresVendedorActionPerformed(evt);
            }
        });
        MenuVendedor.add(MenuAdminProveedoresVendedor);

        jMenuBar1.add(MenuVendedor);

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
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiUsuarioForm.getInstance().setVisible(true);
            }
        });
    }//GEN-LAST:event_MenuAdminUsuarioActionPerformed

    private void MenuAdminCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminCategoriaActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiCategoria.getInstance().setVisible(true);
            }
        });
    }//GEN-LAST:event_MenuAdminCategoriaActionPerformed

    private void MenuAdminClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminClientesActionPerformed
        this.setVisible(false);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiClienteForm.getInstance().setVisible(true);
                
            }
        });
    }//GEN-LAST:event_MenuAdminClientesActionPerformed

    private void MenuAdminProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminProductosActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiProductoForm.getInstance().llenarCategorias();
                AdmiProductoForm.getInstance().setVisible(true);
            }
        });
    }//GEN-LAST:event_MenuAdminProductosActionPerformed

    private void MenuAdminProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminProveedoresActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                AdmiProveedorForm.getInstance().setVisible(true);
            }
        });

    }//GEN-LAST:event_MenuAdminProveedoresActionPerformed

    private void menuCajaNuevoTicket1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCajaNuevoTicket1ActionPerformed

        //Aqui habra una validacion con el fin de que validamos el usario actual, el metodo de consultar caja abierta
        //verifica si el usuario corresponde a la sesion
        Caja caja = fachadaControl.consultarCajaAbierta();
        if (caja != null) {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    VentasForm.getInstance().llenarCBoxClientes();
                    VentasForm.getInstance().setVisible(true);
                    VentasForm.getInstance().establecerCaja(caja);
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "No se ha registrado alguna caja se requiere que abra alguna");
        }
    }//GEN-LAST:event_menuCajaNuevoTicket1ActionPerformed

    private void menuCajaAbrirCaja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCajaAbrirCaja1ActionPerformed
        //Aqui habra una validacion con el fin de que validamos el usario actual, el metodo de consultar caja abierta
        //verifica si el usuario corresponde a la sesions
        Caja caja = fachadaControl.consultarCajaAbierta();
        if (caja != null) {
            JOptionPane.showMessageDialog(null, "No se ha cerrado la caja actual, requiere cerrarla");
        } else {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    AbrirCajaForm.instanciaAbrirCaja().setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_menuCajaAbrirCaja1ActionPerformed

    private void menuCajaCierreCaja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCajaCierreCaja1ActionPerformed
      Caja caja = fachadaControl.consultarCajaAbierta();
      if(caja==null){
          JOptionPane.showMessageDialog(this, "No hay caja abierta");
          
      }else{
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    CerrarCajaForm.instanciaCerrarCaja().mostrarFormulario();
                }
            });
      }
        
    }//GEN-LAST:event_menuCajaCierreCaja1ActionPerformed

    private void jButtonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductosActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiProductoForm.getInstance().llenarCategorias();
                AdmiProductoForm.getInstance().setVisible(true);
            }
        });

    }//GEN-LAST:event_jButtonProductosActionPerformed

    private void jButtonRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizarVentaActionPerformed

        //Aqui habra una validacion con el fin de que validamos el usario actual, el metodo de consultar caja abierta
        //verifica si el usuario corresponde a la sesion
        Caja caja = fachadaControl.consultarCajaAbierta();
        if (caja != null) {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    VentasForm.getInstance().llenarCBoxClientes();
                    VentasForm.getInstance().setVisible(true);
                    VentasForm.getInstance().establecerCaja(caja);
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "No se ha registrado alguna caja se requiere que abra alguna");
        }
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

    private void MenuAdminCategoriaTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminCategoriaTecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAdminCategoriaTecnicoActionPerformed

    private void MenuAdminClientesTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminClientesTecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAdminClientesTecnicoActionPerformed

    private void MenuAdminProductosTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminProductosTecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAdminProductosTecnicoActionPerformed

    private void MenuAdminProveedoresTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminProveedoresTecnicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAdminProveedoresTecnicoActionPerformed

    private void MenuAdminCategoriaVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminCategoriaVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAdminCategoriaVendedorActionPerformed

    private void MenuAdminClientesVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminClientesVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAdminClientesVendedorActionPerformed

    private void MenuAdminProductosVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminProductosVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAdminProductosVendedorActionPerformed

    private void MenuAdminProveedoresVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminProveedoresVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAdminProveedoresVendedorActionPerformed

    private void MenuAdminMermasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminMermasActionPerformed
        // TODO add your handling code here:
        
           this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdminMermas.getInstance().setVisible(true);
                    AdminMermas.getInstance().establecerSesion(usuarioSesion);
            }
        });
        
    }//GEN-LAST:event_MenuAdminMermasActionPerformed

    private void jButtonCatehorias1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCatehorias1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCatehorias1ActionPerformed

    private void jButtonClientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClientes1ActionPerformed

    private void jButtonProductos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonProductos1ActionPerformed

    private void jButtonProveedores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProveedores1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonProveedores1ActionPerformed

    private void jButtonRealizarVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizarVenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRealizarVenta1ActionPerformed

    private void jButtonUsuarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuarios1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUsuarios1ActionPerformed

    private void jButtonCatehorias2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCatehorias2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCatehorias2ActionPerformed

    private void jButtonClientes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClientes2ActionPerformed

    private void jButtonProductos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductos2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonProductos2ActionPerformed

    private void jButtonProveedores2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProveedores2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonProveedores2ActionPerformed

    private void jButtonRealizarVenta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizarVenta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRealizarVenta2ActionPerformed

    private void jButtonUsuarios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuarios2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUsuarios2ActionPerformed

    private void jButtonCatehorias3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCatehorias3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCatehorias3ActionPerformed

    private void jButtonClientes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClientes3ActionPerformed

    private void jButtonProductos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductos3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonProductos3ActionPerformed

    private void jButtonProveedores3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProveedores3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonProveedores3ActionPerformed

    private void jButtonRealizarVenta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizarVenta3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRealizarVenta3ActionPerformed

    private void jButtonUsuarios3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuarios3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUsuarios3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAdmin;
    private javax.swing.JMenuItem MenuAdminCategoria;
    private javax.swing.JMenuItem MenuAdminCategoriaTecnico;
    private javax.swing.JMenuItem MenuAdminCategoriaVendedor;
    private javax.swing.JMenuItem MenuAdminClientes;
    private javax.swing.JMenuItem MenuAdminClientesTecnico;
    private javax.swing.JMenuItem MenuAdminClientesVendedor;
    private javax.swing.JMenuItem MenuAdminMermas;
    private javax.swing.JMenuItem MenuAdminProductos;
    private javax.swing.JMenuItem MenuAdminProductosTecnico;
    private javax.swing.JMenuItem MenuAdminProductosVendedor;
    private javax.swing.JMenuItem MenuAdminProveedores;
    private javax.swing.JMenuItem MenuAdminProveedoresTecnico;
    private javax.swing.JMenuItem MenuAdminProveedoresVendedor;
    private javax.swing.JMenuItem MenuAdminUsuario;
    private javax.swing.JMenu MenuCaja1;
    private javax.swing.JMenu MenuTecnico;
    private javax.swing.JMenu MenuVendedor;
    private javax.swing.JButton jButtonCatehorias;
    private javax.swing.JButton jButtonCatehorias1;
    private javax.swing.JButton jButtonCatehorias2;
    private javax.swing.JButton jButtonCatehorias3;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonClientes1;
    private javax.swing.JButton jButtonClientes2;
    private javax.swing.JButton jButtonClientes3;
    private javax.swing.JButton jButtonProductos;
    private javax.swing.JButton jButtonProductos1;
    private javax.swing.JButton jButtonProductos2;
    private javax.swing.JButton jButtonProductos3;
    private javax.swing.JButton jButtonProveedores;
    private javax.swing.JButton jButtonProveedores1;
    private javax.swing.JButton jButtonProveedores2;
    private javax.swing.JButton jButtonProveedores3;
    private javax.swing.JButton jButtonRealizarVenta;
    private javax.swing.JButton jButtonRealizarVenta1;
    private javax.swing.JButton jButtonRealizarVenta2;
    private javax.swing.JButton jButtonRealizarVenta3;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JButton jButtonUsuarios1;
    private javax.swing.JButton jButtonUsuarios2;
    private javax.swing.JButton jButtonUsuarios3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCajaAbrirCaja1;
    private javax.swing.JMenuItem menuCajaCierreCaja1;
    private javax.swing.JMenuItem menuCajaNuevoTicket1;
    private GUIs.PanelRound panelRound1;
    private GUIs.PanelRound panelRound2;
    private GUIs.PanelRound panelRound3;
    private GUIs.PanelRound panelRound4;
    private GUIs.PanelRound panelRound5;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
