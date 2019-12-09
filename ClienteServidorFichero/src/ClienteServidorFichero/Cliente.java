/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidorFichero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismael
 */
public class Cliente {
    public static void main(String[] args) {
        Socket socket;
        DataInputStream input;
        DataOutputStream output;
        final int puerto = 4000;
        final String host = "localhost";
        String escribir;
        String contenidoFichero;
        
        try {
            socket = new Socket(host,puerto);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el nombre del fichero a leer");
            escribir = scanner.nextLine();
            output.writeUTF(escribir);
            contenidoFichero = input.readUTF();
            System.out.println(contenidoFichero);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
}
