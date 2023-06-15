package Library;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SelectBook")
public class SelectBook extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String languages[] = request.getParameterValues("book");
		List<Integer> book=new ArrayList<>();
		if(languages!=null) {
			for(String lang:languages) {
				book.add(Integer.parseInt(lang));
			}
		}
		request.setAttribute("list", book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Listedbooks.jsp");
		dispatcher.forward(request, response);
//		out.print("<body><h4>Books:</h4></body>");
//		for(int i=0;i<book.size();i++) {
//			out.println("<html><head><meta charset='UTF-8'><title></title></head>"
//
//		+ "<body> <algin=center>"
//		+book.get(i)+"<br>"
//		+"</body></html>");
//		}
//		out.println("<form action='Select.jsp'><button type='submit'>Back</form>"
//		+"<form action='Login.jsp'><button type='submit'>Logout</form>");
	}


}
