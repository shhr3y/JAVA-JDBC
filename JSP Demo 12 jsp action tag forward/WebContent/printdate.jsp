<%@ taglib prefix="vow" uri="WEB-INF/firsttag.tld"%>
 
<html>
	<head>
		<title>custom tag example</title>
	</head>
	<body>
		
		<%="<h1>"+request.getParameter("tname")+"</h1>" %>
		<vow:mydate/>
		
		
	</body>
</html>
