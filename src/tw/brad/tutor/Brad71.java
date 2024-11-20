package tw.brad.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class Brad71 {
	private final static String URL = "jdbc:mysql://localhost/brad";
	private final static String USER = "root";
	private final static String PASSWD = "";
	private static Connection conn = null;
	private final static String SQL_UPDATE = 
		"UPDATE member SET icon = ? WHERE id = ?"; 

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			FileInputStream fin = new FileInputStream("dir2/ball3.png");
			pstmt.setBinaryStream(1, fin);
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
