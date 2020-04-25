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
	/*Service - Each Time*/
	name= request.getParameter("tname");
	country= request.getParameter("tcountry");
	num  = Integer.parseInt(request.getParameter("tnum"));
	out.print("<h1>Your Name is "+name+"</h1>");
	out.print("<h1>Your Country is "+country+"</h1>");
	
	
%>

<%="<h1>Your Name is "+ request.getParameter("tname")+"</h1>" %>
<%="<h1>Your Country is "+country+"</h1>" %>

<%
	int c = getCube(num);
	out.print("<h2>"+num+" Cube is "+getCube(num)+".</h2>");
%>


<%!
	/*Only One Time Call - First init() */
	String name,country;
	
	int num;

	int getCube(int num)
	{
		return num*num*num;
	}
	
%>

</body>
</html>