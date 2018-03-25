<%@page import="DAO.fileDAO"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
   <%@page import="VO.*" %>

<%@ page import="java.io.*"%>
    
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
Blob image = null;
byte[ ] imgData = null ;
try {
fileDisplayVO d = fileDAO.show(Integer.parseInt(request.getParameter("id")));	
image = d.getFile();
imgData = image.getBytes(1,(int)image.length());
response.setContentType(d.getType());
OutputStream o = response.getOutputStream();
o.write(imgData);
o.flush();
o.close();
} catch (Exception e) {
	out.println(e);
return;

}
%>
</body>
</html>