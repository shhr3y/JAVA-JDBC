package jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class J35 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
	        
			JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet(); 
	        
	        rowSet.setUrl("jdbc:mysql://localhost:3306/bhari2020");  
	        rowSet.setUsername("root");  
	        rowSet.setPassword("");  
	                   
	        rowSet.setCommand("select * from student");  
	        rowSet.execute();  
	                   
	        while (rowSet.next()) 
	        {	  
	                        // Generating cursor Moved event  
	                        System.out.print("Id : " + rowSet.getString(1));  
	                        System.out.print(" , Fist Name : " + rowSet.getString(2));  
	                        System.out.print(" , Last Name : " + rowSet.getString(3));
	                        System.out.println(" , Fees : " + rowSet.getString(4));
	        }  
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("Driver Problem : "+e);
		}
		catch (Exception e) 
		{
			System.out.println("Driver Problem : "+e);
		}
		
	}
}
