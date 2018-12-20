package controlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	public static Connection conn;
	public static String url = "jdbc:mysql://localhost:3306/hotel";
	public static String user = "root";
	public static String password = "";

	public static Connection getInstance() {
		if (conn == null) {
			try {
				// Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				System.out.println("For name ERR");
			}
			try {
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("Connecttion secced");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Connction ERR");
			}
		}
		return conn;
	}

}
