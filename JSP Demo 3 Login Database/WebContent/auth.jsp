<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Processing</title>
</head>
<body>
<%
	
	String name = request.getParameter("tname");
	String pwd = request.getParameter("tpwd");
	
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Load Success");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vowtech2020","root","");
		System.out.println("Database Connect Success");
		
		String query="select * from student where fname=? and pass=?";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, name);
		pstmt.setString(2, pwd);
		
		ResultSet rs = pstmt.executeQuery();	
		if(rs.next())
		{
			out.print("<h1>Login Success!!!</h1>");
			out.print("<h2>Your Name is "+name+"</h2>");
		}
		else
			out.print("<h1>Login Failed!!!</h1>");
	}
	catch (ClassNotFoundException e) 
	{
		System.out.println("Driver Problem : "+e);
	}
	catch (SQLException e) 
	{
		System.out.println("Database Problem : "+e);
	}
%>
</body>
</html>