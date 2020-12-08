<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.echannelling.model.Hospital" %>
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

<br>
<h2 class="text-center">Add Session</h2>

<%
	DoctorService doc = new DoctorService();
	String ddID = (String) session.getAttribute("dID");
	Doctor doctors = doc.getDoctorByGivenID(ddID);	

	String hID = (String)request.getAttribute("hID");
	String dID = (String)request.getAttribute("dID");
	String docName = (String)request.getAttribute("docName");
%>

<div class="container">

<form method="POST" action="AddSessionServlet">
  <div class="form-group">
    <label for="id">Hospital ID</label>
    <input type="text" class="form-control" name="hID" disabled="disabled"
					value="<%=hID %>">
  </div>
  <div class="form-group">
    <label for="did">Doctor ID</label>
    <input type="text" class="form-control" name="dID" disabled="disabled"
					value="<%=dID %>">
  </div>
  <div class="form-group">
    <label for="dname">Doctor Name</label>
    <input type="text" name="docName" disabled="disabled"
					value="<%=docName %>" >
  </div>
  <div class="form-group">
    <label for=time>Day</label>
    <input type="text" class="form-control" name="day">
  </div>
  <div class="form-group">
    <label for="time">Time</label>
    <input type="text" class="form-control" name="time">
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
    <input type="text" class="form-control" name="fee">
  </div>
  <tr>
				<td><input type="hidden" name="hID"
					value="<%=hID %>" />
				<td><input type="hidden" name="dID"
					value="<%=dID %>" />
				<td><input type="hidden" name="docName"
					value="<%=docName %>" />
  <input type="submit" class="btn btn-primary" value="Add Session"/></td>
  </tr>
</form>
</div>

<jsp:include page="Admin-Footer.jsp"></jsp:include>
</body>
</html>