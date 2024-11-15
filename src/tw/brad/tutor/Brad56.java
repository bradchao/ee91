package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad56 {

	public static void main(String[] args) {
		while(true) {
			try {
				ServerSocket server = new ServerSocket(7777);
				Socket socket = server.accept();
				BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
				
				String ip = socket.getInetAddress().getHostAddress();
				String filename = String.format("dir3/%s.jpg", ip);
				BufferedOutputStream bout = 
						new BufferedOutputStream(new FileOutputStream(filename));
				
				byte[] buf = new byte[4*1024*1024];
				int len;
				while ( (len = bin.read(buf)) != -1) {
					bout.write(buf, 0, len);
				}
				
				bout.flush();
				bout.close();
				
				bin.close();
				server.close();
				System.out.println(ip + ": OK");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}

}
