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
<h4>Upload a File</h4>
        <form method="post" action="<%=request.getContextPath() %>/payrollController?flag=generate">
            
   		<h2>Select Employee :</h2>
   	<br><br>
			<select name="employeename">
			  <t:forEach items="${sessionScope.displayActiveList}" var="a">
			   <option value="${a.user_name }">${a.firstname}, ${a.lastname}, ${a.user_name}</option>
			  </t:forEach>
			</select>
   		            
       <br><br> <h2>Enter Time Period: (Please select Period of One Year Only)</h2>
      	
       				<h3>Enter Year:</h3>  <br><input type="tex"' name="year"/>
       					
           <br> <h3>Enter Salary:</h3>
           			<br>	<input type="text" name="salary"/>
           	
           	<br> <h3>Comments/Feedback:</h3>
           			<br>	<textarea name="comments"></textarea>
           	<br>			
                        <h3><input type="submit" value="Generate"></h3>
           
</form>
</center>

</body>
</html>