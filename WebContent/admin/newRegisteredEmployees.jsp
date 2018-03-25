<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("user_name")==null)
{
	response.sendRedirect("../user/index.jsp");	
}
%>
<%
		
		if(session.getAttribute("type")==null){
	%>
			<%@include file="../user/adminheader.jsp" %>
	<%}%>



<h3>List of Employees Registered</h3>
<table border="1px">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Address</th>
<th>City</th>
<th>State</th>
<th>Country</th>
<th>Phone Number</th>
<th>Email Address</th>
<th>User Name</th>
<th>User Type</th>
<th>Status ( Active/Inactive)</th>
</tr>
<t:forEach items="${sessionScope.find}" var="a">
<tr>
<td>${a.firstname}</td>
<td>${a.lastname}</td>
<td>${a.address}</td>
<td>${a.city}</td>
<td>${a.state}</td>
<td>${a.country}</td>
<td>${a.phone}</td>
<td>${a.email}</td>
<td>${a.user_name}</td>
<td>${a.usertype}</td>
<td>${a.status}</td>
</tr>
</t:forEach>
</table>      
</body>
</html>