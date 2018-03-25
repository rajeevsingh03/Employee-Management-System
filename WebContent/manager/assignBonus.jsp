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
<h4>Assign Bonus</h4>
        <form method="post" action="<%=request.getContextPath() %>/payrollController?flag=assignBonus1">
            
   		<h2>Select Employee :</h2>
   	<br><br>
			<select name="employeename">
			  <t:forEach items="${sessionScope.assignBonusList}" var="a">
			   <option value="${a.user_name }">${a.firstname}, ${a.user_name}</option>
			  </t:forEach>
			</select>
			
			<h2>Select Month :</h2>
   	<br><br>
   		    <select name="month">
			  
			   <option>January</option>
			   <option>February</option>
			   <option>March</option>
			   <option>April</option>
			   <option>May</option>
			   <option>June</option>
			   <option>July</option>
			   <option>August</option>
			   <option>September</option>
			   <option>October</option>
			   <option>November</option>
			   <option>December</option>
			   <option></option>
			</select>
   		            
          <br> <h3>Enter Bonus:</h3>
           			<br>	<input type="text" name="bonus"/>
                        
                        
                        <h3><input type="submit" value="Generate"></h3>
           
</form>
</center>

</body>
</html>