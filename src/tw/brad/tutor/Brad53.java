package tw.brad.tutor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad53 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(InetAddress.getByName("10.0.104.177"), 9999);
			OutputStream out = socket.getOutputStream();
			out.write("Hello, Brad".getBytes());
			out.flush();
			out.close();
			System.out.println("TCP Send OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
