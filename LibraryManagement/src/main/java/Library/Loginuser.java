package Library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;

import Database.Login_admin;
import Database.Login_user;

@WebServlet("/Loginuser")
public class Loginuser extends HttpServlet {
	String user;
	String user_pass;
	String admin;
	String pass;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	try {
    		PrintWriter out= response.getWriter();
            String n=request.getParameter("Username");
            String pwd=request.getParameter("Password");
            String type=request.getParameter("Loginoption");
            if(type.equals("UserLogin")) {
            	Connection con_user=Login_user.initializeDatabase();
                java.sql.Statement st1=con_user.createStatement();
                ResultSet us=st1.executeQuery("Select * from login_user");
                while(us.next()) {
                	user=us.getString(1);
                	user_pass=us.getString(2);
                }
    			if (n.equals(user) && pwd.equals(user_pass)) {
    				out.println("Login successfull");
    				HttpSession hs = request.getSession();
    				hs.setAttribute("username", n);
    				response.sendRedirect("Select.jsp");
    			}

    			else {
    				out.println("<font color=red size=14 face=verdana>Invalid Username or password...Try Again!</font>");
    				// response.sendRedirect("login.jsp");
    				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
    				rd.include(request, response);

    			}
            }
            else {
            	Connection con=Login_admin.initializeDatabase();
                java.sql.Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("Select * from login_admin");
                while(rs.next()) {
                	admin=rs.getString(1);
                	pass=rs.getString(2);
                }
                if(n.equals(admin)&&pwd.equals(pass)) {
                    response.sendRedirect("Adminoption.jsp");
                }

     

                else {
                    out.println("<font color=red size=8>Invalid Username or password...Try Again!</font>");
                    //response.sendRedirect("login.jsp");
                    RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
                    rd.include(request,response);

                }
            }
    	}
    	catch(Exception e) {
    		
    	}
    }

}