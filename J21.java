package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class J21 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Load Success");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/vow2020","root","root");
			System.out.println("Database Connect Success");
			
			String query = "select * From student";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//MetaData Data About Data
			
			ResultSet rs = pstmt.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("Table Name is "+rsmd.getTableName(1).toUpperCase());
			
			System.out.println("Number Of Columns are : " + rsmd.getColumnCount());
			
			for(int i=1;i<=rsmd.getColumnCount();i++)//2<=5
				System.out.println("Column Name is "+rsmd.getColumnName(i).toUpperCase() +""
						+ " & Data Type is "+rsmd.getColumnTypeName(i));
		
			System.out.println("\n\n");
			
			for(int i=1;i<=rsmd.getColumnCount();i++)
				System.out.print(rsmd.getColumnName(i).toUpperCase()+"\t");
			//ID	FNAME	LNAME	FEES	PASS
			//
			System.out.println();
			
			while(rs.next())
			{
				for(int i=1;i<=rsmd.getColumnCount();i++)//2<=5
					System.out.print(rs.getString(i)+"\t");//1	Yogesh	Jagtap	9000 y123
				
				System.out.println();
				
				//1	Shreya	Made	9000
				//
			}
			//No. Columns 1Lac 
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
