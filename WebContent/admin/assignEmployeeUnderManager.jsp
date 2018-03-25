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



<center>
<form action="<%= request.getContextPath() %>/assignController?flag=assign" method="post">
List of Managers :
<select name="managername">
  <t:forEach items="${sessionScope.managerList}" var="a">
   <option value="${a.firstname }">${a.firstname}</option>
  </t:forEach>
</select>
<br><br>
List of Employees :
<select name="employeename">
  <t:forEach items="${sessionScope.employeeList}" var="b">
   <option value=${b.firstname }>${b.firstname}</option>
  </t:forEach>
</select>
<br><br>

<input type="submit" value="Assign">
</form>
</center>
</body>
</html>