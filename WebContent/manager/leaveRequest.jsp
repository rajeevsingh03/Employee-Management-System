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
	<%
String error=(String)request.getAttribute("error");
if(error != null){
out.print("<p style='background-color:blue;'>"+error +"</p>");
} %>
<%
String message= (String) request.getAttribute("msg");
if(message!=null)
out.println("<p style='background-color:blue; color: white'>"+message +"</p>"); %>
	
	
	<div>
				<h2 align="center"><br>Request for a Leave</h2></div>
				<br>
				
				<div>
					<form action="<%=request.getContextPath()%>/leaveRequestController?flag=add" method="post">
						
						<div>
							<label>
								Leave Type*</label><br><br>
							<div>
								<input type="text" placeholder="Enter type of Leave" name="leaveType"><br><br>
							</div></div>
						
						<div>
								<label>Leave Description*</label><br><br>
								<div>
								<textarea placeholder="Briefly describe your problem" name="leaveDescription"></textarea>
								</div>
							</div>
							<br><br>
							
							<div>
								<label>Select Start Date for Leave*</label>
								<div><br>
									<input type="date" id='datepicker' name="startdate" required/>
							  		
							  	</div>
							</div>
							<br><br>
							<div>
							<label>
								Number of Days*</label><br><br>
							<div>
								<input type="text" name="numberofdays"><br><br>
							</div>
						</div>
			
							
							
							<br><br><br>
						<div>
							<div>
								<button type="submit" >Request for Leave</button><br><br>
								<button type="reset" >Reset</button>
							</div>
						</div>
												
				
					</form>
				</div>
	</center>
	</body>
	</html>