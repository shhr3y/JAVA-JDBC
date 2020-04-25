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

@WebServlet("/logout")
public class Logout extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
		request.getRequestDispatcher("link.html").include(request, response);
		
		pw.print("<h1>Logout Page</h1>");
		
		Cookie ck[] = request.getCookies();
		
		if(ck==null)
		{
			pw.print("<h2>You Allready Logout!!!</h2>");
		}
		else
		{
			Cookie ck1=new Cookie("uname", "");
			ck1.setMaxAge(0);  
	        response.addCookie(ck1); 
	        pw.print("<h2>You Are Successfully Logout!!!");
		}
		
		request.getRequestDispatcher("index.html").include(request, response);
		
		pw.close();
	}
	
	

}
