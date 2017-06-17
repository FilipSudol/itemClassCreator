
package javaclasscreator;

import java.io.File;

/**
 *
 * @author filip
 */
public class DirExplorer {

     public void walk( String path ) { 

        File root = new File( path ); 
        File[] list = root.listFiles(); 

        for ( File f : list ) { 
            if ( f.isDirectory() ) { 
                walk( f.getAbsolutePath() ); 
                System.out.println( "Dir:" + f.getAbsoluteFile() ); 
            } 
            else { 
                System.out.println( "File:" + f.getAbsoluteFile() ); 
            } 
        } 
    } 


    
}



