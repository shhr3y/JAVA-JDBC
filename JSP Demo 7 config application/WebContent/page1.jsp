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

	out.print("<h1>Page1</h1>");
	
	
	String configvalue =  config.getInitParameter("adv");
	out.print("Config Seaparate Value is <b>"+configvalue+"</b><br>");
	
	String contextvalue1 =  application.getInitParameter("class");
	out.print("Context Common Value is <b>"+contextvalue1+"</b><br>");
	

%>
</body>
</html>