/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package echomultiserverclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Xamat
 */
public class EchoClient {
    
    
    public static void main(String[] args)  {
        System.out.println("EchoClient started");
        String screenName = args[0];
        String hostName = args[1];
        int port = 1234;

        try (
            Socket socket = new Socket(hostName, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));)
            {
                System.err.println("Coneccted to " + hostName + " on port " + port);
                String userInput;
                while (true) {
                    userInput = stdIn.readLine();
                    if (userInput.equals("quit")) {
                        break;
                    }
                    out.println(screenName + ": " + userInput);
                    out.println("[" + screenName + "]: " + userInput);
                    System.out.println(in.readLine());
                }
                System.out.println("Closing connection to " + hostName);
                out.close();
                in.close();
                stdIn.close();
                socket.close();
               
            }catch(IOException e){
                System.err.println("Couldn't get I/O for the connection to " + "localhost");
                System.exit(1);
            }

            }

    
        
    }

