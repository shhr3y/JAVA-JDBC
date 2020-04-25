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
<%
	
	
	out.print("<h1>Profile Page</h1>");
	
	
	String name =(String)pageContext.getAttribute("uname",PageContext.SESSION_SCOPE);  
	
	if(!( name == null || name.equals("") ) )
	{
		
		out.print("<h2>Welcome To Profile</h2>");
		out.print("<h3>"+name+"</h3>");
	}
	else
	{
		out.print("<h2>Please Login First</h2>");
		request.getRequestDispatcher("login.html").include(request, response);
	}
%>
</body>
</html>