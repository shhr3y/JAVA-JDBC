<jsp:useBean id="u" class="com.vowtech.User" />
<jsp:setProperty property="*" name="u" />


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String data=u.getName()+" - VowTech";
%>
<body>
	Record:
	<br>
	<jsp:getProperty property="name" name="u" /><br>
	<jsp:getProperty property="password" name="u" /><br>
	<jsp:getProperty property="email" name="u" /><br>

	<jsp:setProperty property="name" name="u" value="<%=data %>"/>
	

	Record:
	<br>
	<jsp:getProperty property="name" name="u" /><br>
	<jsp:getProperty property="password" name="u" /><br>
	<jsp:getProperty property="email" name="u" /><br>
	

</body>
</html>