
package javaclasscreator;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class JavaClassCreator {

   
    public static void main(String[] args) {
                try { 
       // Set System L&F 
        UIManager.setLookAndFeel( 
            UIManager.getSystemLookAndFeelClassName()); 
    } 
    catch (UnsupportedLookAndFeelException e) { 
       // handle exception 
    } 
    catch (ClassNotFoundException e) { 
       // handle exception 
    } 
    catch (InstantiationException e) { 
       // handle exception 
    } 
    catch (IllegalAccessException e) { 
       // handle exception 
    } 
        
        FirstWindow firstWindow = new FirstWindow();
        firstWindow.setVisible(true);
        
     
      
    }
    
}
