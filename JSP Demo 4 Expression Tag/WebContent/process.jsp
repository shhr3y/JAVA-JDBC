<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String name= request.getParameter("tname");
	String country= request.getParameter("tcountry");
	out.print("<h1>Your Name is "+name+"</h1>");
	out.print("<h1>Your Country is "+country+"</h1>");
	
%>

<%="<h1>Your Name is "+ request.getParameter("tname")+"</h1>" %>
<%="<h1>Your Country is "+country+"</h1>" %>

</body>
</html>