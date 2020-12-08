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

<br>
<h2 class="text-center">Update Hospital</h2>

<%
	DoctorService doc = new DoctorService();
	String ddID = (String) session.getAttribute("dID");
	Doctor doctors = doc.getDoctorByGivenID(ddID);	

	String hID = (String)request.getAttribute("hID");
	String dID = (String)request.getAttribute("dID");
	String docName = (String)request.getAttribute("docName");
	String hName = (String)request.getAttribute("hName");
%>

<br>
<div class="container">

<form method="POST" action="UpdateHospitalServlet">
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
    <input type="text" class="form-control" name="docName" disabled="disabled"
				value="<%=docName %>" >
  </div>
  <div class="form-group">
    <label for="hname">Hospital Name</label>
    <input type="text" class="form-control" name="hName"
				value="<%=hName %>">
  </div>
  
  <tr>		
				<td><input type="hidden" name="hID"
					value="<%=hID %>" />
				<td><input type="hidden" name="hName"
					value="<%=hName %>" />		
  <input type="submit" class="btn btn-primary" value="Update Hospital"/></td>
  </tr>
</form>





<jsp:include page="Admin-Footer.jsp"></jsp:include>
</body>
</html>