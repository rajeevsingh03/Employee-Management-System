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



<%
String message= (String) request.getAttribute("msg");
if(message!=null)
out.println(" " + message); %>


<%
String error=(String)request.getAttribute("error1");
if(error != null){
out.print("<p style='background-color:green; font-size:24px; color:white'><b>"+error +"</b></p>");
} %>

 <center>
 
 <a href="leaveRequest.jsp"><button style="background-color:maroon; color:white">Request for Leave</button></a><br><br><br><br>
 <a href="<%= request.getContextPath()%>/leaveRequestController?flag=displayRequests"><button style="background-color:maroon; color:white">See Request Status</button></a><br><br><br><br> 
 <a href="<%=request.getContextPath()%>/registrationController?flag=updateProfile&user_name=<%=session.getAttribute("user_name")%>"><button style="background-color:maroon; color:white">Update Profile</button></a><br><br><br><br>
 <a href="viewDirectory.jsp"><button style="background-color:maroon; color:white">View Directory</button></a><br><br><br><br>
 <a href="<%= request.getContextPath()%>/payrollController?flag=displayPaychecks"><button style="background-color:maroon; color:white">Paychecks</button></a><br><br><br><br>
</center>
</body>
</html>