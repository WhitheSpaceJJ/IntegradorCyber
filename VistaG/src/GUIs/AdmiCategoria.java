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

public class AdmiCategoria extends javax.swing.JFrame {

    // Numero de columna - 1 , dónde se encontrarán los botones
    private final int COLEDITAR = 2;
    private final int COLELIMINAR = 3;

  
    
    private IFachadaControl logica;

    // Especifica un ID de producto que se está editando.
    private int idCategoria;
    private static AdmiCategoria admiCategoria;

    public AdmiCategoria() {
        initComponents();
        // Limita los caracteres de los text fields y deshabilita el poder mover la tabla.
        tblCategorias.getTableHeader().setReorderingAllowed(false);
        txtNombre.setDocument(new JTextFieldLimit(50));
        logica = new FachadaControl();

        llenarTabla();
        initBotonesTabla();

    }

    public static AdmiCategoria getInstance() {
        if (admiCategoria == null) {
            admiCategoria = new AdmiCategoria();
        }
        return admiCategoria;
    }

    private void initBotonesTabla() {
        ActionListener onEditarClickListener = (ActionEvent e) -> {
            idCategoria = (int) tblCategorias.getValueAt(tblCategorias.getSelectedRow(), 0);
            llenarFormulario(logica.consultarCategoria(idCategoria));

        };

        ActionListener onEliminarListener = (ActionEvent e) -> {
            idCategoria = (int) tblCategorias.getValueAt(tblCategorias.getSelectedRow(), 0);
            eliminar(idCategoria);
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
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEliminarListener));
    }

    private void llenarFormulario(Categoria categoria) {
        txtNombre.setText(categoria.getNombre());
    }

    private void eliminar(int idElimninar) {

        //Establece que por defecto que se seleccionó la opción "NO".
        int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar la categoria seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == JOptionPane.YES_OPTION) {
            boolean seElimino = logica.eliminarCategoria(idElimninar);
            if (seElimino) {
                JOptionPane.showMessageDialog(null, "Se eliminó la categoria", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.llenarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar la categoria", "Información", JOptionPane.ERROR_MESSAGE);
            }
            limpiarId();
        }
    }

    private void limpiarId() {
        idCategoria = 0;
    }

    private boolean validarCamposLlenos() {

        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el nombre de la categoria");
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
        setTitle("Administracion Categoria");
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
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limpiarFormulario();
    }//GEN-LAST:event_btnCancelarActionPerformed


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

        String nombre = this.txtNombre.getText();

        Categoria categoria = new Categoria(nombre);

        boolean seAgregoProdcuto = logica.agregarCategoria(categoria);

        if (seAgregoProdcuto) {
            JOptionPane.showMessageDialog(this, "Se agregó la nueva categoria", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible agregar la categoria", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizar() {

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

    //Bien
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

    private void limpiarFormulario() {
        txtNombre.setText("");
        limpiarId();
        txtNombre.setEditable(true);
    }

}
