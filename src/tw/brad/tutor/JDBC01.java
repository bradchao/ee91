package tw.brad.tutor;

import java.sql.*;
import java.util.Properties;

public class JDBC01 {

	public static void main(String[] args) {
		/*
		try {
			// "com.microsoft.sqlserver.jdbc.SQLServerDriver"
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		*/
		
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=");
//			System.out.println("OK2");
//		} catch (SQLException e) {
//			System.out.println(e);
//		}

//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/","root","");
//			System.out.println("OK3");
//		} catch (SQLException e) {
//			System.out.println(e);
//		}

		// String connectionUrl = "jdbc:sqlserver://localhost;encrypt=true;database=AdventureWorks;integratedSecurity=true;"  
		// Connection con = DriverManager.getConnection(connectionUrl);
		
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/",prop);
			System.out.println("OK4");
			
			Statement stmt = conn.createStatement();
			if (stmt.execute("CREATE DATABASE iii2")) {
				System.out.println("OK");
			}else {
				System.out.println("XX");
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
		
		
		
	}

}
