<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>
<title>Admin Options</title>
<style>
.button {
	border: none;
	color: white;
	padding: 20px 40px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.button1 {
	background-color: #008CBA;
	align-self: center;
} /* Blue */
.button2 {
	background-color: #008CBA;
	align-self: center;
} /* Blue */
.button3 {
	background-color: #008CBA;
	align-self: center;
} /* Blue */
.button4 {
	background-color: #008CBA;
	align-self: center;
} /* Blue */
</style>

</head>

<body>
	<form action="Addbooks.jsp" >
	<button type="submit" class="button button1" >Add Books</button>
    </form>
    <form action="Display.jsp" >
	<button type="submit" class="button button2">View Books</button>
	</form>
	<form action="Update.jsp" >
	<button type="submit" class="button button3">Update Books</button>
	</form>
	<form action="Delete.jsp" >
	<button type="submit" class="button button4">Delete Books</button>
	</form>
	<form action="Login.jsp" >
	<button type="submit">Back</button>
	</form>
</body>

</html>