
package project.quiz.maker;

public class VerifyVariable {
    public static boolean isEmptyOrDefault ( String var ) {
        return var.equals ("") || var.isEmpty ();
    }
    
    public static boolean hasDialogOpened ( Object obj ) {
        return obj != null;
    }
    
    public static boolean hasFormOpened (Object obj) {
        return obj != null;
    }
    
    public static String isYesOrNo(boolean value) {
        if(value)
            return "YES";
        return "NO";
    }
    
    public static boolean isNull(int value) {
        return value == -1;
    }
    
    public static boolean isNull(Object value) {
        return value == null;
    }
    
    public static boolean isValueEqual(int fromValue, int toValue) {
        return fromValue == toValue;
    }
}
