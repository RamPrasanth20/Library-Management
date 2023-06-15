package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Select_book {
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/library"; // table details
		String username = "root"; // MySQL credentials
		String password = "12345";
		Class.forName("com.mysql.jdbc.Driver"); // Driver name
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established successfully");
		System.out.println("Connection Closed....");
		return con;
	}
}
