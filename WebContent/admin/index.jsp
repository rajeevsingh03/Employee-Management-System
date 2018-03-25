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

<%
String message1= (String) request.getAttribute("msg");
if(message1!=null)
out.println(" <p style='background-color:black; font-size:20px; color:white'><b>" + message1+"</b></p>"); %>

<%
String message2= (String) request.getAttribute("message2");
if(message2!=null)
out.println(" <p style='background-color:black; font-size:20px; color:white'><b>" + message2+"</b></p>"); %>


<br><br><br>

<a href="<%= request.getContextPath()%>/managerController?flag=newRegisteredEmployees"><button style="background-color:blue; color:white">List of Newly Registered Employees</button></a><br><br><br><br>
<a href="<%= request.getContextPath()%>/managerController?flag=listOfActiveEmployeesAndManagers"><button style="background-color:blue; color:white">List of Active Employees and Managers who are already registered</button></a><br><br><br><br>
<a href="<%= request.getContextPath()%>/updateProfileController?flag=updateOrganizationProfile"><button style="background-color:blue; color:white">Update Organization Profile</button></a><br><br><br><br>
<a href="<%= request.getContextPath()%>/assignController?flag=assignEmployeeUnderManager"><button style="background-color:blue; color:white">Assign an Employee Under Manager</button></a><br><br><br><br>
<a href="payrollystem.jsp"><button style="background-color:blue; color:white">Payroll System</button></a><br><br><br><br>
<a href="<%= request.getContextPath()%>/leaveRequestController?flag=carryforwardleaves"><button style="background-color:blue; color:white">Carry Forward Leaves</button></a><br><br><br><br>
 </center>




      
</body>
</html>