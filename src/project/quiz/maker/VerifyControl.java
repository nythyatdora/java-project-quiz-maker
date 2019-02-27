
package project.quiz.maker;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VerifyControl {
    public static boolean hasAllInputFieldsFilled(JPanel panel) {
        boolean isFilled = true;
        for(Component component : panel.getComponents ()) {
            if (component instanceof JTextField) {
                if( ((JTextField) component).getText () .equals ("") ) {
                    isFilled = false;
                    return isFilled;
                }
            }
        }
        return isFilled;
    }
    
    public static Component getEmptyInputField(JPanel panel) {
        for(Component component : panel.getComponents ()) {
            if (component instanceof JTextField) {
                if( ((JTextField) component).getText () .equals ("") ) {
                    return component;
                }
            }
        }
        return null;
    }
    
    public static void clearInputFields(JPanel panel) {
        for(Component component : panel.getComponents ()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText ("");
            }
        }
    }
}
