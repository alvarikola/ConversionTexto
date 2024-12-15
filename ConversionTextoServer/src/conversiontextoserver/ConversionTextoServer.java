package conversiontextoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class ConversionTextoServer {

    public static void main(String[] args) {
        Random rand = new Random();
        int port = 1234;
        
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Servidor iniciado en el puerto " + port + ".");

            
            // Aceptar una conexion
            Socket client = server.accept();
            System.out.println("Cliente conectado: " + client.getInetAddress());

            // Leer y responder al cliente
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);

            
            String message = input.readLine();
            System.out.println("El mensaje recibido es: " + message);
            // Mayusculas
            String answer = message.toUpperCase();
            // Minusculas
            //String answer = message.toLowerCase();
            output.println(answer); 

        } catch (IOException ex) {
        ex.printStackTrace();
        } 
    }
    
}
