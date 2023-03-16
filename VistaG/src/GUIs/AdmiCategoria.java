package GUIs;

import GUIs.utils.JButtonCellEditor;
import GUIs.utils.JButtonRenderer;
import GUIs.utils.JTextFieldLimit;
import entidades.Categoria;
import fachada.FachadaControl;
import fachada.FachadaDAO;
import interfaces.IFachadaControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Giovanni Garrido
 */
public class AdmiCategoria extends javax.swing.JFrame {

    /**
     * Creates new form AdmiClienteForm
     */
    // Numero de columna - 1 , dónde se encontrarán los botones
    private final int COLEDITAR = 2;
    private final int COLELIMINAR = 3;

    //FachadaDAO fachada;
    IFachadaControl logica;

    // Especifica un ID de producto que se está editando.
    private int idCategoria;

    public AdmiCategoria() {
        initComponents();
        //fachada = new FachadaDAO();
        logica = new FachadaControl();
        llenarTabla();
        initBotonesTabla();

        // Limita los caracteres de los text fields y deshabilita el poder mover la tabla.
        tblCategorias.getTableHeader().setReorderingAllowed(false);
        txtNombre.setDocument(new JTextFieldLimit(50));

    }

    private void initBotonesTabla() {
        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                idCategoria = (int) tblCategorias.getValueAt(tblCategorias.getSelectedRow(), 0);

                int indexColumna = tblCategorias.getSelectedColumn();

                if (indexColumna == COLEDITAR) {
                    llenarFormulario(logica.consultarCategoria(idCategoria));
                    //Evita que se modifique el nombre del producto al editarse.
                    //txtNombre.setEditable(false);
                } else {
                    eliminar();
                }
            }
        };

        int indiceColumnaEditar = COLEDITAR;

        TableColumnModel modeloColumnas = this.tblCategorias.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEditarClickListener));

        indiceColumnaEditar = COLELIMINAR;

        modeloColumnas = this.tblCategorias.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEditarClickListener));
    }

    private void llenarTabla() {

        List<Categoria> categorias = this.logica.consultarTodasCategorias();

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCategorias.getModel();

        modeloTabla.setRowCount(0);

        categorias.forEach(categoria -> {
            Object[] fila = new Object[4];
            fila[0] = categoria.getId();
            fila[1] = categoria.getNombre();
            fila[2] = "Editar";
            fila[3] = "Eliminar";
            modeloTabla.addRow(fila);
        });

    }

    private void llenarFormulario(Categoria categoria) {
        txtNombre.setText(categoria.getNombre());
    }

    private void eliminar() {

        //Establece que por defecto que se seleccionó la opción "NO".
        int opcionSeleccionada = -1;

        opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar la categoria seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada != JOptionPane.YES_OPTION) {
            return;
        }

        opcionSeleccionada = JOptionPane.showConfirmDialog(this, "Eliminar esta categoria eliminará también los productos en las que se encuentre\n ¿Está seguro que desea eliminar la categoria?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada != JOptionPane.YES_OPTION) {
            return;
        }

        boolean seElimino = logica.eliminarCategoria(idCategoria);

        if (seElimino) {
            JOptionPane.showMessageDialog(this, "Se eliminó la categoria", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.llenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible eliminar la categoria", "Información", JOptionPane.ERROR_MESSAGE);
        }

        limpiarId();
    }

    private void limpiarId() {
        idCategoria = 0;
    }

    private boolean validarCamposLlenos() {

        if (txtNombre.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCategorias = new javax.swing.JPanel();
        lblCategorias = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblRegistros = new javax.swing.JLabel();
        lblRegistrar = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        splnRegistros = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlCategorias.setPreferredSize(new java.awt.Dimension(1100, 650));

        lblCategorias.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblCategorias.setText("Categorias");

        lblRegistros.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRegistros.setText("REGISTROS");

        lblRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRegistrar.setText("REGISTRAR");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Editar", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        splnRegistros.setViewportView(tblCategorias);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout pnlCategoriasLayout = new javax.swing.GroupLayout(pnlCategorias);
        pnlCategorias.setLayout(pnlCategoriasLayout);
        pnlCategoriasLayout.setHorizontalGroup(
            pnlCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoriasLayout.createSequentialGroup()
                .addGroup(pnlCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCategoriasLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(lblRegistrar))
                    .addGroup(pnlCategoriasLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblNombre)
                        .addGap(30, 30, 30)
                        .addGroup(pnlCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCategoriasLayout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(pnlCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCategoriasLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lblCategorias)
                        .addContainerGap())
                    .addGroup(pnlCategoriasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCategoriasLayout.createSequentialGroup()
                                .addComponent(lblRegistros)
                                .addContainerGap())
                            .addComponent(splnRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)))))
            .addComponent(jSeparator1)
        );
        pnlCategoriasLayout.setVerticalGroup(
            pnlCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoriasLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblCategorias)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCategoriasLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(pnlCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRegistrar)
                            .addComponent(lblRegistros))
                        .addGroup(pnlCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCategoriasLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(pnlCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(97, 97, 97)
                                .addGroup(pnlCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCancelar)
                                    .addComponent(btnGuardar)))
                            .addGroup(pnlCategoriasLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(splnRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCategoriasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AdmiCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdmiCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdmiCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdmiCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new AdmiCategoria().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCategorias;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JPanel pnlCategorias;
    private javax.swing.JScrollPane splnRegistros;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void guardar() {
        if (validarCamposLlenos()) {

            if (idCategoria == 0) {
                agregar();
            } else {
                actualizar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregar() {
//        if(validarFormulario() == false){
//            return;
//        }

        String nombre = this.txtNombre.getText();

        Categoria categoria = new Categoria(nombre);

        boolean seAgregoProdcuto = logica.agregarCategoria(categoria);

        if (seAgregoProdcuto) {
            JOptionPane.showMessageDialog(this, "Se agregó la nueva categoria", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible agregar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizar() {
//        if(validarFormulario() == false){
//            return;
//        }

        String nombre = txtNombre.getText();

        Categoria categoria = new Categoria(idCategoria, nombre);

        boolean seActualizo = logica.actualizarCategoria(categoria);

        if (seActualizo) {
            JOptionPane.showMessageDialog(this, "Se actualizó la categoria", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
            limpiarId();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible actualizar la categoria", "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        limpiarId();
        txtNombre.setEditable(true);
    }

}
