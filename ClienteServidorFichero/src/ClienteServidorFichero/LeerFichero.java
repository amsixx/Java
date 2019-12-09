/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidorFichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class LeerFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\users\\admin\\Texto.txt");
        String linea;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            linea = br.readLine();
            System.out.println(linea);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
