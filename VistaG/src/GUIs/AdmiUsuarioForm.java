package GUIs;

import GUIs.utils.JButtonCellEditor;
import GUIs.utils.JButtonRenderer;
import GUIs.utils.JTextFieldLimit;
import entidades.Categoria;
import entidades.Usuario;
import enumeradores.Rol;
import fachada.FachadaControl;
import interfaces.IFachadaControl;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class AdmiUsuarioForm extends javax.swing.JFrame {

    // Numero de columna - 1 , dónde se encontrarán los botones
    private final int COLEDITAR = 4;
    private final int COLELIMINAR = 5;

    IFachadaControl logica;

    // Especifica un ID de usuario que se está editando.
    private int idUsuario;

    /**
     * Creates new form AdmiClienteForm
     */
    public AdmiUsuarioForm() {
        initComponents();
        logica = new FachadaControl();
        llenarTabla();
        llenarComboRoles();
        initBotonesTabla();

        // Limita los caracteres de los text fields y deshabilita el poder mover la tabla.
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        txtNombre.setDocument(new JTextFieldLimit(45));
        txtPassword.setDocument(new JTextFieldLimit(20));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spdH = new javax.swing.JPanel();
        lblusuarios = new javax.swing.JLabel();
        spdV = new javax.swing.JSeparator();
        lblRegistros = new javax.swing.JLabel();
        lblRegistrar = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        spnlTablaUsuarios = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbRoles = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        spdH.setPreferredSize(new java.awt.Dimension(1100, 650));

        lblusuarios.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblusuarios.setText("USUARIOS");

        lblRegistros.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRegistros.setText("REGISTROS");

        lblRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRegistrar.setText("REGISTRAR");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("ROL");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Password", "Rol", "Editar", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spnlTablaUsuarios.setViewportView(tblUsuarios);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cmbRoles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRolesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout spdHLayout = new javax.swing.GroupLayout(spdH);
        spdH.setLayout(spdHLayout);
        spdHLayout.setHorizontalGroup(
            spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spdHLayout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(lblusuarios)
                .addGap(0, 450, Short.MAX_VALUE))
            .addGroup(spdHLayout.createSequentialGroup()
                .addGroup(spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spdHLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(lblRegistrar))
                    .addGroup(spdHLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(lblNombre))
                        .addGap(30, 30, 30)
                        .addGroup(spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addGroup(spdHLayout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbRoles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, spdHLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRegistros)
                        .addGap(248, 248, 248))
                    .addGroup(spdHLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spdV)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, spdHLayout.createSequentialGroup()
                                .addComponent(spnlTablaUsuarios)
                                .addContainerGap())))))
        );
        spdHLayout.setVerticalGroup(
            spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spdHLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblusuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spdV, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistrar)
                    .addComponent(lblRegistros))
                .addGroup(spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spdHLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addGroup(spdHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnGuardar)))
                    .addGroup(spdHLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(spnlTablaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, spdHLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spdH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spdH, 627, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRolesActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limpiarFormulario();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbRoles;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblusuarios;
    private javax.swing.JPanel spdH;
    private javax.swing.JSeparator spdV;
    private javax.swing.JScrollPane spnlTablaUsuarios;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables

    private void llenarComboRoles() {
        cmbRoles.addItem("");
        for (Rol rol : Rol.values()) {
            cmbRoles.addItem(rol.toString());
        }

    }

    private void llenarTabla() {
        List<Usuario> usuarios = this.logica.consultarTodosUsuarios();

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblUsuarios.getModel();

        modeloTabla.setRowCount(0);

        usuarios.forEach(usuario -> {
            Object[] fila = new Object[6];
            fila[0] = usuario.getId();
            fila[1] = usuario.getNombre();
            fila[2] = usuario.getPassword();
            fila[3] = usuario.getRol();
            fila[4] = "Editar";
            fila[5] = "Eliminar";
            modeloTabla.addRow(fila);
        });
    }

    private void limpiarId() {
        idUsuario = 0;
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtPassword.setText("");
        cmbRoles.setSelectedIndex(0);
        limpiarId();
        txtNombre.setEditable(true);
    }

    private void initBotonesTabla() {
        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                idUsuario = (int) tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0);

                int indexColumna = tblUsuarios.getSelectedColumn();

                if (indexColumna == COLEDITAR) {
                    llenarFormulario(logica.consultarUsuario(idUsuario));
                    //Evita que se modifique el nombre del usuario al editarse.
                    txtNombre.setEditable(false);
                } else {
                    eliminar();
                }
            }
        };

        int indiceColumnaEditar = COLEDITAR;

        TableColumnModel modeloColumnas = this.tblUsuarios.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEditarClickListener));

        indiceColumnaEditar = COLELIMINAR;

        modeloColumnas = this.tblUsuarios.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEditarClickListener));
    }

    private void llenarFormulario(Usuario usuario) {
        txtNombre.setText(usuario.getNombre());
        txtPassword.setText(usuario.getPassword());
        cmbRoles.setSelectedItem(usuario.getRol().toString());
    }

    //TODO implementar metodo para proteger datos relacionados MUY IMPORTANTE
    private void eliminar() {

        //Establece que por defecto que se seleccionó la opción "NO".
        int opcionSeleccionada = -1;

        opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar al usuario seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada != JOptionPane.YES_OPTION) {
            return;
        }

        opcionSeleccionada = JOptionPane.showConfirmDialog(this, "Eliminar esta usuario eliminará también las ventas en las que se encuentre\n ¿Está seguro que desea eliminar la categoria?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada != JOptionPane.YES_OPTION) {
            return;
        }

        boolean seElimino = logica.eliminarUsuario(idUsuario);

        if (seElimino) {
            JOptionPane.showMessageDialog(this, "Se eliminó al usuario", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.llenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible eliminar al usuario", "Información", JOptionPane.ERROR_MESSAGE);
        }

        limpiarId();
    }

    private void guardar() {
        if (validarCamposLlenos()) {

            if (idUsuario == 0) {
                agregar();
            } else {
                actualizar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarCamposLlenos() {

        if (txtNombre.getText().isEmpty()) {
            return false;
        }

        if (txtPassword.getText().isEmpty()) {
            return false;
        }
        if (cmbRoles.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    private void agregar() {
        if (validarFormulario() == false) {
            return;
        }

        String nombre = this.txtNombre.getText();
        String password = this.txtPassword.getText();
        Rol rol = Rol.valueOf(cmbRoles.getSelectedItem().toString());
   
        Usuario usuario = new Usuario(nombre, password,rol);

        boolean seAgregoProdcuto = logica.agregarUsuario(usuario);

        if (seAgregoProdcuto) {
            JOptionPane.showMessageDialog(this, "Se agregó el nuevo usuario", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible agregar al usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarFormulario() {
        String mensajeError = "";

        mensajeError = (validarSoloLetras(txtNombre.getText())) ? mensajeError : mensajeError + "El nombre debe contener solo letras\n";
        mensajeError = (txtPassword.getText().length() >= 8) ? mensajeError : mensajeError + "El password debe de ser de mínimo 8 caracteres";
        if (mensajeError == "") {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, mensajeError, "Información", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    private boolean validarSoloLetras(String string) {
        Pattern pattern = Pattern.compile("[\\d\\p{Punct}]");
        Matcher matcher = pattern.matcher(string);

        return !matcher.find();
    }

    private void actualizar() {
        if (validarFormulario() == false) {
            return;
        }

        String nombre = this.txtNombre.getText();
        String password = this.txtPassword.getText();
        Rol rol = Rol.valueOf(cmbRoles.getSelectedItem().toString());

        Usuario usuario = new Usuario(idUsuario, nombre, password, rol);

        boolean seActualizo = logica.actualizarUsuario(usuario);

        if (seActualizo) {
            JOptionPane.showMessageDialog(this, "Se actualizó al usuario", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
            limpiarId();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible actualizar al usuario", "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

}//end class
