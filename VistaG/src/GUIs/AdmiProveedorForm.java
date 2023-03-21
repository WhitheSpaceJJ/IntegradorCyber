package GUIs;

import GUIs.utils.JButtonCellEditor;
import GUIs.utils.JButtonRenderer;
import GUIs.utils.JTextFieldLimit;
import entidades.Proveedor;
import fachada.FachadaControl;
import interfaces.IFachadaControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class AdmiProveedorForm extends javax.swing.JFrame {

    private static AdmiProveedorForm admiProveedorForm;

    private AdmiProveedorForm() {
        initComponents();
        this.logica = new FachadaControl();
        llenarTabla();
        initBotonesTabla();
        jTableProveedores.getTableHeader().setReorderingAllowed(false);
        jTextFieldNombre.setDocument(new JTextFieldLimit(50));
        jTextFieldEmail.setDocument(new JTextFieldLimit(100));
        jTextFieldTelefono.setDocument(new JTextFieldLimit(15));
        jTextFieldDireccion.setDocument(new JTextFieldLimit(100));
        jTextFieldWebSite.setDocument(new JTextFieldLimit(50));
        jTextFieldContacto.setDocument(new JTextFieldLimit(100));
    }

    public static AdmiProveedorForm getInstance() {
        if (admiProveedorForm == null) {
            admiProveedorForm = new AdmiProveedorForm();
        }
        return admiProveedorForm;
    }

    private final int COLEDITAR = 7;
    private final int COLELIMINAR = 8;
    private int idProveedor;

    private void initBotonesTabla() {
        ActionListener onEditarClickListener = (ActionEvent e) -> {
            idProveedor = (int) jTableProveedores.getValueAt(jTableProveedores.getSelectedRow(), 0);
            llenarFormulario(logica.consultarProveedor(idProveedor));

        };

        ActionListener onEliminarListener = (ActionEvent e) -> {
            idProveedor = (int) jTableProveedores.getValueAt(jTableProveedores.getSelectedRow(), 0);
            eliminar(idProveedor);
        };

        int indiceColumnaEditar = COLEDITAR;

        TableColumnModel modeloColumnas = this.jTableProveedores.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEditarClickListener));

        indiceColumnaEditar = COLELIMINAR;

        modeloColumnas = this.jTableProveedores.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEliminarListener));
    }

    private void llenarFormulario(Proveedor proveedor) {
        jTextFieldNombre.setText(proveedor.getNombre());
        jTextFieldTelefono.setText(proveedor.getTelefono());
        jTextFieldEmail.setText(proveedor.getEmail());
        jTextFieldDireccion.setText(proveedor.getDireccion());
        jTextFieldWebSite.setText(proveedor.getWebsite());
        jTextFieldContacto.setText(proveedor.getContacto());
    }

    public boolean validarDatos() {

        if (!jTextFieldNombre.getText().matches("^([A-Za-z]+\\s?)+$")) {
            JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras mayúsculas y minúsculas, incluyendo espacios entre nombres");
            return true;
        }

        if (!jTextFieldEmail.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "El correo tiene un formato invalido");
            return true;
        }
        if (!jTextFieldTelefono.getText().matches("\\d{10}")) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese un numero de 10 digitos, no ingrese caracteres extraños");
            return true;
        }

        if (!jTextFieldWebSite.getText().isEmpty()) {
            if (!jTextFieldWebSite.getText().matches("^(http[s]?:\\/\\/)?[a-zA-Z0-9]+([\\-\\.{1}][a-zA-Z0-9]+)*\\.[a-zA-Z]{2,}([\\/{1}][a-zA-Z0-9]+)*([\\/{1}][a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,})?$")) {
                JOptionPane.showMessageDialog(null, "El web site tiene un formato invalido");
                return true;
            }
        }
        return false;
    }

    private void eliminar(int idElimninar) {

        //Establece que por defecto que se seleccionó la opción "NO".
        int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar el proveedor seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == JOptionPane.YES_OPTION) {
            boolean seElimino = logica.eliminarProveedor(idElimninar);
            if (seElimino) {
                JOptionPane.showMessageDialog(null, "Se eliminó el proveedor", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.llenarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar al proveedor", "Información", JOptionPane.ERROR_MESSAGE);
            }
            limpiarId();
        }
    }

    private void limpiarId() {
        idProveedor = 0;
    }

    private boolean validarCamposLlenos() {

        if (jTextFieldNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el nombre del proveedor");
            return false;
        }
        if (jTextFieldEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el email del proveedor");
            return false;
        }
        if (jTextFieldDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese la direccion del proveedor");
            return false;
        }
        if (jTextFieldTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el telefono del proveedor");
            return false;
        }
        if (jTextFieldContacto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el contacto del proveedor");
            return false;
        }
        return true;
    }

    private void guardar() {
        if (validarCamposLlenos()) {
            if (idProveedor == 0) {
                agregar();
            } else {
                actualizar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregar() {
        if (validarDatos()) {
            return;
        }
        String nombre = jTextFieldNombre.getText();
        String direccion = jTextFieldDireccion.getText();
        String email = jTextFieldEmail.getText();
        String telefono = jTextFieldTelefono.getText();
        String webSite = jTextFieldWebSite.getText();
        String contacto = jTextFieldContacto.getText();
        Proveedor proveedor=new Proveedor(nombre, direccion, telefono, email, webSite, contacto);
        proveedor.setWebsite(webSite);
        boolean seAgrego = logica.agregarProveedor(proveedor);

        if (seAgrego) {
            JOptionPane.showMessageDialog(this, "Se agregó el nuevo proveedor", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible agregar el proveedor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizar() {
        if (validarDatos()) {
            return;
        }
        String nombre = jTextFieldNombre.getText();
        String direccion = jTextFieldDireccion.getText();
        String email = jTextFieldEmail.getText();
        String telefono = jTextFieldTelefono.getText();
        String webSite = jTextFieldWebSite.getText();
        String contacto = jTextFieldContacto.getText();
        Proveedor proveedor=new Proveedor(nombre, direccion, telefono, email, webSite, contacto);
        proveedor.setId(idProveedor);
        proveedor.setWebsite(webSite);
        boolean seActualizo = logica.actualizarProveedor(proveedor);
        if (seActualizo) {
            JOptionPane.showMessageDialog(this, "Se actualizó el proveedor", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
            limpiarId();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible actualizar el proveedor", "Información", JOptionPane.ERROR_MESSAGE);
        }
    }
private  List<Proveedor> proveedores ;
    private void llenarTabla() {
     proveedores = logica.consultarTodosProveedores();
      if(proveedores!=null ){
           DefaultTableModel modeloTabla = (DefaultTableModel) this.jTableProveedores.getModel();
        this.jTableProveedores.setRowHeight(30);
        modeloTabla.setRowCount(0);
        proveedores.forEach(proveedor -> {
            Object[] fila = new Object[7];
            fila[0] = proveedor.getId();
            fila[1] = proveedor.getNombre();
            fila[2] = proveedor.getDireccion();
            fila[3] = proveedor.getTelefono();
            fila[4] = proveedor.getEmail();
            fila[5] = proveedor.getWebsite();
            fila[6] = proveedor.getContacto();
            modeloTabla.addRow(fila);
        });
      } 
    
    }
    private final IFachadaControl logica;

    private void limpiarFormulario() {
        jTextFieldNombre.setText("");
        jTextFieldEmail.setText("");
        jTextFieldTelefono.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldContacto.setText("");
        jTextFieldWebSite.setText("");
        limpiarId();
        jTextFieldNombre.setEditable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProveedores = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldWebSite = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldContacto = new javax.swing.JTextField();
        lblRectangulo4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administración Proveedores");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("PROVEEDORES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1100, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("REGISTROS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("REGISTRAR");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 114, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 186, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Direccion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 248, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Teléfono");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 307, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Email");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jTextFieldNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 183, 300, -1));

        jTextFieldDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 242, 300, -1));

        jTextFieldTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 301, 300, -1));

        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 360, 300, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 10, 540));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(null);

        jTableProveedores.setBackground(new java.awt.Color(204, 204, 255));
        jTableProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Dirección", "Teléfono", "Email", "WebSite", "Contacto", "Editar", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableProveedores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 651, 440));

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(0, 153, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 150, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), java.awt.Color.white, java.awt.Color.white));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 150, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("WebSite");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 425, -1, -1));

        jTextFieldWebSite.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldWebSite, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 419, 300, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Contacto");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 484, -1, -1));

        jTextFieldContacto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 478, 300, -1));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        jPanel1.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 420, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, 627, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.limpiarFormulario();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
           setVisible(false);
        dispose();
        PrincipalForm.getInstance().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableProveedores;
    private javax.swing.JTextField jTextFieldContacto;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField jTextFieldWebSite;
    private javax.swing.JLabel lblRectangulo4;
    // End of variables declaration//GEN-END:variables
}
