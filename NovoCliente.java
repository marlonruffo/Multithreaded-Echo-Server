import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;

class NovoCliente extends Thread {
	final DataInputStream in_in;
	final DataOutputStream out_out;
	final Socket socket;

	// constructor
	public NovoCliente(Socket s, DataInputStream in_in, DataOutputStream out_out) {
        this.out_out = out_out;
		this.in_in = in_in;
		this.socket = s;
	}

	public void run() {
		String msgrecebida;
		while (true) {
			try {
				out_out.writeUTF("Mande uma mensagem para o Servidor");
				msgrecebida = in_in.readUTF();
                /*se msg=quit */
				if (msgrecebida.equals("quit")) {
					System.out.println("Uma conexão com o cliente foi encerrada");
					this.socket.close();
					break;
				}
				out_out.writeUTF(msgrecebida);
				System.out.println("Resposta do cliente: " + msgrecebida);
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