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



 <body bgcolor="white">
 <t:forEach items="${sessionScope.updateProfile }" var="a">
        <form action="<%= request.getContextPath() %>/updateProfileController?flag=updateProfile1" method="post">
        
        <input type="hidden" name="user_name" value="${a.user_name }">
            <center>
                <table border="2" bgcolor="white" style="color:black"> 
 				<tbody style="font-size: 30px !important;">
                    <tr>
                        <td>
                            <b>First Name:</b>
                        </td>
                        <td>
                            <input type="text" name="firstname" value="${a.firstname } readonly/">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Last Name:</b>
                        </td>
                        <td>
                            <input type="text" name="lastname" value="${a.lastname }">
                        </td>
                    </tr>
                     <tr>
                        <td>
                            <b>Address</b>
                        </td>
                        <td>
                            <input type="text" name="address" value="${a.address }">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>City</b>
                        </td>
                        <td>
                            <input type="text" name="city" value="${a.city }">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>State</b>
                        </td>
                        <td>
                            <input type="text" name="state" value="${a.state }">
                        </td>
                    </tr>
                   <tr>
                        <td>
                            <b>Country:</b>
                        </td>
                        <td>
                            <input type="text" name="country" value="${a.country }">
                        </td>
                    </tr>   
                    <tr>
                        <td>
                            <b>Phone No:</b>
                        </td>
                        <td>
                            <input type="text" name="phone" value="${a.phone }">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Email-ID:</b>
                        </td>
                        <td>
                            <input type="text" name="email" value="${a.email }">
                        </td>
                    </tr>
                                       <tr>
                        <td>
                            <b>Password:</b>
                        </td>
                        <td>
                            <input type="password" name="password" value="${a.password }">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Update">
                        </td>
                        <td>
                            <input type="reset" value="Reset">
                        </td>
                    </tr>
                    </tbody>
                </table>
                </center>
        </form>
        </t:forEach>
</body>
</html>