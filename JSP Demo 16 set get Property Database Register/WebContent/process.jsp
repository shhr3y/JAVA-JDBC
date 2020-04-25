<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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

<body>
	<%
		Connection con = (Connection)application.getAttribute("mycon");
	
		String query = "insert into student (fname,lname,fees,pass)values(?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, u.getFname());
		pstmt.setString(2, u.getLname());
		pstmt.setFloat(3, u.getFees());
		pstmt.setString(4, u.getPass());
		
		int i = pstmt.executeUpdate();
		
		if(i > 0)
			out.print("<h1>Register Success!!!</h1>");
		else
			out.print("<h1>Register Failed!!!</h1>");
	%>

</body>
</html>