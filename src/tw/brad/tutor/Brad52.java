package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Brad52 {

	public static void main(String[] args) {
		byte[] data = new byte[1024];	// 0,0,0
		while(true) {
			try {
				DatagramSocket socket = new DatagramSocket(8888);
				DatagramPacket packet = new DatagramPacket(data, data.length);
				socket.receive(packet);
				socket.close();
				byte[] temp = packet.getData();
				int len = packet.getLength();
				String mesg = new String(temp, 0, len);
				String urip = packet.getAddress().getHostAddress();
				System.out.printf("%s : %s\n", urip, mesg);
				if (mesg.equals("quit")) {
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
