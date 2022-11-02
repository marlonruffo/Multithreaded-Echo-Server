/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package echomultiserverclient;
import java.io.*;
import java.net.*;

/**
 *
 * @author Xamat
 */
public class EchoServer extends Thread {

    public static void main(String[] args) throws IOException {

        int count = 0;
        long[] id = new long[10];
        int port = 1234;
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("Server started on port " + port);
            while (true) {
                count++;
                Socket socket = serverSocket.accept();
                Runnable r = new ThreadServer(socket, count);
                Thread t = new Thread(r);
                id[count - 1] = t.getId();
                t.start();
                if (Thread.activeCount() != count + 1) {
                    System.out.println("Client " + id[count - 1] + " left the session.");
                }


                System.err.println("Closing connection");
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}