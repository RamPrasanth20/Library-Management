package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class Login_admin {
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/library"; // table details
		String username = "root"; // MySQL credentials
		String password = "12345";
		String query = "select * from login_admin"; // query to be run
		Class.forName("com.mysql.jdbc.Driver"); // Driver name
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established successfully");
		System.out.println("Connection Closed....");
		return con;
	}
}
