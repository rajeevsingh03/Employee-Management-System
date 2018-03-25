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
<h4>Upload a File</h4>
        <form method="post" action="<%=request.getContextPath() %>/fileController" enctype="multipart/form-data">
            
      	Choose File : <input type="file" name="file" size="50"/>
                    
       <br><br> Description: <br><br><textarea name="description" cols="70"  rows="3" ></textarea>
                        <br><br>
                        <br><br>
                        <input type="submit" value="Upload">
            
</form>
</center>

<center>
<t:forEach items="${sessionScope.directorydetails}" var="a">

<table border="1px">
<br><br>
<tr>
<th>File Name</th>
<th>Description</th>
<th>Directory Name</th>
</tr>

<tr>
<td><a href="downloadFiles.jsp?id=${a.id}">${a.filename}</a></td>
<td>${a.description}</td>
<td>${a.directoryname}</td>
</tr>
</t:forEach>
</table>
</center>

</body>
</html>