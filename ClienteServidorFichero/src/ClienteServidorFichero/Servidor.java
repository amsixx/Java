/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidorFichero;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismael
 */
public class Servidor {

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream input;
        DataOutputStream output;
        final int puerto = 4000;
        BufferedReader reader;
        StringBuilder sb = new StringBuilder();
        String linea;
        String contenidoFichero;

        try {
            serverSocket = new ServerSocket(puerto);
            System.out.println("Escucho el puerto " + puerto);

            socket = serverSocket.accept();
            System.out.println("Cliente conectado");

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            String fichero = input.readUTF();
            System.out.println("El cliente quiere leer el fichero " + fichero);
            File f = new File(fichero);
            if (f.exists()) {
                reader = new BufferedReader(new FileReader(f));
                linea = reader.readLine();
                while(linea!=null){
                    sb.append(linea);
                    sb.append(System.lineSeparator());
                    linea = reader.readLine();
                }
                contenidoFichero = sb.toString();
                output.writeUTF(contenidoFichero);
                System.out.println("Fichero enviado correctamente");
            }
            else{
                output.writeUTF("El fichero que ha pedido el cliente no existe");
            }
            socket.close();
            System.out.println("Cliente desconectado");

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
