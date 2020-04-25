package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class J5 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/vow2020","root","root");
			System.out.println("Database Connect Success");
			
			Statement stmt = con.createStatement();
			
			String query ="create table student"
					+ "("
					+ "id int primary key auto_increment,"
					+ "fname varchar(20),"
					+ "lname varchar(20),"
					+ "fees float"
					+ ")" ;
		
			System.out.println(query);
			
			stmt.executeUpdate(query);
			
			System.out.println("Table Created Success!!!");
			
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
