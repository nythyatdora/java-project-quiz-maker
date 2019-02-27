
package project.quiz.maker;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModifyControl {
    public static void requestFocusOnMissingField (JPanel panel) {
        JTextField missingField = (JTextField) VerifyControl.getEmptyInputField (panel);
        missingField.requestFocus ();
    }
}
