package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC02 {

	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/brad",prop);
			
			Statement stmt = conn.createStatement();
			String sql = "";
			stmt.execute(sql);
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
