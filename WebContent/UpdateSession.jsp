<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page import="com.echannelling.model.Doctor" %> 
 <%@page import="com.echannelling.service.DoctorService" %>
 <%@page import="com.echannelling.service.iDoctorService" %>
    
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

	String sID = (String)request.getAttribute("sID");
	String docName = (String)request.getAttribute("docName");
	String day = (String)request.getAttribute("day");
	String time = (String)request.getAttribute("time");
	String avalability = (String)request.getAttribute("avalability");
	String fee = (String)request.getAttribute("fee");
	
		
%>
<br>
<div class="container">
<form method="POST" action="UpdateSessionServlet">
  <div class="form-group">
    <label for="name">Session ID</label>
    <input type="text" class="form-control" name="sID" disabled="disabled"
					value="<%=sID %>" >
  </div>
  <div class="form-group">
    <label for="dname">Doctor Name</label>
    <input type="text" class="form-control" name="docName" disabled="disabled"
					value="<%=docName %>" >
  </div>
  <div class="form-group">
    <label for="day">Day</label>
    <input type="text" class="form-control" name="day"
					value="<%=day %>">
  </div>
  <div class="form-group">
    <label for="time">Time</label>
    <input type="text" class="form-control" name="time"
					 value="<%=time %>" >
  </div>
  <div class="form-group">
    <label for="availability">Availability</label>
    <div class="form-check">
  <input class="form-check-input" type="radio" name="avalability" value="yes" checked>
  <label class="form-check-label" for="exampleRadios1">
    Yes
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="avalability" value="no">
  <label class="form-check-label" for="exampleRadios2">
    No
  </label>
</div>
  </div>
  <div class="form-group">
    <label for="fee">Fee</label>
    <input type="text" class="form-control" name="fee"
				value="<%=fee %>" >
  </div>
 
 	<tr>
				<td><input type="hidden" name="sID"
					value="<%=sID %>" />
				
				
				<td><input type="hidden" name="day"
					value="<%=day %>" />
				<td><input type="hidden" name="time"
					value="<%=time %>" />
				<td><input type="hidden" name="avalability"
					value="<%=avalability %>" />
				<td><input type="hidden" name="fee"
					value="<%=fee %>" />	
  <input type="submit" class="btn btn-primary" value="Update Session"/>
  </td>
  </tr>
</form>


</div>



<jsp:include page="Admin-Footer.jsp"></jsp:include>
</body>
</html>