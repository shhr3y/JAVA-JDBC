package jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class J37 
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
	                   
	        rowSet.moveToInsertRow();

	        // Set column values and insert
	        rowSet.updateInt("id", 13);
	        rowSet.updateString("fname", "AA");
	        rowSet.updateString("lname", "BB");
	        rowSet.updateFloat("fees",1000.4f);
	        rowSet.insertRow();
	        
	        System.out.println("Insert Success");
	       
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("Driver Problem : "+e);
		}
		catch (Exception e) 
		{
			System.out.println("SQL Problem : "+e);
		}
		
	}
}
