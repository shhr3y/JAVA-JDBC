package jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class J27_2 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("Database Connect Success");
			

			String query="select photo from imgtable where name=?";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Name : ");
			String name=sc.next();//pari
			
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println("Image Found!!!");
				
				Blob b= rs.getBlob(1);//1 means 1st column data  
				
				byte barr[]=b.getBytes(1 , (int)b.length() );//1 means first image  
				              
				System.out.println("Enter File Path U Want Save : ");
				String path = sc.next();//G:\classes\
				
				FileOutputStream fout=new FileOutputStream(path+"\\"+name+".jpg");//G:\classes\Pari.jpg
				fout.write(barr);  
				fout.close();  
				System.out.println("File Download Success!!!");
			}
			else
				System.out.println("Image Not Found!!!");
			
		  
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
