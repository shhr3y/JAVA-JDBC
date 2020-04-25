import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyConnectionListener implements ServletContextListener
{

	@Override
	public void contextInitialized(ServletContextEvent event) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vowtech2020","root","");
			System.out.println("Database Connect Success");
			
			ServletContext context = event.getServletContext();
			context.setAttribute("mycon", con);
			System.out.println("Success Database Connection");
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
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
