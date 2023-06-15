<%@ page import="java.sql.*"%>
<%

    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;
    String url = "jdbc:mysql://localhost/library"; 
    String user = "root";
    String password = "12345";
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
        String query = "SELECT * FROM book";
        rs = stmt.executeQuery(query);
%><form action="SelectBook">
	<table border="1" cellpadding="5" align="center">
		<thead>
			<tr>
				<th>Checklist</th>
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
				<td><input type="checkbox" value='<%=rs.getInt("bid")%>' name="book"></td>
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
	<input type=submit>
</form>
<form action="Login.jsp">
	<button type=submit>Logout</button>
</form>
<%
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
%>
