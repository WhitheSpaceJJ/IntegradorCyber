package GUIs.utils;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JButtonCellEditor extends DefaultCellEditor {

    protected JButton btn;
    private String lbl;
    private Boolean clicked;
    private ActionListener onClickListener;

    public JButtonCellEditor(JTextField txt, ActionListener onClickListener) {
        super(txt);
        this.onClickListener = onClickListener;
        btn = new JButton();
        btn.setOpaque(true);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj,
            boolean selected, int row, int col) {
        lbl = (obj == null) ? "" : obj.toString();
        btn.setText(lbl);
        clicked = true;
        return btn;
    }

    @Override
    public Object getCellEditorValue() {
        if (clicked) {
            this.onClickListener.actionPerformed(
                new ActionEvent(lbl, ActionEvent.ACTION_PERFORMED, null)
            );
        }
        clicked = false;
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        try{
            super.fireEditingStopped();
        }catch(Exception e){
        }
        
    }
}
