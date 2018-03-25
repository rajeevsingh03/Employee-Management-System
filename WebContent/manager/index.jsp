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

		
		
			<%@include file="../user/managerheader.jsp" %>
	


<center>

<% 

String message= (String) session.getAttribute("msg");
if(message!=null)
out.println("<p style='background-color:black; font-size:20px; color:white'><b>"+message +"</b></p>"); %>
<%
String error1=(String)request.getAttribute("error");
if(error1 != null){
out.print("<p style='background-color:green; font-size:24px; color:white'><b>"+error1 +"</b></p>");
} %>
 

 <a href="<%= request.getContextPath()%>/manager/leaveRequest.jsp"><button style="background-color:green; color:white">Request for Leave</button></a><br><br><br><br>
 <a href="<%=request.getContextPath()%>/registrationController?flag=updateProfile&user_name=<%=session.getAttribute("user_name")%>"><button style="background-color:green; color:white">Update Profile</button></a><br><br><br><br>
 <a href="createDirectory.jsp"><button style="background-color:green; color:white">Create Directory</button></a><br><br><br><br>
 <a href="<%= request.getContextPath()%>/leaveRequestController?flag=displayRequests"><button style="background-color:green; color:white">See Request Status</button></a><br><br><br><br>
 <a href="viewDirectory.jsp"><button style="background-color:green; color:white">View Directories</button></a><br><br><br><br>
 <a href="<%= request.getContextPath()%>/leaveRequestController?flag=displayRequests1"><button style="background-color:green; color:white">Approve or Disapprove Employee's Request</button></a><br><br><br><br>
 <a href="<%= request.getContextPath()%>/payrollController?flag=assignBonus"><button style="background-color:green; color:white">Assign Bonus</button></a><br><br><br><br>
 <a href="<%= request.getContextPath()%>/payrollController?flag=displayPaychecks"><button style="background-color:green; color:white">Paychecks</button></a><br><br><br><br>
 </center>
</body>
</html>