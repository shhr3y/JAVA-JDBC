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
import java.sql.Types;
import java.util.Scanner;

public class J31 
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
			
			System.out.println("Enter First Number : ");
			int no1=sc.nextInt();
			
			System.out.println("Enter Second Number : ");
			int no2=sc.nextInt();
			
			
			CallableStatement stmt=con.prepareCall("{?= call get_sum(?,?)}");  
			stmt.setInt(2,no1);  
			stmt.setInt(3,no2);
			
			stmt.registerOutParameter(1,Types.INTEGER);  
			
			stmt.execute();  
			  
			System.out.println("Sum : " + stmt.getInt(1));  

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

