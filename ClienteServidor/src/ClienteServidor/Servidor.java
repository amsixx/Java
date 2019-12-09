/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ismael
 */
public class Servidor {

    public static void main(String[] args) {
        ServerSocket servidor;
        DataInputStream input;
        DataOutputStream output;
        Socket socket;
        final int puerto = 3000;

        Random r = new Random();
        int numeroSecreto;

        numeroSecreto = r.nextInt((500 - 0) + 1) + 0;

        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Escucho el puerto " + puerto);

            socket = servidor.accept();
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(Integer.toString(numeroSecreto));

            System.out.println("Cliente conectado");
            boolean acertado = false;
            do {
                int numeroCliente = Integer.parseInt(input.readUTF());
                System.out.println("El cliente ha dicho " + numeroCliente);
                if (numeroCliente < numeroSecreto) {
                    output.writeUTF("El número secreto es mayor");
                }
                if (numeroCliente > numeroSecreto) {
                    output.writeUTF("El número secreto es menor");
                }
                if (numeroCliente == numeroSecreto) {
                    output.writeUTF("Correcto");
                    acertado = true;
                }
            } while (acertado == false);

            socket.close();
            System.out.println("Cliente desconectado");

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
