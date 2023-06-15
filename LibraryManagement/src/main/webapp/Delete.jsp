<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Delete Books</title>
</head>
<body>
<form action="Delete_books">
	
	<h3>Enter the details of the Book</h3>
	<label> Book Id: </label>

	<input type="text" placeholder="Enter Book ID" name="Book_id" required>

	<label>Book Name: </label>

	<input type="text" placeholder="Enter Book name" name="Book_name" required>
	<br><input type="submit">
</form>
	
	
	<form action="Adminoption.jsp" >
	<button type="submit">Back</button>
	</form>

</body>

</html>