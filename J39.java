package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class J39 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bhari2020","root","root");
			System.out.println("Database Connect Success");
			
			String query = "select * From student where fname=? and pass=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter User Name : ");
			String uname=sc.next();
			
			System.out.println("Enter Password : ");
			String pass=sc.next();
			
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				//System.out.println("Id : " + rs.getInt("id")+" , First Name : "+rs.getString(2)+" , Last Name : "+
				//					rs.getString(3)+" , Fees : "+rs.getFloat(4));
				System.out.println("Usename Login Success!!!");
			else
				System.out.println("Usename and Password Missmatch!!!");
			
			
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
