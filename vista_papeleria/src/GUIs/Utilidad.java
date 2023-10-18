package GUIs;

public class Utilidad {

    private static Utilidad utilidad;

    private Utilidad() {
    }

    public static Utilidad getInstance() {
        if (utilidad == null) {
            utilidad = new Utilidad();
        }
        return utilidad;
    }

    public void busqueda() {

        java.awt.EventQueue.invokeLater(() -> {
            BusquedaArticuloForm.getInstance().resetBusquedas();
            BusquedaArticuloForm.getInstance().llenarCategorias();
            BusquedaArticuloForm.getInstance().setVisible(true);
        });
    }

    public void producto() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiProductoForm.getInstance().llenarTabla();
                AdmiProductoForm.getInstance().llenarCategorias();
                AdmiProductoForm.getInstance().setVisible(true);
            }
        });
    }

    public void cliente() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiClienteForm.getInstance().llenarTabla();
                AdmiClienteForm.getInstance().setVisible(true);

            }
        });
    }

    public void proveedor() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiProveedorForm.getInstance().llenarTabla();
                AdmiProveedorForm.getInstance().setVisible(true);
            }
        });
    }

    public void categoria() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiCategoria.getInstance().llenarTabla();
                AdmiCategoria.getInstance().setVisible(true);
            }
        });
    }

    public void usuario() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdmiUsuarioForm.getInstance().llenarTabla();
                AdmiUsuarioForm.getInstance().setVisible(true);
            }
        });
    }
}
