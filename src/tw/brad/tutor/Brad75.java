package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/*
    SELECT e.EmployeeID,e.LastName,SUM(od.UnitPrice*od.Quantity) rev
	FROM orders o
	JOIN orderdetails od ON (o.OrderID = od.OrderID)
	JOIN employees e ON (o.EmployeeID = e.EmployeeID)
	GROUP BY o.EmployeeID
	ORDER BY rev DESC
	
	4 Peacock 250187.4500
	
	驗算
	SELECT SUM(UnitPrice*Quantity) SUM FROM orderdetails
	WHERE OrderID IN (
		SELECT OrderID FROM orders WHERE EmployeeID = 4
	)
 */
public class Brad75 {
	private final static String URL = "jdbc:mysql://localhost/bnorth";
	private final static String USER = "root";
	private final static String PASSWD = "";
	private static Connection conn = null;
	private final static String SQL_QUERY = 
		"SELECT e.EmployeeID id,e.LastName name ,SUM(od.UnitPrice*od.Quantity) rev\r\n"
		+ "	FROM orders o\r\n"
		+ "	JOIN orderdetails od ON (o.OrderID = od.OrderID)\r\n"
		+ "	JOIN employees e ON (o.EmployeeID = e.EmployeeID)\r\n"
		+ "	GROUP BY o.EmployeeID\r\n"
		+ "	ORDER BY rev DESC"; 
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String rev = rs.getString("rev");
				System.out.printf("%s: %s : %s\n", id, name, rev);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
