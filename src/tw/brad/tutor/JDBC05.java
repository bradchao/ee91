package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JDBC05 {

	public static void main(String[] args) {
		System.out.print("Keyword: ");
		Scanner scanner = new Scanner(System.in);
		String key = scanner.next();
		
		String sql = "SELECT * FROM food WHERE name LIKE ? OR addr LIKE ? OR tel LIKE ? OR feature LIKE ?";
		String kw = "%" + key + "%";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		String url = "jdbc:mysql://localhost/brad";
		
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kw);pstmt.setString(2, kw);pstmt.setString(3, kw);pstmt.setString(4, kw);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				String feature = rs.getString("feature");
				System.out.printf("%s:%s:%s\n", name,tel,addr);
				System.out.println("-----");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
