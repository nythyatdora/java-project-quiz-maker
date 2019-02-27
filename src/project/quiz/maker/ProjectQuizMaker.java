
package project.quiz.maker;

public class ProjectQuizMaker {

    public static void main ( String[] args ) {
        DialogLogin dialogLogin = new DialogLogin (null, true);
        dialogLogin.setVisible (true);
        
        boolean isAllowed = dialogLogin.getAccessAllowed ();
        
        if (isAllowed) {
            dialogLogin.dispose ();
            
            User loggedUser = dialogLogin.getLoggingUser ();
            
            java.awt.EventQueue.invokeLater (new Runnable () {
                public void run () {
                    new FormMain (loggedUser).setVisible (true);
                }
            });
        }
    }
}
