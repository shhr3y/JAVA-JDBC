import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class Profile extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
		request.getRequestDispatcher("link.html").include(request, response);
		
		pw.print("<h1>Profile Page</h1>");
		
		Cookie ck[] = request.getCookies();
		
		if(ck==null)
		{
			pw.print("<h2>Please Login First</h2>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else
		{
			String value = ck[0].getValue();
			pw.print("<h2>Welcome To Profile</h2>");
			pw.print("<h3>"+value+"</h3>");
		}
		pw.close();
	}
	
	

}
