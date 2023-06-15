<%@page import="java.util.Arrays"%>
<%@ page import="java.sql.*"%>
<%@page import="java.util.*"%>
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
	List<Integer> list= (List<Integer>) request.getAttribute("list");
	String query = "SELECT * FROM book where bid IN (";
	for(int i=0;i<list.size();i++){
		query+="?";
		if(i<list.size()-1){
			query+=",";
		}
		
	}
	query += ")";
	PreparedStatement statement = conn.prepareStatement(query);
	
	for(int i=0;i<list.size();i++){
		statement.setInt(i+1,list.get(i));
	}
	rs= statement.executeQuery();
%><form>
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
			<%
			
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("bid")%></td>
				<td><%=rs.getString("b_name")%></td>
				<td><%=rs.getString("b_author")%></td>
				<td><%=rs.getInt("book_price")%></td>
				<td><%=rs.getInt("book_pages")%></td>
				<td><%=rs.getInt("quantity")%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</form>
<form action="Select.jsp">
	<button type=submit>Back</button>
</form>
<form action="Login.jsp">
	<button type=submit>Logout</button>
</form>
<%
} catch (Exception e) {
e.printStackTrace();
} finally {
if (rs != null)
	rs.close();
if (stmt != null)
	stmt.close();
if (conn != null)
	conn.close();
}
%>
