package GUIs;

import interfaces.*;
import entidades.*;
import fachada.FachadaControl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giovanni Garrido
 */
public class BusquedaArticuloForm extends javax.swing.JFrame {

    private Producto productoSelect = new Producto();
    
    private List<Producto> productosCoinicidentes = new ArrayList<>();
    private IFachadaControl logica = new FachadaControl();
    private VentasForm ventasFrm = null;

    /**
     * Creates new form AdmiClienteForm
     */
    public BusquedaArticuloForm(VentasForm frmVentas) {
        initComponents();
        vaciarCampos();
        instanciaVentasForm(frmVentas);
        llenarCBoxCategorias();
    }

    /**
     *
     * Modelo para el combobox de categorias
     */
    public void llenarCBoxCategorias() {
        //listaClientes = new DefaultComboBoxModel();
        List<Categoria> categorias = new ArrayList<Categoria>();
        categorias = logica.consultarTodasCategorias();
        Object[] objetos = categorias.toArray();
        categoriasC.setModel(new DefaultComboBoxModel(objetos));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 258, 140, -1));

        btnBuscar.setBackground(new java.awt.Color(0, 0, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 172, 140, -1));

        categoriasC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        categoriasC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------" }));
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
        // TODO add your handling code here
        productosCoinicidentes.clear();
        if(txtArticulo.getText().equals("")){
            buscarCoincidenciasCategoria();
        }else{
            buscarCoincidenciasNombre(txtArticulo.getText());
        }
        vaciarCampos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        try {
            DefaultTableModel model = (DefaultTableModel) tblProductos.getModel();
            if (tblProductos.getSelectedRow() != -1) {
                String nombre = model.getValueAt(tblProductos.getSelectedRow(), 0).toString();
                for (int i = 0; i < productosCoinicidentes.size(); i++) {
                    if ((productosCoinicidentes.get(i).getNombre().toUpperCase()).equals(nombre.toUpperCase())) {
                        productoSelect = productosCoinicidentes.get(i);
                    }
                }
                cerrarFormulario();
                vaciarCampos();
                ventasFrm.agregarArtBuscado(productoSelect);
                ventasFrm.desbloquearCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un artículo", "Busqueda de articulo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     * Metodo para mostrar el formulario
     */
    public void mostrarFormulario() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    /**
     * Metodo para cerrar el formulario
     */
    public void cerrarFormulario() {
        this.dispose();
    }

    /**
     * Metodo que busca las coincidencias dependiendo de lo
     */
    public void buscarCoincidenciasNombre(String busqueda) {
        productosCoinicidentes.clear();
        productosCoinicidentes = logica.buscarProductosPorNombre(busqueda);
        if (!productosCoinicidentes.isEmpty()) {
            for (int i = 0; i < productosCoinicidentes.size(); i++) {
                if(!((productosCoinicidentes.get(i).getCategoria().getNombre().toUpperCase()).equals(categoriasC.getSelectedItem().toString().toUpperCase()))){
                    productosCoinicidentes.remove(i);
                }
            }
            if(!productosCoinicidentes.isEmpty()){
                cargarCoincidencias();
            }
            else{
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Busqueda de articulo", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Busqueda de articulo", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    /**
     * Metodo que busca las coincidencias dependiendo de lo
     */
    public void buscarCoincidenciasCategoria() {
        List <Producto> todosPro = logica.consultarTodosProductos();
        if (!todosPro.isEmpty()) {
            for (int i = 0; i < todosPro.size(); i++) {
                if((todosPro.get(i).getCategoria().getNombre().toUpperCase()).equals(categoriasC.getSelectedItem().toString().toUpperCase())){
                    productosCoinicidentes.add(todosPro.get(i));
                }
            }
            if(!productosCoinicidentes.isEmpty()){
                cargarCoincidencias();
            }
            else{
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Busqueda de articulo", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Busqueda de articulo", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void cargarCoincidencias() {
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

    public void vaciarCampos() {
        txtArticulo.setText("");
        categoriasC.setSelectedIndex(0);
        tblProductos.clearSelection();
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblProductos.getModel();
        tblProductos.setModel(modeloTabla);
    }

    public VentasForm instanciaVentasForm(VentasForm frmVentas) {
        if (ventasFrm == null) {
            ventasFrm = frmVentas;
        }
        return ventasFrm;
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
