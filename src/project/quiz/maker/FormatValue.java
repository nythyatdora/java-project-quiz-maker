
package project.quiz.maker;

import java.text.DecimalFormat;

public class FormatValue {
    
    public static Double formatAverage(Double value) {
        Double newValue;
        DecimalFormat decimalFormat = new DecimalFormat ();
        
        decimalFormat.setMaximumFractionDigits (2);
        
        newValue = Double.valueOf (decimalFormat.format (value));
        
        return newValue;
    }
    
}
