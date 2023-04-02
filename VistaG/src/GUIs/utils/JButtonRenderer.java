package GUIs.utils;

import java.awt.Component;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class JButtonRenderer extends JButton implements TableCellRenderer {

    public JButtonRenderer(String text) {
        this.setOpaque(true);
        URL url;
        if(text.equals("Editar")){
            url = getClass().getResource("/images/editar.png");
        }else{
            url = getClass().getResource("/images/eliminar.png");
        }
        ImageIcon icon = new ImageIcon(url);
        this.setIcon(icon);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText((obj==null) ? "":obj.toString());
        return this;
    }
}
