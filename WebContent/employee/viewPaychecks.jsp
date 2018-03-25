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
			<%@include file="../user/employeeheader.jsp" %>
	<%}%>

<br><br><br><br>
<center>
<h3>General Pay Check Information</h3>
<table border="1px">
<tr>
<th>User Name</th>
<th>Salary Per Month</th>
<th>Year</th>
<th>Comments</th>
<th>Annual Salary</th>
</tr>
<t:forEach items="${sessionScope.displayPaychecks}" var="a">
<tr>
<td>${a.username}</td>
<td>${a.salarypermonth}</td>
<td>${a.year}</td>
<td>${a.comments}</td>
<td>${a.salary}</td>
</tr>
</center>
</t:forEach>
</table>
<br><br><br><br>
<h3>Additional Pay Check Information</h3>
<table border="1px">
<tr>
<th>User Name</th>
<th>Month</th>
<th>Bonus</th>
</tr>
<t:forEach items="${sessionScope.displayBonus}" var="a">
<tr>
<td>${a.username}</td>
<td>${a.month}</td>
<td>${a.bonus}</td>
</tr>
</center>
</t:forEach>
</table>


</body>
</html>