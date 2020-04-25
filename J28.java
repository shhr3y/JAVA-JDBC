package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class J28 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhari2020","root","");
			System.out.println("Database Connect Success");

			String query="insert into filetable(name,content) values( ? , ? )";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Name : ");
			String name=sc.next();
			
			System.out.println("Enter File Path : ");
			String path=sc.next();
			
			File f=new File(path);  
			FileReader fr=new FileReader(f);  

			
			pstmt.setString(1, name);
			pstmt.setCharacterStream(2,fr,(int)f.length());  
			
			int i = pstmt.executeUpdate();  
			
			System.out.println(i+" File Uploaded Success");  
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
