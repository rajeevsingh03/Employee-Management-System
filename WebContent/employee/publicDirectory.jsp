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

<center>
<h2>List of Public Directories</h2>
 
<table border="1px">
<tr>
<th>Directory Name</th>
<th>Permission Type</th>
<th>Created By</th>
<th>Change Permission</th>
</tr>
<t:forEach items="${sessionScope.displayDirectory}" var="a">
<input type="hidden" name="directoryname" value="${a.directoryname}"/>
<input type="hidden" name="createdby" value="${a.createdby}"/>
<tr>
<td><a href="<%= request.getContextPath()%>/directorycontroller?flag=gotofile&directoryname=${a.directoryname}">${a.directoryname}</a></td>
<td>${a.permissiontype}</td>
<td>${a.createdby}</td>
</tr>
</t:forEach>
</table>
</center>

</body>
</html>