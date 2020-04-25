<h3>welcome to index page</h3>  

<form action="process.jsp">  
Enter Name:<input type="text" name="tname" /><br/><br/>  
<input type="submit" value="Go"/>  
</form>  

<hr>

<%  
	session.setAttribute("user","VowTech IT TC!!!");  
%>  
<a href="process.jsp">visit</a>

  
<%  
Cookie ck=new Cookie("tname","abhishek");  
response.addCookie(ck);  
%>  
  
