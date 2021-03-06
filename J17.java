package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class J17 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/vow2020","root","root");
			System.out.println("Database Connect Success");
			
			String query = "update student set fname=? , lname=? where id=?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter ID : ");
			int id=sc.nextInt();
			
			System.out.println("Enter First Name : ");
			String fname=sc.next();
			
			System.out.println("Enter Last Name : ");
			String lname=sc.next();
			
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setInt(3, id);
			
			pstmt.executeUpdate();
			
			System.out.println("Record Updated Success!!!");
			
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
