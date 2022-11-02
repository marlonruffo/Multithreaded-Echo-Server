import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) throws IOException  {
			try {
				Scanner sc = new Scanner(System.in);
				InetAddress endereco = InetAddress.getByName("localhost");
				int port = 4444;
				Socket s = new Socket(endereco, port);	
				System.out.println("Conectado por: "+endereco +" na porta: " +port );
				DataInputStream in_in= new DataInputStream(s.getInputStream());
				DataOutputStream out_out = new DataOutputStream(s.getOutputStream());
				
				while(true) {
					System.out.println(in_in.readUTF());
					String msgenviar=sc.nextLine();
					out_out.writeUTF(msgenviar);

					/*se msg=quit */
					if(msgenviar.equals("quit")) {
						s.close();
						System.out.println("Conexão Encerrada");
						break;
					}
					String msgrecebida = in_in.readUTF();
					System.out.println("Servidor diz: "+ msgrecebida);
				            }
				    sc.close();
				    in_in.close();
				    out_out.close();
			}catch(Exception erro) {
				System.out.println("Erro: "+erro);
			}

		}
	}