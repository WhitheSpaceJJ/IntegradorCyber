
package GUIs;

import GUIs.utils.JButtonCellEditor;
import GUIs.utils.JButtonRenderer;
import GUIs.utils.JTextFieldLimit;
import entidades.Cliente;
import fachada.FachadaControl;
import interfaces.IFachadaControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class AdmiClienteForm extends javax.swing.JFrame {

    private static AdmiClienteForm admiClienteForm;

    private AdmiClienteForm() {
        initComponents();
        this.logica = new FachadaControl();
        llenarTabla();
        initBotonesTabla();
        tbClientes.getTableHeader().setReorderingAllowed(false);
        jTextFieldNombre.setDocument(new JTextFieldLimit(45));
        jTextFieldEmail.setDocument(new JTextFieldLimit(100));
        jTextFieldTelefono.setDocument(new JTextFieldLimit(15));
        jTextFieldRFC.setDocument(new JTextFieldLimit(13));
    }

    public static AdmiClienteForm getInstance() {
        if (admiClienteForm == null) {
            admiClienteForm = new AdmiClienteForm();
        }
        return admiClienteForm;
    }
    private final int COLEDITAR = 5;
    private final int COLELIMINAR = 6;
    private int idCliente;

    private void initBotonesTabla() {
        ActionListener onEditarClickListener = (ActionEvent e) -> {
            idCliente = (int) tbClientes.getValueAt(tbClientes.getSelectedRow(), 0);
            llenarFormulario(logica.consultarCliente(idCliente));

        };

        ActionListener onEliminarListener = (ActionEvent e) -> {
            idCliente = (int) tbClientes.getValueAt(tbClientes.getSelectedRow(), 0);
            eliminar(idCliente);
        };

        int indiceColumnaEditar = COLEDITAR;

        TableColumnModel modeloColumnas = this.tbClientes.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEditarClickListener));

        indiceColumnaEditar = COLELIMINAR;

        modeloColumnas = this.tbClientes.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEliminarListener));
    }

    private void llenarFormulario(Cliente cliente) {
        jTextFieldNombre.setText(cliente.getNombre());
        jTextFieldTelefono.setText(cliente.getTelefono());
        jTextFieldEmail.setText(cliente.getEmail());
        jTextFieldRFC.setText(cliente.getRfc());
    }

    private void eliminar(int idElimninar) {

        int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar el cliente seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == JOptionPane.YES_OPTION) {
            boolean seElimino = logica.eliminarCliente(idElimninar);
            if (seElimino) {
                JOptionPane.showMessageDialog(null, "Se eliminó el cliente", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.llenarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar al cliente", "Información", JOptionPane.ERROR_MESSAGE);
            }
            limpiarId();
        }
    }

    private void limpiarId() {
        idCliente = 0;
    }

    public boolean validarDatos() {

        if (!jTextFieldNombre.getText().matches("^([A-Za-z]+\\s?)+$")) {
            JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras mayúsculas y minúsculas, incluyendo espacios entre nombres");
            return true;
        }

        if (!jTextFieldRFC.getText().matches("[A-Z]{4}\\d{6}[A-Z0-9]{3}")) {
            JOptionPane.showMessageDialog(null, "El RFC tiene un formato invalido");

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
        return false;
    }

    private boolean validarCamposLlenos() {

        if (jTextFieldNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el nombre del cliente");
            return false;
        }
        if (jTextFieldEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el email del cliente");
            return false;
        }
        if (jTextFieldRFC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el RFC del cliente");
            return false;
        }
        if (jTextFieldTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el telefono del cliente");
            return false;
        }
        return true;
    }

    private void guardar() {
        if (validarCamposLlenos()) {
            if (idCliente == 0) {
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
        String rfc = jTextFieldRFC.getText();
        String email = jTextFieldEmail.getText();
        String telefono = jTextFieldTelefono.getText();
        Cliente cliente = new Cliente(idCliente, nombre, rfc, email, telefono);

        boolean seAgrego = logica.agregarCliente(cliente);

        if (seAgrego) {
            JOptionPane.showMessageDialog(this, "Se agregó el nuevo cliente", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible agregar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizar() {
        if (validarDatos()) {
            return;
        }
        String nombre = jTextFieldNombre.getText();
        String rfc = jTextFieldRFC.getText();
        String email = jTextFieldEmail.getText();
        String telefono = jTextFieldTelefono.getText();
        Cliente cliente = new Cliente(idCliente, nombre, rfc, email, telefono);
        boolean seActualizo = logica.actualizarCliente(cliente);
        if (seActualizo) {
            JOptionPane.showMessageDialog(this, "Se actualizó el cliente", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
            limpiarId();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible actualizar el cliente", "Información", JOptionPane.ERROR_MESSAGE);
        }
    }
private       List<Cliente> clientes;
    private void llenarTabla() {
  clientes = this.logica.consultarTodosClientes();
  if(clientes!=null || !clientes.isEmpty()){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tbClientes.getModel();
        this.tbClientes.setRowHeight(30);
        modeloTabla.setRowCount(0);
        clientes.forEach(cliente -> {
            Object[] fila = new Object[5];
            fila[0] = cliente.getId();
            fila[1] = cliente.getNombre();
            fila[2] = cliente.getRfc();
            fila[3] = cliente.getEmail();
            fila[4] = cliente.getTelefono();
            modeloTabla.addRow(fila);
        });
  }
      
    }
    private final IFachadaControl logica;

    private void limpiarFormulario() {
        jTextFieldNombre.setText("");
        jTextFieldEmail.setText("");
        jTextFieldTelefono.setText("");
        jTextFieldRFC.setText("");
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
        jTextFieldRFC = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblRectangulo4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administracion Clientes");
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
        jLabel1.setText("CLIENTES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1110, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("REGISTROS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 114, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("REGISTRAR");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 114, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("RFC");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Email");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Telefono");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jTextFieldNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 300, -1));

        jTextFieldRFC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 300, -1));

        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 300, -1));

        jTextFieldTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 300, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setToolTipText("");
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 82, 10, 540));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(null);

        tbClientes.setBackground(new java.awt.Color(204, 204, 255));
        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "RFC", "Email", "Teléfono", "Editar", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 655, 440));

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 153, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 140, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), java.awt.Color.white, null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 140, -1));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        jPanel1.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 420, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.limpiarFormulario();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldRFC;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JLabel lblRectangulo4;
    private javax.swing.JTable tbClientes;
    // End of variables declaration//GEN-END:variables
}
