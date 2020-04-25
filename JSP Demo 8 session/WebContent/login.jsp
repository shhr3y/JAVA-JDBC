<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="link.html" %>  

<%!
	Connection con=null;
	String query="select * from student where fname=? and pass=?";
	PreparedStatement pstmt=null;
%>

<%
	out.print("<h1>Auth Processing</h1>");
	
	String name = request.getParameter("tname");
	String pwd = request.getParameter("tpwd");
	
	ServletContext context =getServletContext();
	
	con =(Connection) context.getAttribute("mycon");
	
	if(con==null)
	{
		out.print("<h1>Database Connection Failed</h1>");
		out.print("<h1>Please Connect Database First</h1>");
		out.print("<a href='index.html'>Click Here For Database Connect</a>");
		return;
	}
	
	try
	{
		pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, name);
		pstmt.setString(2, pwd);
		
		ResultSet rs = pstmt.executeQuery();	
		
		if(rs.next())
		{
			session.setMaxInactiveInterval(1*60);
			session.setAttribute("uname", "Candidate is "+name);
			out.print("<h1>Login Success</h1>");
			out.print("<h2>Welcome , "+name+"</h2>");
		}
		else
		{
			out.print("<h1>Login Failed-UserName & Password Mismatch!!!</h1>");
		%>	
			<%@ include file="login.html" %>		
		<% 
			
		}
	}
	
	catch (SQLException e) 
	{
		System.out.println("Database Problem : "+e);
	}
%>
</body>
</html>