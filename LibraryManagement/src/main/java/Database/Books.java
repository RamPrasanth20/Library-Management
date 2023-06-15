package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Books {
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/library"; // table details
		String username = "root"; // MySQL credentials
		String password = "12345";
		String query = "select * from book"; // query to be run
		Class.forName("com.mysql.jdbc.Driver"); // Driver name
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}
}
