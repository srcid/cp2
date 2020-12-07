package br.ufc.cp2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alcides
 */
public class Main {
    
    public static void main(String[] args) {
        
        long started = System.currentTimeMillis();
        long ended;
        String filenameOrigin;
        String filenameDestiny;
        filenameOrigin = args[0];
        filenameDestiny = args[1];
        System.out.println(filenameOrigin);
        System.out.println(filenameDestiny);
        
        InputStream in = null;
        OutputStream out = null;
        
        try {
            
            in = new BufferedInputStream(new FileInputStream(filenameOrigin));
            out = new BufferedOutputStream(new FileOutputStream(filenameDestiny));
            byte[] buffer = new byte[1024];
            int lengthRead = 0;
            
            while ( (lengthRead = in.read(buffer)) > 0 ) {
                
                out.write(buffer, 0, lengthRead);
                out.flush();
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ended = System.currentTimeMillis();
        System.out.println("Total time spent (milliseconds): " + (ended - started));
        
    }
    
}
