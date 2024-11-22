package tw.brad.apis;

import java.sql.*;
import java.util.Properties;

public class FoodDB {
	private final static String URL = "jdbc:mysql://localhost/brad";
	private final static String USER = "root";
	private final static String PASSWD = "";
//	private final static String SQL_QUERY = "SELECT id 編號, name 名稱, tel 電話 FROM food";
	private final static String SQL_QUERY = "SELECT * FROM food";
	
	private Connection conn;
	private ResultSet rs;
	private String[] fieldNames;

	public FoodDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);prop.put("password", PASSWD);
		conn = DriverManager.getConnection(URL, prop);
	}
	
	public void query() throws Exception{
		query(SQL_QUERY);
	}
	public void query(String sql) throws Exception {
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		fieldNames = new String[rsmd.getColumnCount()];
		for (int i=0; i<fieldNames.length; i++) {
			fieldNames[i] = rsmd.getColumnLabel(i+1);
		}
		
	}
	
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		}catch(Exception e) {
			return 0;
		}
	}
	
	public int getCols() {
		return fieldNames.length;
	}
	
	// row, col => 0-base
	public String getData(int row, int col) {
		try {
			rs.absolute(row+1);
			return rs.getString(fieldNames[col]);
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
	public String[] getFieldNames() {
		return fieldNames;
	}
	
	// 0-base
	public void delData(int row){
		try {
			rs.absolute(row+1);
			rs.deleteRow();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
