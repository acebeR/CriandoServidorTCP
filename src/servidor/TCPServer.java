package servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	 public static void main( String argv[]) throws Exception 
	 { 
		 String clientSentence; 
		 String capitalizedSentence; 
		 ServerSocket welcomeSocket = new ServerSocket(6789); 
 
		 System.out.println("Ponto 1: Aceitou a conexao");			 		 
		 Socket connectionSocket = welcomeSocket.accept(); 			
		
		System.out.println("Ponto 2: Inicio Leitura");		
		 do { 
															
			BufferedReader inFromClient = new BufferedReader( 
											new InputStreamReader(
												connectionSocket.getInputStream()
											)
										   );
			DataOutputStream outToClient = new DataOutputStream(
												connectionSocket.getOutputStream()
												); 
			System.out.println("Ponto 3: Leitura da Linha");												
			clientSentence = inFromClient.readLine(); 
			System.out.println("Ponto 4: Envio do conteudo");	
			if(clientSentence != null) {
				capitalizedSentence = clientSentence.toUpperCase() + '\n'; 
				outToClient.writeBytes(capitalizedSentence); 
			}
			
			
			// connectionSocket.close();
		} while (clientSentence != null);
	 }
}
