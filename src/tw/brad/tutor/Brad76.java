package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Brad76 {
	private final static String URL = "jdbc:mysql://localhost/brad";
	private final static String USER = "root";
	private final static String PASSWD = "";
	private static Connection conn = null;
	private final static String SQL_QUERY = "SELECT * FROM food";
			
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);prop.put("password", PASSWD);		
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY,
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s.%s\n", id, name);
			}
			System.out.println("----");
			if (rs.absolute(4)) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s.%s\n", id, name);
			}
			System.out.println("----");
			if (rs.previous()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s.%s\n", id, name);
			}
			System.out.println("----");
			if (rs.first()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s.%s\n", id, name);
			}
			System.out.println("----");
			if (rs.absolute(6)) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s.%s\n", id, name);
				
				rs.updateString("name", "北門口活魚餐廳");
				rs.updateString("tel", "0931-123456");
				rs.updateRow();
			}

			System.out.println("----");
			if (rs.absolute(20)) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s.%s\n", id, name);

				rs.deleteRow();
				
				id = rs.getString("id");
				name = rs.getString("name");
				System.out.printf("%s.%s\n", id, name);
				
			}
			
			rs.moveToInsertRow();
			rs.updateString("name", "不來的大餐廳");
			rs.updateString("tel", "0912-123456");
			rs.insertRow();
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
			
	}

}
