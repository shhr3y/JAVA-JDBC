package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class J13 
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
			
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter ID : ");
			int id=sc.nextInt();
			
			String query = "select * From student where id="+id;
			System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query);
			//Database Change - executeUpdate()
			//Database Retrive - executeQuery()
			//id int rs.getInt()
			//fname string rs.getString()
			
			if(rs.next())
				System.out.println("Id : " + rs.getInt("id")+" , First Name : "+rs.getString(2)+" , Last Name : "+
									rs.getString(3)+" , Fees : "+rs.getFloat(4));
			else
				System.out.println("Record Not Found!!!");
			
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
