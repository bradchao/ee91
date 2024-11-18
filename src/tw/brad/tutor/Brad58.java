package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Brad58 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.ispan.com.tw/img/lease_01.jpg");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			BufferedOutputStream bout = 
				new BufferedOutputStream(new FileOutputStream("dir1/ispan.jpg"));
			
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			byte[] buf = new byte[4*1024*1024]; int len;
			while ( (len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			
			bout.flush();
			bout.close();
			bin.close();
			System.out.println("download success");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
