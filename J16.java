package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class J16 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/vow2020","root","root");
			System.out.println("Database Connect Success");
			
			String query = "update student set fees=? where id=?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter ID : ");
			int id=sc.nextInt();
			
			System.out.println("Enter Fees : ");
			float fees=sc.nextFloat();
			
			pstmt.setFloat(1, fees);
			pstmt.setInt(2, id);
			
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
