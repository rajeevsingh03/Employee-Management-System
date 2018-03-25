<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<% 
String message1= (String) request.getAttribute("msg");
String message= (String) request.getAttribute("msg");
if(message!=null)
out.println(" "+ message);
else if(message1!=null)
out.println(" "+ message1);%>

    <body bgcolor="white">
        <form action="<%= request.getContextPath()%>/registrationController" method="post">
            <center>
                <h1>Register Here.. </h1>
                <table border="2" bgcolor="white" style="color:black"> 
 				<tbody style="font-size: 30px !important;">
                    <tr>
                        <td>
                            <b>First Name:</b>
                        </td>
                        <td>
                            <input type="text" name="firstname">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Last Name:</b>
                        </td>
                        <td>
                            <input type="text" name="lastname">
                        </td>
                    </tr>
                     <tr>
                        <td>
                            <b>Address</b>
                        </td>
                        <td>
                            <input type="text" name="address">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>City</b>
                        </td>
                        <td>
                            <input type="text" name="city">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>State</b>
                        </td>
                        <td>
                            <input type="text" name="state">
                        </td>
                    </tr>
                   <tr>
                        <td>
                            <b>Country:</b>
                        </td>
                        <td>
                            <input type="text" name="country">
                        </td>
                    </tr>   
                    <tr>
                        <td>
                            <b>Phone No:</b>
                        </td>
                        <td>
                            <input type="text" name="phone">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Email-ID:</b>
                        </td>
                        <td>
                            <input type="text" name="email">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>UserName:</b>
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
                        <td>
                            <input type="submit" value="SignUp">
                        </td>
                        <td>
                            <input type="reset" value="Reset">
                        </td>
                    </tr>
                    </tbody>
                </table>
        </form>
        <h2>Already have an Account ? Login Here.. ! </h2>
        <a href="index.jsp"><h2>Login</h2>  </a>
    </body>
</html>