package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad54 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			Socket socket =  server.accept();
			
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			String mesg = reader.readLine();
			String urip = socket.getInetAddress().getHostAddress();
			System.out.printf("%s : %s\n", urip, mesg);
			
			reader.close();
			server.close();
			System.out.println("Server OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
