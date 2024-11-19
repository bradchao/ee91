package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
			//String sql = "INSERT INTO cust (name,tel,birthday) VALUES ('mark','123','1999-01-02')";
			//String sql = "DELETE FROM cust WHERE id = 3";
			//String sql = "UPDATE cust SET tel = '456' WHERE id = 2";
			//stmt.execute(sql);
			//System.out.println("OK");
			
			String sql = "SELECT * FROM cust";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String birthday = rs.getString("birthday");
				System.out.printf("%s : %s : %s : %s\n", id, name, tel, birthday);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
