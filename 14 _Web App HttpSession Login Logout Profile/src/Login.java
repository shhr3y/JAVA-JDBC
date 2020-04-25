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
import javax.servlet.http.HttpSession;

@WebServlet("/auth")
public class Login extends HttpServlet
{
	PreparedStatement  pstmt;
	@Override
	public void init() throws ServletException 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vowtech2020","root","");
			System.out.println("Database Connect Success");
			
			String query="select * from student where fname=? and pass=?";
			
			pstmt = con.prepareStatement(query);
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("Driver Problem : "+e);
		}
		catch (SQLException e) 
		{
			System.out.println("Database Problem : "+e);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
		request.getRequestDispatcher("link.html").include(request, response);
		
		pw.print("<h1>Auth Processing</h1>");
		
		String name = request.getParameter("tname");
		String pwd = request.getParameter("tpwd");
		
		try
		{	
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();	
			
			if(rs.next())
			{
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(1*60);
				session.setAttribute("uname", "Candidate is "+name);
				pw.print("<h1>Login Success</h1>");
				pw.print("<h2>Welcome , "+name+"</h2>");
			}
			else
			{
				pw.print("<h1>Login Failed-UserName & Password Mismatch!!!</h1>");
				request.getRequestDispatcher("index.html").include(request, response);
				
			}
		}
		
		catch (SQLException e) 
		{
			System.out.println("Database Problem : "+e);
		}
		
		
		
		pw.close();
	}
	
	

}
