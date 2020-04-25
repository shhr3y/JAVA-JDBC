package jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class J29 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhari2020","root","");
			System.out.println("Database Connect Success");

			String query="select content from filetable where name=?";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Name : ");
			String name=sc.next();//pari
			
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println("File Found!!!");
				
				Clob c= rs.getClob(1);//1 means 1st column data  
				
				Reader r=c.getCharacterStream();              
	            
				System.out.println("Enter File Path U Want Save : ");
				String path = sc.next();//G:\classes\
				
				FileWriter fw=new FileWriter(path+"\\"+name+".txt");  
				              
				int i;  
				while((i=r.read())!=-1)  
						fw.write((char)i);  
				              
				fw.close();  
				System.out.println("File Download Success!!!");
			}
			else
				System.out.println("File Not Found!!!");
			
		  
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
			System.out.println("File Problem : "+e);
		}
	}
}
