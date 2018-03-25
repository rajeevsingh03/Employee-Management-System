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
			<%@include file="../user/managerheader.jsp" %>
	<%}%>
<center>
	<%
String m1=(String)request.getAttribute("m1");
if(m1 != null){
out.print("<p style='background-color:blue; color:white'>"+m1 +"</p>");
} %>

<%
String m2=(String)request.getAttribute("m2");
if(m2 != null){
out.print("<p style='background-color:blue; color:white'>"+m2 +"</p>");
} %>

<h2>List of Protected Directories</h2>

<table border="1px">
<tr>
<th>Directory Name</th>
<th>Permission Type</th>
<th>Created By</th>
<th>Allow Another Team Employee</th>
<th>Change Permission to Private
</tr>
<t:forEach items="${sessionScope.displayProtectedDirectory}" var="a">
<input type="hidden" name="directoryname" value="${a.directoryname}"/> 
<input type="hidden" name="createdby" value="${a.createdby}"/>
<tr>
<td><a href="<%= request.getContextPath()%>/directorycontroller?flag=gotofile&directoryname=${a.directoryname}">${a.directoryname}</a></td>
<td>${a.permissiontype}</td>
<td>${a.createdby}</td>
<td><a href="<%= request.getContextPath()%>/directorycontroller?flag=ateList2&directoryname=${a.directoryname}&createdby=${a.createdby}">Allow Another Team Employee</a></td>
<td><a href="<%=request.getContextPath() %>/assignController?flag=changeDefaultToPrivate&directoryname=${a.directoryname}&createdby=${a.createdby}">Change Permission to Private</a></td>
</tr>
</t:forEach>
<t:forEach items="${sessionScope.displayProtectedDirectory1}" var="a">
<input type="hidden" name="directoryname" value="${a.directoryname}"/> 
<input type="hidden" name="createdby" value="${a.createdby}"/> 

<tr>
<td><a href="<%= request.getContextPath()%>/directorycontroller?flag=gotofile&directoryname=${a.directoryname}">${a.directoryname}</a></td>
<td>${a.permissiontype}</td>
<td>${a.createdby}</td>
<td><a href="<%= request.getContextPath()%>/directorycontroller?flag=ateList2&directoryname=${a.directoryname}&createdby=${a.createdby}">Allow Another Team Employee</a></td>
<td><a href="<%=request.getContextPath() %>/assignController?flag=changeDefaultToPrivate&directoryname=${a.directoryname}&createdby=${a.createdby}">Change Permission to Private</a></td>	
</tr>
</t:forEach>
<t:forEach items="${sessionScope.ateList1}" var="a">
<input type="hidden" name="directoryname" value="${a.directoryname}"/> 
<input type="hidden" name="createdby" value="${a.createdby}"/> 

<tr>
<td><a href="<%= request.getContextPath()%>/directorycontroller?flag=gotofile&directoryname=${a.directoryname}">${a.directoryname}</a></td>
<td>${a.permissiontype}</td>
<td>${a.createdby}</td>
<td><a href="<%= request.getContextPath()%>/directorycontroller?flag=ateList2&directoryname=${a.directoryname}&createdby=${a.createdby}">Allow Another Team Employee</a></td>
<td><a href="<%=request.getContextPath() %>/assignController?flag=changeDefaultToPrivate&directoryname=${a.directoryname}&createdby=${a.createdby}">Change Permission to Private</a></td>	
</tr>
</t:forEach>
</table>

</center>




</body>
</html>