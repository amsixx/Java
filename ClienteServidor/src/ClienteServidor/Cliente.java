/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;

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
        final int puerto = 3000;
        final String host = "localhost";
        DataInputStream input;
        DataOutputStream output;
        
        try {
            socket = new Socket(host,puerto);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            
            int numeroSecretoServidor;
            numeroSecretoServidor = Integer.parseInt(input.readUTF());
            
            System.out.println("Tienes que adivinar un numero del 0 al 500");
            
            int numeroCliente;
            Scanner scanner = new Scanner(System.in);
            do{
                System.out.println("Introduce el número");
                numeroCliente = scanner.nextInt();
                output.writeUTF(Integer.toString(numeroCliente));
                System.out.println(input.readUTF());
            }while(numeroCliente != numeroSecretoServidor);
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
