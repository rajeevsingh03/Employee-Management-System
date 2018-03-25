<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Centralized Employee Management System</title>


</head>
<body>
<Center>

<br><br><br><br>
<h1><p style='background-color:black; font-size:24px; color:beige'>WELCOME TO THE CENTRALIZED EMPLOYEE MANAGEMENT SYSTEM</p></h1>


<%
String message= (String) request.getAttribute("msg");
if(message!=null)
out.println(" " + message); %>
<br><br>
<form action="<%= request.getContextPath()%>/loginController" method="post">
            <center>
                <h2>  Login </h2>
                <table border="2" bgcolor="white" style="color:black"> 
 				<tbody style="font-size: 30px !important;">
                    <tr>
                        <td>
                            <b>Username:</b>
                        </td>
                        <td>
                            <input type="text" name="user_name">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Password:</b>
                        </td>
                        <td>
                            <input type="password" name="password">
                        </td>
                    </tr>
                    <tr>
                        
                            
                    </tbody>
                </table>
                <br><br>
                <input type="submit" value="Login" style="font-size:12pt;color:white;background-color:indigo;border:2px solid #336600;padding:3px">
                            <input type="reset" value="Reset" style="font-size:12pt;color:white;background-color:indigo;border:2px solid #336600;padding:3px">
                        
        </form>
        <br><br>
     <h2>Don't have an Account ?<p style='font-size:24px; color:red'> First, Register yourself.. !</p> </h2>
     <a href="<%=request.getContextPath() %>/user/register.jsp">
     
     <h2><p style='font-size:24px; color:lime'>Sign Up</h2>  </a>
</Center>
</body>
</html>