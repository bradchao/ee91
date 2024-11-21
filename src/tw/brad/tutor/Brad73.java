package tw.brad.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import tw.brad.apis.Bike;

public class Brad73 {
	private final static String URL = "jdbc:mysql://localhost/brad";
	private final static String USER = "root";
	private final static String PASSWD = "";
	private static Connection conn = null;
	private final static String SQL_UPDATE = 
		"UPDATE member SET bike = ? WHERE id = ?"; 

	public static void main(String[] args) {
		Bike bike = new Bike();
		bike.upSpeed();bike.upSpeed();bike.upSpeed();bike.upSpeed();
		bike.upSpeed();bike.upSpeed();bike.upSpeed();bike.upSpeed();
		System.out.println(bike.getSpeed());
		
		Properties prop = new Properties();
		prop.put("user", USER);prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setObject(1, bike);
			
			pstmt.setInt(2, 1);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("OK");
			}else {
				System.out.println("XX");
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

}
