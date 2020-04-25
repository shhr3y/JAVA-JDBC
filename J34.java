package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class J34 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhari2020","root","");
			System.out.println("Database Connect Success");
			
			con.setAutoCommit(false);
			
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
				
				pstmt.addBatch();
				
				System.out.println("Do U Want To Continue [Yes/No] : ");
				choice=sc.next();
				
			}while(choice.equalsIgnoreCase("Yes"));
			
			int nor[] = pstmt.executeBatch();
			
			System.out.println("Do U Want To Commit or Rollback : ");
			String action=sc.next();
			if(action.equalsIgnoreCase("commit"))
			{
				con.commit();
				System.out.println(nor.length + " Records Inserted Success!!!");
			}
			else if(action.equalsIgnoreCase("rollback"))
			{
				con.rollback();
				System.out.println("Record Failed Success!!!");
			}
			
			
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
