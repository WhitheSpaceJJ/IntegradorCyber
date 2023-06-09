package GUIs;

import interfaces.*;
import entidades.*;
import fachada.FachadaControl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BusquedaArticuloForm extends javax.swing.JFrame {

    private List<Producto> productosCoinicidentes;
    private IFachadaControl logica;
    private static BusquedaArticuloForm busquedaArticuloForm;
    private static List<Categoria> categorias;
    private int buscador = 0;

    private BusquedaArticuloForm() {
        initComponents();
        this.logica = new FachadaControl();
        this.productosCoinicidentes = new ArrayList<>();
        vaciarCampos();
        llenarCBoxCategorias();
    }

    public void establecerBuscador(int buscador) {
        this.buscador = buscador;
    }

    public static BusquedaArticuloForm getInstance() {
        if (busquedaArticuloForm == null) {
            busquedaArticuloForm = new BusquedaArticuloForm();
        }
        return busquedaArticuloForm;
    }

    /**
     *
     * Modelo para el combobox de categorias
     */
    public void llenarCBoxCategorias() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("TODAS");
        categorias = logica.consultarTodasCategorias();
        for (int i = 0; i < categorias.size(); i++) {
            Categoria get = categorias.get(i);
            model.addElement(get.getNombre());
        }
        categoriasC.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtArticulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        categoriasC = new javax.swing.JComboBox<>();
        lblRectangulo4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda Articulos");
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
        jLabel1.setText("BUSQUEDA ARTICULO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 27, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Articulo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 177, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Categoria");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        txtArticulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 174, 300, -1));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(null);

        tblProductos.setBackground(new java.awt.Color(204, 204, 255));
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Articulo", "Descripción", "Precio", "Disponible", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 401, 878, 194));

        btnSeleccionar.setBackground(new java.awt.Color(0, 0, 255));
        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/click.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 258, 160, -1));

        btnBuscar.setBackground(new java.awt.Color(0, 0, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 172, 160, -1));

        categoriasC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        categoriasC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------" }));
        categoriasC.setSelectedIndex(-1);
        categoriasC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriasCActionPerformed(evt);
            }
        });
        jPanel1.add(categoriasC, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 256, 300, -1));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        jPanel1.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 900, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void categoriasCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriasCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriasCActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        productosCoinicidentes.clear();
        if (txtArticulo.getText().equals("")) {
            buscarCoincidenciasCategoria();
        } else {
            buscarCoincidenciasNombre(txtArticulo.getText());
        }
        vaciarCampos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int indice = tblProductos.getSelectedRow();
        if (indice != -1) {
            vaciarCampos();
            if (buscador == 0) {
                VentasForm.getInstance().agregarArtBuscado(productosCoinicidentes.get(indice));
                setVisible(false);
                dispose();
                VentasForm.getInstance().setVisible(true);
            } else {
                AdminMermas.getInstance().agregarArtBuscado(productosCoinicidentes.get(indice));
                setVisible(false);
                dispose();
                AdminMermas.getInstance().setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un artículo", "Busqueda de articulo", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        dispose();
        VentasForm.getInstance().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    public void buscarCoincidenciasNombre(String busqueda) {
        productosCoinicidentes.clear();
        List<Producto> todosPro = logica.buscarProductosPorNombre(busqueda);
        if (categoriasC.getSelectedIndex() == 0) {
            productosCoinicidentes = todosPro;
        } else {
            for (int i = 0; i < todosPro.size(); i++) {
                if ((todosPro.get(i).getCategoria().getNombre().toUpperCase()).equals(categoriasC.getSelectedItem().toString().toUpperCase())) {
                    productosCoinicidentes.add(todosPro.get(i));
                }
            }
        }

        if (!productosCoinicidentes.isEmpty()) {
            cargarCoincidencias();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Busqueda de articulo", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void buscarCoincidenciasCategoria() {
        List<Producto> todosPro = logica.consultarTodosProductos();
        if (!todosPro.isEmpty()) {
            if (categoriasC.getSelectedIndex() == 0) {
                productosCoinicidentes = todosPro;
            } else {
                for (int i = 0; i < todosPro.size(); i++) {
                    if ((todosPro.get(i).getCategoria().getNombre().toUpperCase()).equals(categoriasC.getSelectedItem().toString().toUpperCase())) {
                        productosCoinicidentes.add(todosPro.get(i));
                    }
                }
            }

            if (!productosCoinicidentes.isEmpty()) {
                cargarCoincidencias();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Busqueda de articulo", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Busqueda de articulo", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void resetBusquedas() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblProductos.getModel();
        modeloTabla.setRowCount(0);
    }

    public void cargarCoincidencias() {
        if (productosCoinicidentes != null) {
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblProductos.getModel();
            modeloTabla.setRowCount(0);
            productosCoinicidentes.forEach(producto -> {
                Object[] fila = new Object[5];
                fila[0] = producto.getNombre();
                fila[1] = producto.getDescripcion();
                fila[2] = producto.getPrecio();
                fila[3] = producto.getStock();
                fila[4] = producto.getCategoria().getNombre();
                modeloTabla.addRow(fila);
            });
        }

    }

    public void vaciarCampos() {
        txtArticulo.setText("");
        categoriasC.setSelectedIndex(0);
        tblProductos.clearSelection();
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblProductos.getModel();
        tblProductos.setModel(modeloTabla);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> categoriasC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRectangulo4;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtArticulo;
    // End of variables declaration//GEN-END:variables
}
