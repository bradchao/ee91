package tw.brad.tutor;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.apis.Bike;

public class Brad74 {
	private final static String URL = "jdbc:mysql://localhost/brad";
	private final static String USER = "root";
	private final static String PASSWD = "";
	private static Connection conn = null;
	private final static String SQL_QUERY = 
		"SELECT * FROM member WHERE id = ?"; 
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String account = rs.getString("account");
				InputStream in = rs.getBinaryStream("bike");
				
				//---------------
				ObjectInputStream oin = new ObjectInputStream(in);
				Object obj =  oin.readObject();
				Bike bike = (Bike)obj;
				System.out.println(bike.getSpeed());
			}
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
