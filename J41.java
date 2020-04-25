package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class J41 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/vow2020","root","root");
			System.out.println("Database Connect Success");

			String query = "select * From student where fname=? and pass=?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter User Name : ");
			String username=sc.next();
			
			System.out.println("Enter Password : ");
			String pass=sc.next();
			
			pstmt.setString(1, username);
			pstmt.setString(2, pass);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			//Database Change - executeUpdate()
			//Database Retrive - executeQuery()
			//id int rs.getInt()
			//fname string rs.getString()
			
			if(rs.next())
				System.out.println("Login Success!!!");
			else
				System.out.println("Login Failed!!!");
			
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
