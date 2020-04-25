package jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class J30 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhari2020","root","");
			System.out.println("Database Connect Success");

			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter First Name : ");
			String fname=sc.next();
			
			System.out.println("Enter Last Name : ");
			String lname=sc.next();
			
			System.out.println("Enter Fees : ");
			float fees=sc.nextFloat();
			
			CallableStatement cstmt=con.prepareCall("{call insert_stud(?,?,?)}");  
			
			cstmt.setString(1, fname);
			cstmt.setString(2, lname);
			cstmt.setFloat(3, fees);
			
			cstmt.execute();
			
			System.out.println("Student Register Success");
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
/*
 DELIMITER $$

DROP PROCEDURE IF EXISTS `bhari2020`.`insert_stud` $$
CREATE PROCEDURE `bhari2020`.`insert_stud` (fname1  varchar(20),lname1  varchar(20) ,fees1  float )
BEGIN

insert into student(fname,lname,fees) values(fname1,lname1,fees1);
END $$

DELIMITER ;

 * */

