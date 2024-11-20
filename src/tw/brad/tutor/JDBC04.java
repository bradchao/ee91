package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;

public class JDBC04 {

	public static void main(String[] args) {
		try {
			URL url = new URL(
				"https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			URLConnection conn = url.openConnection();
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer sb = new StringBuffer();
			while ( (line = reader.readLine()) != null) {
				sb.append(line);
			}
			System.out.println("OK");
			parseJSON(sb.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static void parseJSON(String json) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/brad",prop);) {	
			
			String sqlDel = "DELETE FROM food";
			conn.createStatement().executeUpdate(sqlDel);			

			String sqlZero = "ALTER TABLE food AUTO_INCREMENT = 1";
			conn.createStatement().executeUpdate(sqlZero);			

			
			String sql = "INSERT INTO food (name,addr,tel,feature,picurl,lat,lng) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			JSONArray root = new JSONArray(json);
			for (int i=0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String name = row.getString("Name");
				String addr = row.getString("Address");
				String tel = row.getString("Tel");
				String feature = row.getString("HostWords");
				String picurl = row.getString("PicURL");
				String lat = row.getString("Latitude");
				String lng = row.getString("Longitude");
				
				pstmt.setString(1, name);
				pstmt.setString(2, addr);
				pstmt.setString(3, tel);
				pstmt.setString(4, feature);
				pstmt.setString(5, picurl);
				pstmt.setString(6, lat);
				pstmt.setString(7, lng);
				
				pstmt.executeUpdate();
				
			}
			System.out.println("OK");
		}catch (Exception e){
			System.out.println(e);
		}
	} 
	
	
	

}
