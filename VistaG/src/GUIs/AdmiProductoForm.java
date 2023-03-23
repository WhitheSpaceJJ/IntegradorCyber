package GUIs;

import GUIs.utils.JButtonCellEditor;
import GUIs.utils.JButtonRenderer;
import GUIs.utils.JTextFieldLimit;
import entidades.Categoria;
import entidades.Producto;
import fachada.FachadaControl;
import interfaces.IFachadaControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public final class AdmiProductoForm extends javax.swing.JFrame {

    private static AdmiProductoForm admiProductoForm;
    private List<Categoria> categorias;

    private AdmiProductoForm() {
        initComponents();
        this.logica = new FachadaControl();
        llenarCategorias();
        llenarTabla();
        initBotonesTabla();
        jTableProductos.getTableHeader().setReorderingAllowed(false);
        jTextFieldNombre.setDocument(new JTextFieldLimit(100));
        jTextFieldDescripcion.setDocument(new JTextFieldLimit(200));
        jTextFieldPrecioCompra.setDocument(new JTextFieldLimit(12));
        jTextFieldPrecioVenta.setDocument(new JTextFieldLimit(12));
        jTextFieldStock.setDocument(new JTextFieldLimit(12));
        jTextFieldCodigo.setDocument(new JTextFieldLimit(13));
    }

    public void llenarCategorias() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        categorias = logica.consultarTodasCategorias();
        for (int i = 0; i < categorias.size(); i++) {
            Categoria get = categorias.get(i);
            model.addElement(get.getNombre());
        }
        jComboBoxCategorias.setModel(model);
    }

    public static AdmiProductoForm getInstance() {
        if (admiProductoForm == null) {
            admiProductoForm = new AdmiProductoForm();
        }
        return admiProductoForm;
    }

    private final int COLEDITAR = 8;
    private final int COLELIMINAR = 9;
    private int idProducto;

    private void initBotonesTabla() {
        ActionListener onEditarClickListener = (ActionEvent e) -> {
            idProducto = (int) jTableProductos.getValueAt(jTableProductos.getSelectedRow(), 0);
            llenarFormulario(logica.consultarProducto(idProducto));

        };

        ActionListener onEliminarListener = (ActionEvent e) -> {
            idProducto = (int) jTableProductos.getValueAt(jTableProductos.getSelectedRow(), 0);
            eliminar(idProducto);
        };

        int indiceColumnaEditar = COLEDITAR;

        TableColumnModel modeloColumnas = this.jTableProductos.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEditarClickListener));

        indiceColumnaEditar = COLELIMINAR;

        modeloColumnas = this.jTableProductos.getColumnModel();

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));

        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor(new JTextField(), onEliminarListener));
    }

    private void llenarFormulario(Producto producto) {
        jTextFieldNombre.setText(producto.getNombre());
        jTextFieldDescripcion.setText(producto.getDescripcion());
        jTextFieldPrecioCompra.setText(String.valueOf(producto.getCosto()));
        jTextFieldPrecioVenta.setText(String.valueOf(producto.getPrecio()));
        jTextFieldMarca.setText(String.valueOf(producto.getMarca()));
        jTextFieldCodigo.setText(String.valueOf(producto.getCodigo()));
        int valor = (int) producto.getStock();
        jTextFieldStock.setText(String.valueOf(valor));
        int indic2e = categorias.indexOf(producto.getCategoria());
        jComboBoxCategorias.setSelectedIndex(indic2e);
    }

    private void eliminar(int idElimninar) {

        //Establece que por defecto que se seleccionó la opción "NO".
        int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar el producto seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcionSeleccionada == JOptionPane.YES_OPTION) {
            boolean seElimino = this.logica.eliminarProducto(idElimninar);
            if (seElimino) {
                JOptionPane.showMessageDialog(null, "Se eliminó el producto", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.llenarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar al producto", "Información", JOptionPane.ERROR_MESSAGE);
            }
            limpiarId();
        }
    }

    private void limpiarId() {
        idProducto = 0;
    }

    private boolean validarCamposLlenos() {

        if (jTextFieldNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el nombre del producto");
            return false;
        }
        if (jTextFieldCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el codigo del producto");
            return false;
        }

        if (jTextFieldMarca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese la marca del producto");
            return false;
        }
        if (jTextFieldDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese la descripcion del producto");
            return false;
        }
        if (jTextFieldPrecioCompra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el precioCompra del producto");
            return false;
        }
        if (jTextFieldPrecioVenta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el precio de venta del producto");
            return false;
        }
        if (jTextFieldStock.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese el stock del producto");
            return false;
        }

        return true;
    }

    private void guardar() {
        if (validarCamposLlenos()) {
            if (idProducto == 0) {
                agregar();
            } else {
                actualizar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean validarDatos() {
        String regexNumeros = "\\d+";
        String regexFloat = "\\d+(\\.\\d+)?";

        if (!jTextFieldPrecioCompra.getText().matches(regexFloat) || Float.parseFloat(jTextFieldPrecioCompra.getText()) <= 0 || Float.parseFloat(jTextFieldPrecioCompra.getText()) > 999999999) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese un numero mayor a 0 y no mayor a 9999999910, en el precio de compra");
            return true;
        }

        if (!jTextFieldPrecioVenta.getText().matches(regexFloat) || Float.parseFloat(jTextFieldPrecioVenta.getText()) <= 0 || Float.parseFloat(jTextFieldPrecioVenta.getText()) > 999999999) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese un numero mayor a 0 y no mayor a 9999999910, en el precio de venta");
            return true;
        }

        if (!jTextFieldStock.getText().matches(regexNumeros) || Integer.parseInt(jTextFieldStock.getText()) <= 0 || Integer.parseInt(jTextFieldStock.getText()) > 999999999) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese un numero entero en el stock  mayor a 0 y no mayor a 999999999");
            return true;
        }
        if (!jTextFieldCodigo.getText().matches(regexNumeros) || Integer.parseInt(jTextFieldCodigo.getText()) <= 0){ //|| Integer.parseInt(jTextFieldCodigo.getText()) > 999999999) {
            JOptionPane.showMessageDialog(null, "Se requiere que ingrese un numero entero de 10 digitos maximo");
            return true;
        }
        return false;
    }

    private void agregar() {
        if (validarDatos()) {
            return;
        }
        String nombre = jTextFieldNombre.getText();
        String descripcion = jTextFieldDescripcion.getText();
        String precioCompra = jTextFieldPrecioCompra.getText();
        String precioVenta = jTextFieldPrecioVenta.getText();
        String stock = jTextFieldStock.getText();
        Categoria categoria = categorias.get(jComboBoxCategorias.getSelectedIndex());
        String marca = jTextFieldMarca.getText();
        long codigo = Long.parseLong(jTextFieldCodigo.getText());
        Producto producto = new Producto(nombre, descripcion, marca, codigo, Float.parseFloat(stock), Float.parseFloat(precioVenta), Float.parseFloat(precioCompra), categoria);
        boolean seAgrego = logica.agregarProducto(producto);

        if (seAgrego) {
            JOptionPane.showMessageDialog(this, "Se agregó el nuevo producto", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible agregar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizar() {
        if (validarDatos()) {
            return;
        }
        String nombre = jTextFieldNombre.getText();
        String descripcion = jTextFieldDescripcion.getText();
        String precioCompra = jTextFieldPrecioCompra.getText();
        String precioVenta = jTextFieldPrecioVenta.getText();
        String stock = jTextFieldStock.getText();
        Categoria categoria = categorias.get(jComboBoxCategorias.getSelectedIndex());
        String marca = jTextFieldMarca.getText();
        long codigo = Long.parseLong(jTextFieldCodigo.getText());
        Producto producto = new Producto(nombre, descripcion, marca, codigo, Float.parseFloat(stock), Float.parseFloat(precioVenta), Float.parseFloat(precioCompra), categoria);
        producto.setId(idProducto);
        boolean seActualizo = logica.actualizarProducto(producto);
        if (seActualizo) {
            JOptionPane.showMessageDialog(this, "Se actualizó el producto", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
            limpiarId();
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible actualizar el producto", "Información", JOptionPane.ERROR_MESSAGE);
        }
    }
    private List<Producto> productos;

    //Bien
    private void llenarTabla() {
        productos = this.logica.consultarTodosProductos();
        if (productos != null) {
            DefaultTableModel modeloTabla = (DefaultTableModel) this.jTableProductos.getModel();
            this.jTableProductos.setRowHeight(30);
            modeloTabla.setRowCount(0);
            productos.forEach(producto -> {
                Object[] fila = new Object[8];
                fila[0] = producto.getId();
                fila[1] = producto.getNombre();
                fila[2] = producto.getMarca();
                fila[3] = producto.getDescripcion();
                fila[4] = producto.getCodigo();
                fila[5] = producto.getCosto();
                fila[6] = producto.getPrecio();
                fila[7] = producto.getStock();
                modeloTabla.addRow(fila);
            });
        }

    }
    private final IFachadaControl logica;

    private void limpiarFormulario() {
        jTextFieldNombre.setText("");
        jTextFieldDescripcion.setText("");
        jTextFieldPrecioCompra.setText("");
        jTextFieldPrecioVenta.setText("");
        jTextFieldStock.setText("");
jTextFieldCodigo.setText("");
jTextFieldMarca.setText("");
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
        jLabel10 = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldPrecioCompra = new javax.swing.JTextField();
        jTextFieldPrecioVenta = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldStock = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxCategorias = new javax.swing.JComboBox<>();
        lblRectangulo4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administración Productos");
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
        jLabel1.setText("PRODUCTOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1100, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("REGISTROS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 114, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("REGISTRAR");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 114, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Descripción");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Costo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Precio");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        jTextFieldNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 300, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Codigo");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jTextFieldMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 300, -1));

        jTextFieldCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 300, -1));

        jTextFieldDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 300, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Marca");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jTextFieldPrecioCompra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 300, -1));

        jTextFieldPrecioVenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextFieldPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 300, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 10, 540));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(null);

        jTableProductos.setBackground(new java.awt.Color(204, 204, 255));
        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Marca", "Descripción", "Codigo", "Precio Compra", "Precio Venta", "Stock", "Editar", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 598, 440));

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(0, 153, 255), java.awt.Color.white, java.awt.Color.white));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 140, -1));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 140, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Categoria");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

        jTextFieldStock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStockActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 300, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Stock");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        jPanel1.add(jComboBoxCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 300, 30));

        lblRectangulo4.setBackground(new java.awt.Color(204, 204, 255));
        lblRectangulo4.setOpaque(true);
        jPanel1.add(lblRectangulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 470, 380));

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

    private void jTextFieldStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStockActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecioCompra;
    private javax.swing.JTextField jTextFieldPrecioVenta;
    private javax.swing.JTextField jTextFieldStock;
    private javax.swing.JLabel lblRectangulo4;
    // End of variables declaration//GEN-END:variables
}
