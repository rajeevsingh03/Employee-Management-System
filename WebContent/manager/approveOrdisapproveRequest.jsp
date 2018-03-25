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



<input type="hidden" name="leaveid" value="${a.leaveId}"/> 

<center>
<h2>Approve or Disapprove Employee's Leave Request</h2>
<table border="1px">
<tr>
<th>Leave Type</th>
<th>Leave Description</th>
<th>Date</th>
<th>Approve Leave Request</th>
<th>Disapprove Leave Request</th>
</tr>
<t:forEach items="${sessionScope.requestStatus1}" var="a">
<tr>
<td>${a.leaveType}</td>
<td>${a.leaveDescription}</td>
<td>${a.startdate}</td>
<td><a href="<%= request.getContextPath()%>/leaveRequestController?flag=approveLeaveRequest&leaveId=${a.leaveId}"><button>Approve Leave Request</button></a></td>
<td><a href="<%= request.getContextPath()%>/leaveRequestController?flag=disapproveLeaveRequest&leaveId=${a.leaveId}"><button>Disapprove Leave Request</button></a></td>

</tr>
</t:forEach>
</table>


</center>
</body>
</html>