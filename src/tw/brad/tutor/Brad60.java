package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brad60 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			
			String line; StringBuffer sb = new StringBuffer();
			while ( (line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			
			//System.out.println(sb.toString());
			parseJSON(sb.toString());
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		//System.out.println(root.length());
		for (int i = 0; i<root.length(); i++) {
			JSONObject e = root.getJSONObject(i);
			String name = e.getString("Name");
			double lat = e.getDouble("Latitude");
			double lng = e.getDouble("Longitude");
			System.out.printf("%s:%f:%f\n", name, lat, lng);
		}
		
		
		
	}
	
	
	

}
