<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Books</title>
</head>
<body>
	<%
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;
    String url = "jdbc:mysql://localhost/library"; // replace with your database URL
    String user = "root"; // replace with your database username
    String password = "12345"; // replace with your database password
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
        String query = "SELECT * FROM book";
        rs = stmt.executeQuery(query);
        %>
	<table border="1" cellpadding="5" align="center">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Author</th>
				<th>Price</th>
				<th>Page</th>
				<th>Quantity</th>
			</tr>
		</thead>
		<tbody>
			<% while(rs.next()) { %>
			<tr>
				<td><%= rs.getInt("bid") %></td>
				<td><%= rs.getString("b_name") %></td>
				<td><%= rs.getString("b_author") %></td>
				<td><%= rs.getInt("book_price") %></td>
				<td><%= rs.getInt("book_pages") %></td>
				<td><%= rs.getInt("quantity") %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	<form action="Adminoption.jsp">
		<button type="submit">
			 Back
		</button>
	</form>
	<%
    }
    catch (Exception e) {
        e.printStackTrace();
    } 
    finally {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
%>
</body>
</html>
