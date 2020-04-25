package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class J23 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/vow2020","root","root");
			System.out.println("Database Connect Success");

			DatabaseMetaData dbmd = con.getMetaData();
			
			String table[]={"TABLE"};  
			
			ResultSet rs=dbmd.getTables(null,null,null,table);  
			  
			while(rs.next())
				System.out.println(rs.getString(1)+" - "+rs.getString(4)+" - "+rs.getString(3));  
			


			
			con.close();
			
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
}
