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
<%
String message= (String) session.getAttribute("msg1");
if(message!=null)
out.println("<p style='background-color:black; font-size:20px; color:white'><b>"+message +"</b></p>"); 
%>


<a href="<%= request.getContextPath()%>/directorycontroller?flag=displayPublicDirectory"><button style="background-color:maroon; color:white">1. Public Directories</button></a><br><br><br><br>
 <a href="<%= request.getContextPath()%>/directorycontroller?flag=displayPrivateDirectory"><button style="background-color:maroon; color:white">2. Private Directories</button></a><br><br><br><br>
 <a href="<%=request.getContextPath()%>/directorycontroller?flag=displayProtectedDirectory"><button style="background-color:maroon; color:white">3. Protected Directories</button></a><br><br><br><br>
 <a href="<%= request.getContextPath()%>/directorycontroller?flag=displayDefaultDirectory"><button style="background-color:maroon; color:white">4. Default Directories</button></a><br><br><br><br>
 </center>

</body>
</html>