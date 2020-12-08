<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.echannelling.model.Session" %> 
 <%@page import="com.echannelling.service.SessionService" %>
 <%@page import="com.echannelling.service.ISessionService" %>
  <%@page import="com.echannelling.model.Doctor" %> 
 <%@page import="com.echannelling.service.DoctorService" %>
 <%@page import="com.echannelling.service.iDoctorService" %>
 <%@page import="java.util.ArrayList" %>
    
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>E Channelling</title>
</head>
<body>



<jsp:include page="Admin-Header.jsp"></jsp:include>

<%

	DoctorService doc = new DoctorService();
	String ddID = (String) session.getAttribute("dID");
	Doctor doctors = doc.getDoctorByGivenID(ddID);

%>
<br>
<h2 class="text-center">List Session</h2>
<br>

<div class="container">
<table border="1" class="table table-striped table-bordered" id="myTable">
		
		<tr class="thead-dark">
			<th scope="col">Session ID</th>
			<th scope="col">Hospital ID</th>
			<th scope="col">Doctor ID</th>
			<th scope="col">Doctor Name</th>
			<th scope="col">Day</th>
			<th scope="col">Time</th>
			<th scope="col">Availability</th>
			<th scope="col">Fee</th>
			<th scope="col"></th>
			<th scope="col"></th>
		</tr>

	<%
		ISessionService iSessionService = new SessionService();	
		ArrayList<Session> sessionList = iSessionService.viewSessions(); 
		
		for ( Session sess : sessionList){
		%>
		
		<tr>
			<td> <%=sess.getsID() %> </td>
			<td> <%=sess.gethID() %> </td>
			<td> <%=sess.getdID() %> </td>
			<td> <%=sess.getDocName() %> </td>
			<td> <%=sess.getDay() %> </td>
			<td> <%=sess.getTime() %> </td>
			<td> <%=sess.getAvalability() %> </td>
			<td> <%=sess.getFee() %> </td>
		
	 		<td>
				<form method="POST" action="DeleteSessionServlet">
					
					<input type="hidden" name="sID" 
					value="<%=sess.getsID() %>" /> 
					
					<input class="btn btn-warning" type="submit" value="Delete Session"/>
				
				</form>
			</td>
	
			<td>
				<form method="POST" action="GetSessionServlet">
					
					<input type="hidden" name="sID" 
					value="<%=sess.getsID() %>" /> 
					
					<input type="hidden" name="docName" 
					value="<%=sess.getDocName() %>" />
					
					<input type="hidden" name="day" 
					value="<%=sess.getDay() %>" />
					
					<input type="hidden" name="time" 
					value="<%=sess.getTime() %>" />
					
					<input type="hidden" name="avalability" 
					value="<%=sess.getAvalability() %>" />
					
					<input type="hidden" name="fee" 
					value="<%=sess.getFee() %>" />
					
					<input class="btn btn-info" type="submit" value="Update Session"/>
				
				</form>
			</td>
		
	</tr>	
		<%
		}
		%>
	
		
	</table>
</div>






<jsp:include page="Admin-Footer.jsp"></jsp:include>
</body>
</html>