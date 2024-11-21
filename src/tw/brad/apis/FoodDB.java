package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class FoodDB {
	private final static String URL = "jdbc:mysql://localhost/brad";
	private final static String USER = "root";
	private final static String PASSWD = "";
	private final static String SQL_QUERY = "SELECT * FROM food";
	
	private Connection conn;
	private ResultSet rs;

	public FoodDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);prop.put("password", PASSWD);
		conn = DriverManager.getConnection(URL, prop);
	}
	
	public void query() {
		
	}
	public void query(String sql) {
		
	}
	
	public int getRows() {
		return 10;
	}
	
	public int getCols() {
		return 4;
	}
	
	public String getData() {
		return "Brad";
	}
	
	
	
	
	

}
