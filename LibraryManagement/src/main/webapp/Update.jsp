<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Books</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/UpdateBooks" >
		<div data-validate="Book Id is required">
			<span>Book Id:</span> <input type="text" name="book_id"
				placeholder="Enter Book Id" required>
		</div>

		<div data-validate="Book name is required">
			<span>Book Name:</span> <input type="text" name="book_name"
				placeholder="Enter Book name" required>
		</div>

		<div class="wrap-input100 validate-input"
			data-validate="Book author name is required">
			<span class="label-input100">Author:</span> <input class="input100"
				type="text" name="book_author" placeholder="Enter Book author name"
				required> <span class="focus-input100"></span>
		</div>
		<div class="wrap-input100 validate-input"
			data-validate="Book Price is required">
			<span class="label-input100">Price:</span> <input class="input100"
				type="text" name="book_price" placeholder="Enter Book price"
				required> <span class="focus-input100"></span>
		</div>
		<div class="wrap-input100 validate-input"
			data-validate="Number of pages is required">
			<span class="label-input100">Page Number:</span> <input
				class="input100" type="text" name="book_pages"
				placeholder="Enter number of pages in book" required> <span
				class="focus-input100"></span>
		</div>

		<div class="wrap-input100 validate-input"
			data-validate="Book Quantity is required">
			<span class="label-input100">Quantity:</span> <input class="input100"
				type="text" name="book_qty" placeholder="Enter Book quantity"
				required> <span class="focus-input100"></span>
		</div>
		<div>
			<button>
				<span> Submit <i aria-hidden="true"></i>
				</span>
			</button>
		</div>
	</form>
	<form action="Adminoption.jsp">
		<button type="submit">
			 Back
		</button>
	</form>
</body>
</html>