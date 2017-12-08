package View;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author riza
 */
public class Main {
    //for rooting
    public static boolean restriced = false;
    public static Dahboard newForm;
    public static LogIn loginForm;
    
    private static void setTheme(){
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    private static boolean debugMode = false;//kasih login/ ndak
    public static void main(String[] args) {
        restriced = true;
        setTheme();
        
        if (debugMode) {
            Session.login();
            newForm = new Dahboard();
            newForm.setVisible(true);
            
        }else{
            loginForm = new LogIn();
            loginForm.setVisible(true);
        }
    }
}
