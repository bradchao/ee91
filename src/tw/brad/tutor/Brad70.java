package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;
import tw.brad.apis.Member;

public class Brad70 {
	private final static String URL = "jdbc:mysql://localhost/brad";
	private final static String USER = "root";
	private final static String PASSWD = "";
	private static Connection conn = null;
	private final static String SQL_LOGIN = "SELECT * FROM member WHERE account = ?"; 
			
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Account: ");
		String account = scanner.next();
		
		System.out.print("Password: ");
		String passwd = scanner.next();

		try {
			Member member = isLoginSuccess(account, passwd);
			if (member != null) {
				System.out.printf("Welcome, %s", member.getName());
			}else {
				System.out.println("Login Failure");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
				
		
		
	}
	
	private static Member isLoginSuccess(String account, String passwd) throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);prop.put("password", PASSWD);
		conn = DriverManager.getConnection(URL, prop);
		PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN);
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			String hashPasswd = rs.getString("passwd");
			if (BCrypt.checkpw(passwd, hashPasswd)) {
				return new Member(rs.getInt("id"), account, hashPasswd, rs.getString("name"));
			}else {
				System.out.println("ERR1!");
				return null;
			}
		}else {
			System.out.println("ERR2!");
			return null;
		}
	}
	
	

}
