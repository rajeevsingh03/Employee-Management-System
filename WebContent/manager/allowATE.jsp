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
<h1>Allow Another Team Employee</h1>


	


<t:forEach items="${sessionScope.List123 }" var="a">

        <form method="post" action="<%= request.getContextPath() %>/directorycontroller?flag=ate">
                    
                    <input type="hidden" name="createdby" value="${a.createdby }"/>
                    <input type="hidden" name="permissiontype" value="${a.permissiontype }"/>
                    <br>Directory Name:  <br><br><input type="text" name="directoryname" value="${a.directoryname }" readonly/>
 	                   <br><br>
 	                  
 	                  
 	                   Select Team Employee:
 	                   <br><br>
 	                   <select name="ateusername">
 	                   <t:forEach items="${sessionScope.ateList }" var="a">
 	                   		<option value="${a}">${a}</option>
 	                   </t:forEach>
 	                   </select>
 	                  
 	                  
 					<br><br>
					    <input type="submit" value="Change">
					   
                    </form>
                   </t:forEach>
</center>
</body>
</html>