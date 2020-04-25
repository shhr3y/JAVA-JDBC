package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class J26 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/vow2020","root","root");
			System.out.println("Database Connect Success");

			String query="insert into imgtable(name,photo) values( ? , ? )";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Name : ");
			String name=sc.next();
			
			System.out.println("Enter Iamge Path : ");
			String path=sc.next();
			
			FileInputStream fin=new FileInputStream(path);
			
			
			pstmt.setString(1, name);
			pstmt.setBinaryStream(2,fin,fin.available());  
			
			int i = pstmt.executeUpdate();  
			
			System.out.println(i+" Image Uploaded Success");  
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
		catch (IOException e) 
		{
			System.out.println("File Read Problem : "+e);
		}
	}
}
