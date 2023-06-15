package Library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.Books;
import Database.Login_admin;
import Database.Login_user;


@WebServlet("/Delete_books")
public class Delete_books extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
	       try 
	       {
	           int book_id  = Integer.parseInt(request.getParameter("Book_id"));
	           String book_name = request.getParameter("Book_name");
	           
	           Connection con = Books.initializeDatabase();

	           PreparedStatement pst = con.prepareStatement("Delete from book where bid=? and b_name=?");
	           pst.setInt(1,book_id);
	           pst.setString(2,book_name);
	           pst.executeUpdate();
	           response.sendRedirect("Display.jsp");

	       } catch (SQLException ex) {
	           Logger.getLogger(AddBooks.class.getName()).log(Level.SEVERE, null, ex);
	       } catch (ClassNotFoundException ex) {
	           Logger.getLogger(AddBooks.class.getName()).log(Level.SEVERE, null, ex);
	       }
		}

}
