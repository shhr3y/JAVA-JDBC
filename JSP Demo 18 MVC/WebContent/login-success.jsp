<%@page import="com.vowtech.LoginBean"%>  

<p>You are successfully logged in!</p>  
<%  
	LoginBean bean =(LoginBean) request.getAttribute("bean");

	out.print("Welcome, <b>"+bean.getName()+"</b>");  
%>  
