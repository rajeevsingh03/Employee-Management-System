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



 <body bgcolor="white">
 <t:forEach items="${sessionScope.updateOrganizationProfile }" var="a">
        <form action="<%= request.getContextPath() %>/updateProfileController?flag=updateProfile3" method="post">
        
        <input type="hidden" name="user_name" value="${a.user_name }">
            <center>
            <input type="hidden" name="username" value="${a.user_name }">
                            <br><br><b>First Name:</b>
                            <input type="text" name="firstname" value="${a.firstname }" readonly>
                            <br><br><b>Last Name:</b>
                            <input type="text" name="lastname" value="${a.lastname }"  readonly>
                       
                            <br><br><b>Division Name:</b>
                            <input type="text" name="divisionname" value="${a.divisionname }">
                            <br><br><b>Role:</b>
                            <input type="text" name="role" value="${a.role }">
                           <br><br>  <b>Under the Supervision:</b>
                           <select name="managername">
								  <t:forEach items="${sessionScope.managerList}" var="x">
								   <option value="${x.firstname }">${x.firstname}</option>
								  </t:forEach>
								</select>
								                            
                            <br><br><input type="submit" value="Update">
                            <input type="reset" value="Reset">
                </center>
        </form>
        </t:forEach>
</body>
</html>