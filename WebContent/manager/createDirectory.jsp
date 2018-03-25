<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1>Create Directory</h1>
        <form method="post" action="<%= request.getContextPath() %>/directorycontroller?flag=add">
                    
                    <br>Directory Name: (Must be Unique) <br><br><input type="text" name="directoryname" />
 	                   <br><br>
 					Permission Type:
 		              <br><br>	<select name=permissiontype>
  
  						 <option>Public</option>
  						 <option>Private</option>
  						 <option>Default</option>
  						 <option>Protected</option>
  
						</select>
						<br><br>
					    <input type="submit" value="Create">
                    </form>
</center>
</body>
</html>