package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;

public class Brad69 {
	private final static String URL = "jdbc:mysql://localhost/brad";
	private final static String USER = "root";
	private final static String PASSWD = "";
	private static Connection conn = null;
	private final static String SQL_CHECK1 = "SELECT count(*) cnt FROM member WHERE account = ?";
	private final static String SQL_CHECK2 = "SELECT * FROM member WHERE account = ?";
	private final static String SQL_REGISTER = "INSERT INTO member (account,passwd,name) VALUES (?,?,?)";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Account: ");
		String account = scanner.next();
		
		System.out.print("Password: ");
		String passwd = scanner.next();
		
		System.out.print("Name: ");
		String name = scanner.next();

		Properties prop = new Properties();
		prop.put("user", USER);prop.put("password", PASSWD);

		try {
			conn = DriverManager.getConnection(URL, prop);
			
			if (!isAccountExist(account)) {
				try {
					registerAccount(account, passwd, name);
					System.out.println("Register Success");
				} catch (Exception e) {
					System.out.println("Register ERR!");
				}
			}else {
				System.out.println("Account EXIST!");
			}
		}catch(Exception e) {
			System.out.println("Conn ERROR!");
		}
	}
	
	static boolean isAccountExist(String account) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_CHECK2);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
			
//			rs.next();
//			int num = rs.getInt("cnt");
//			return num > 0 ;
			
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	
	static void registerAccount(String account, String passwd, String name) throws Exception{
		PreparedStatement pstmt = conn.prepareStatement(SQL_REGISTER);
		pstmt.setString(1, account);
		pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
		pstmt.setString(3, name);
	
		int n = pstmt.executeUpdate();
		if (n == 0) throw new Exception();
		
	}
	

}
