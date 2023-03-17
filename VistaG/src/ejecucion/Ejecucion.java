
package ejecucion;

import GUIs.PrincipalForm;



public class Ejecucion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            PrincipalForm.getInstance().setVisible(true);
            }
        });
    }
    
}
