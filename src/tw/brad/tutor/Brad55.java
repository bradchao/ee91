package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Brad55 {
	public static void main(String[] args) {
		File source = new File("dir1/brad.jpg");
		try {
			BufferedInputStream bin = new BufferedInputStream(
					new FileInputStream(source));
			byte[] buf = new byte[(int)source.length()];
			bin.read(buf);
			bin.close();
			//---------------------------------
			Socket socket = new Socket(InetAddress.getByName("10.0.104.177"), 7777);
			BufferedOutputStream bout = 
				new BufferedOutputStream(socket.getOutputStream());
			bout.write(buf);
			bout.flush();
			bout.close();
			System.out.println("Send Success");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
