<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP TITLE</title>
</head>
<body>

<h1>JSP DEMO</h1>
<h2>Go Corona Go GO!!!!</h2>
<h2> Tags</h2>
<h3>1 Scriplet Tag - Java Code </h3>
<h3>2 Expression Tag - </h3>
<h3>3 Declaration Tag - </h3>

<%
	out.print("<h1>Current Date is :"+java.util.Calendar.getInstance().getTime() +"</h1>");
%>
</body>
</html>

