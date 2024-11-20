package tw.brad.tutor;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Brad72 {
	private final static String URL = "jdbc:mysql://localhost/brad";
	private final static String USER = "root";
	private final static String PASSWD = "";
	private static Connection conn = null;
	private final static String SQL_QUERY = 
		"SELECT * FROM member WHERE id = ?"; 
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String account = rs.getString("account");
				InputStream in = rs.getBinaryStream("icon");
				//---------------
				new Thread() {
					public void run() {
						try {
							String filename = "dir3/brad.png";
							FileOutputStream fout = new FileOutputStream(filename);
							byte[] buf = new byte[64*1024];
							int len = in.read(buf);
							fout.write(buf, 0, len);
							fout.flush();
							fout.close();
							System.out.println("Save ok");
						}catch(Exception e) {
							System.out.println("Save Failure");
						}
					};
				}.start();
				System.out.println("doing.....");
				
				
			}
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
