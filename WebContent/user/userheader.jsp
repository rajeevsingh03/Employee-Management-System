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
		
		if(session.getAttribute("type")=="admin"){
	%>
	<a href="../admin/index.jsp" style="float:left">
	<input type="button" value="Home" name="home" style="font-size:12pt;color:white;background-color:indigo;border:2px solid #336600;padding:3px"/>	
	</a>
<%} %>

	<%
		
		if(session.getAttribute("type")=="employee"){
	%>
	<a href="../employee/index.jsp" style="float:left">
	<input type="button" value="Home" name="home" style="font-size:12pt;color:white;background-color:indigo;border:2px solid #336600;padding:3px"/>	
	</a>
<%} %>

	<%
		
		if(session.getAttribute("type")=="manager"){
	%>
	<a href="../manager/index.jsp" style="float:left">
	<input type="button" value="Home" name="home" style="font-size:12pt;color:white;background-color:indigo;border:2px solid #336600;padding:3px"/>	
	</a>
<%} %>

<a href="<%=request.getContextPath()%>/loginController?flag=logout" style="float: right">
<input type="button" value="Log Out" name="logout" style="font-size:12pt;color:white;background-color:indigo;border:2px solid #336600;padding:3px"/>
</a>
<center>
<h2>
<%
String firstname=(String) session.getAttribute("firstname");
String lastname=(String) session.getAttribute("lastname");
out.print("Welcome, "+ firstname + " "+ lastname);
%>

</h2>
</center> 


</body>
</html>