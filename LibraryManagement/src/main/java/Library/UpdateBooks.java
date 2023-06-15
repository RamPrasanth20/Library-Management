package Library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Books;

@WebServlet("/UpdateBooks")
public class UpdateBooks extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
	       try {
	           int book_id  = Integer.parseInt(request.getParameter("book_id"));
	           String book_name = request.getParameter("book_name");
	           String book_author = request.getParameter("book_author");
	           int book_price=Integer.parseInt(request.getParameter("book_price"));
	           int book_pages = Integer.parseInt(request.getParameter("book_pages"));
	           int book_qty = Integer.parseInt(request.getParameter("book_qty"));
	           
	           Connection con = Books.initializeDatabase();

	           PreparedStatement pst = con.prepareStatement("update book SET b_name=?,b_author=?,book_price=?,book_pages=?,quantity=? where bid=?");
	           pst.setString(1, book_name);
	           pst.setString(2, book_author);
	           pst.setInt(3, book_price);
	           pst.setInt(4, book_pages);
	           pst.setInt(5, book_qty);
	           pst.setInt(6, book_id);
	           
	           pst.executeUpdate();
	  
	           response.sendRedirect("Display.jsp");
	           

	       } catch (SQLException ex) {
	           Logger.getLogger(AddBooks.class.getName()).log(Level.SEVERE, null, ex);
	       } catch (ClassNotFoundException ex) {
	           Logger.getLogger(AddBooks.class.getName()).log(Level.SEVERE, null, ex);
	       }
		}

}
