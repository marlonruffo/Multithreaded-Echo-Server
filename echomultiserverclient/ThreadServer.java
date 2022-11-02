/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package echomultiserverclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ThreadServer implements Runnable
{
    private Socket socket;
    private int count;
    private long id;
    InputStream io;
    OutputStream os;
    private PrintWriter pw;

    ThreadServer(Socket socket, int count)
    {
        this.socket = socket;
        this.count = count;
    }

    public long getId()
    {
        id = Thread.currentThread().getId();
        return id;
    }

    @Override
    public void run()
    {
        try
        {
            io = socket.getInputStream();
            os = socket.getOutputStream();
        }
        catch (IOException e) {System.err.println(e);}
        try (Scanner sc = new Scanner(io))
        {
            pw = new PrintWriter(os, true);
            pw.println("Connected");
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                if(!line.startsWith("echo: ")){
                    System.err.println("Please start your message with 'echo: '");
                }
                if(line.equals("quit")){
                    System.err.println("Client " + id + " left the session.");
                }
                System.out.println("Client "+count+": "+line);
                pw.println("Echo: "+line);     
            }
        }
        finally {
            System.out.println("Client " + this.id + " left the session.");
        }   
    }   
}