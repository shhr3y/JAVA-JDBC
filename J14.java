package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class J14 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/vow2020","root","root");
			System.out.println("Database Connect Success");
			
			String query="insert into student (fname,lname,fees)values(?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			
			Scanner sc=new Scanner(System.in);
			String choice;
			do
			{
				System.out.println("Enter First Name : ");
				String fname=sc.next();
				
				System.out.println("Enter Last Name : ");
				String lname=sc.next();
				
				System.out.println("Enter Fees : ");
				float fees=sc.nextFloat();
				
				pstmt.setString(1, fname);
				pstmt.setString(2, lname);
				pstmt.setFloat(3, fees);
				
				pstmt.executeUpdate();
				
				System.out.println("Record Inserted Success!!!");
				
				System.out.println("Do U Want To Continue [Yes/No] : ");
				choice=sc.next();
				
			}while(choice.equalsIgnoreCase("Yes"));
			
			System.out.println("Exit!!!!");
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
