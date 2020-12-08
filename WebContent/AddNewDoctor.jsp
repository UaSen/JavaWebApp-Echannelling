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

%>
<br>
<h2 class="text-center">Add Doctor</h2>

<div class="container">
<form method="POST" action="AddDoctorServlet">
  <div class="form-group">
    <label for="name">Doctor Name</label>
    <input type="text" name="docName" class="form-control" placeholder="Doctor Name" required>
  </div>
  <div class="form-group">
    <label for="nic">NIC</label>
    <input type="text" class="form-control" name="NIC" placeholder="NIC" required>
  </div>
  <div class="form-group">
    <label for="feedback">Phone Number</label>
    <input type="text" name="phone" class="form-control" placeholder="Phone Number" required>
  </div>
  <div class="form-group">
    <label for="email">Email Address</label>
    <input type="email" class="form-control" name="email" placeholder="Your Email" required>
  </div>
  <div class="form-group">
    <label for="uname">User Name</label>
    <input type="text" class="form-control" name="userName" placeholder="User Name" required>
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password" required>
  </div>
  <div class="form-group">
    <label for="spec">Specialization</label>
    <input type="text" class="form-control" name="specialization" placeholder="Specialization here" required>
  </div>
  <input type="submit" class="btn btn-primary" value="Add Doctor"/>
</form>
</div>


<jsp:include page="Admin-Footer.jsp"></jsp:include>
</body>
</html>