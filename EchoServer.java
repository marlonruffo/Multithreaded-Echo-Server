import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.io.DataInputStream;

public class EchoServer {
	public static void main(String[] args) throws IOException {
        int port = 4444;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Servidor iniciado na porta:" + port);
        while(true){
            Socket socket = null;
            try{
            socket = server.accept();
            System.out.println("Conexão aceita por um cliente");
            DataInputStream in_in = new DataInputStream(socket.getInputStream());
            DataOutputStream out_out = new DataOutputStream(socket.getOutputStream());

            Thread novathread = new NovoCliente(socket, in_in, out_out, server);
            novathread.start();

            }catch(IOException erro){

                socket.close();
                System.out.println(erro);
            }
            

        }
}
}


