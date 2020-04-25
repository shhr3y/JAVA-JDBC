<%@page import="com.vowtech.Calculator"%>

<jsp:useBean id="c" class="com.vowtech.Calculator"/>

<h1>Index Page</h1>

<%

	out.print("3 Cube is "+c.cube(3));

%>