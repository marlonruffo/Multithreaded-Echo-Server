import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.net.ServerSocket;
class NovoCliente extends Thread {
	final DataInputStream in_in;
	final DataOutputStream out_out;
	final Socket socket;
	final ServerSocket server;

	// constructor
	public NovoCliente(Socket s, DataInputStream in_in, DataOutputStream out_out,ServerSocket server ) {
        this.out_out = out_out;
		this.in_in = in_in;
		this.socket = s;
		this.server = server;
	}

	public void run() {
		String msgrecebida;
		while (true) {
			try {
				out_out.writeUTF("");
				msgrecebida = in_in.readUTF();
                /*se msg=quit */
				if (msgrecebida.equals("quit")) {
					System.out.println("Uma conexão com o cliente foi encerrada");
					this.socket.close();
					break;
				}
				out_out.writeUTF(msgrecebida);
				if(msgrecebida.startsWith("echo")){
					
					System.out.println("Mensagem do cliente: " +  msgrecebida.replace("echo", ""));
				}
				else{
					System.out.println("O cliente falhou ao enviar a mensagem");
				}
			} catch (Exception erro) {
				System.out.println(erro);
			}
		}
		try {
			this.in_in.close();
			this.out_out.close();
		} catch (IOException erro) {
			System.out.println("Erro: " + erro);
		}
	}
}