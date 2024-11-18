package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Brad57 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.ispan.com.tw/");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			
			String line;
			while ( (line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
