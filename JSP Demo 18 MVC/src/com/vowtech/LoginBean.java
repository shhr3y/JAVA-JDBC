package com.vowtech;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBean 
{
	String name,password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean validate(Connection con) 
	{
		//name Kunal
		//password k123
		boolean flag=false;
		try
		{
			String query = "select * from student where fname=? and pass=?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				flag=true;
		}
		catch(SQLException e)
		{
			System.out.println("Error : " +e);
		}
		System.out.println(flag);
		return flag;
	}
	
}
