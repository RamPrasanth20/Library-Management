package Library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Books;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

@WebServlet("/AddBooks")
public class AddBooks extends HttpServlet {
	int i;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
       try {
          

           int book_id  = Integer.parseInt(request.getParameter("book_id"));
           String book_name = request.getParameter("book_name");
           String book_author = request.getParameter("book_author");
           int book_price=Integer.parseInt(request.getParameter("book_price"));
           int book_pages = Integer.parseInt(request.getParameter("book_pages"));
           int book_qty = Integer.parseInt(request.getParameter("book_qty"));
           
           Connection con = Books.initializeDatabase();

           PreparedStatement pst = con.prepareStatement("insert into book values(?,?,?,?,?,?)");
           pst.setInt(1, book_id);
           pst.setString(2, book_name);
           pst.setString(3, book_author);
           pst.setInt(4, book_price);
           pst.setInt(5, book_pages);
           pst.setInt(6, book_qty);
           
           pst.executeUpdate();
  
           response.sendRedirect("Display.jsp");
           

       } catch (SQLException ex) {
           Logger.getLogger(AddBooks.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(AddBooks.class.getName()).log(Level.SEVERE, null, ex);
       }
	}

}
