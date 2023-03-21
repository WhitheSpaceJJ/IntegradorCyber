package GUIs;

import GUIs.utils.JButtonCellEditor;
import GUIs.utils.JButtonRenderer;
import GUIs.utils.JTextFieldLimit;
import entidades.Categoria;
import fachada.FachadaControl;
import interfaces.IFachadaControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class AdmiCategoria extends javax.swing.JFrame {

    private final int COLEDITAR = 2;
    private final int COLELIMINAR = 3;

    private final IFachadaControl logica;

    private int idCategoria;
    private static AdmiCategoria admiCategoria;

    private AdmiCategoria() {
        initComponents();
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
    private List<Categoria> categorias;

    //Bien
    private void llenarTabla() {
        categorias = this.logica.consultarTodasCategorias();
        if(categorias!=null || !categorias.isEmpty()){
              DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCategorias.getModel();
        this.tblCategorias.setRowHeight(30);
        modeloTabla.setRowCount(0);
        categorias.forEach(categoria -> {
            Object[] fila = new Object[2];
            fila[0] = categoria.getId();
            fila[1] = categoria.getNombre();
            modeloTabla.addRow(fila);
        });
        }
      
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        limpiarId();
        txtNombre.setEditable(true);
    }

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
        lblRectangulo4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administracion Categoria");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlCategorias.setBackground(new java.awt.Color(255, 255, 255));
        pnlCategorias.setPreferredSize(new java.awt.Dimension(1100, 650));
        pnlCategorias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCategorias.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblCategorias.setText("Categorias");
        pnlCategorias.add(lblCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));
        pnlCategorias.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1000, 10));

        lblRegistros.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRegistros.setText("REGISTROS");
        pnlCategorias.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, -1, -1));

        lblRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRegistrar.setText("REGISTRAR");
        pnlCategorias.add(lblRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 114, -1, -1));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setText("Nombre");
        pnlCategorias.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlCategorias.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 300, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnlCategorias.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 10, 424));

        splnRegistros.setBackground(new java.awt.Color(204, 204, 255));
        splnRegistros.setBorder(null);

        tblCategorias.setBackground(new java.awt.Color(204, 204, 255));
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

        pnlCategorias.add(splnRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 561, 279));

        btnGuardar.setBackground(new java.awt.Color(0, 0, 255));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), java.awt.Color.white, java.awt.Color.white));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlCategorias.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 132, -1));

        btnCancelar.setBackground(new java.awt.Color(0, 0, 255));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), java.awt.Color.white, java.awt.Color.white));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlCategorias.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        pnlCategorias.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 420, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        dispose();
        PrincipalForm.getInstance().setVisible(true);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCategorias;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRectangulo4;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JPanel pnlCategorias;
    private javax.swing.JScrollPane splnRegistros;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
