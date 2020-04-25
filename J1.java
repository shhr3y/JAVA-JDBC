package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class J1 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307","root","root");
			System.out.println("Database Connect Success");
			
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
 * java - > DataBase MySQL Oracle
 create databa bhari2020;

drop database bhari2020;

use bhari2020;

create table student
(
  id int primary key auto_increment,
  fname varchar(20),
  lname varchar(20),
  fees float
);

desc student;
describe student;
insert into student (fname,lname,fees)values('Shreya','Made',9000);

SELECT * FROM student;

 * */
