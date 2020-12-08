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

<div class="container">

	<form method="POST" action="UpdateDoctorServlet">
  
  <div class="form-group">
    <label for=id>Admin ID</label>
    <input type="text" name="dID" class="form-control" disabled="disabled"
				value="<%=doctors.getdID() %>" >
  </div>
  <div class="form-group">
    <label for="aname">Admin Name</label>
    <input type="text" name="docName" class="form-control" disabled="disabled"
				value="<%=doctors.getDocName() %>" >
  </div>
   <div class="form-group">
    <label for="nic">NIC</label>
    <input type="text" name="NIC" class="form-control" disabled="disabled"
				value="<%=doctors.getNIC() %>" >
  </div>
  <div class="form-group">
    <label for="number">Phone Number</label>
    <input type="text" name="phone" class="form-control" 
				value="<%=doctors.getPhone() %>" >
  </div>
  <div class="form-group">
    <label for="email">Email Address</label>
    <input type="text" name="email" class="form-control"
				value="<%=doctors.getEmail() %>" >
  </div>
  <div class="form-group">
    <label for="name">User Name</label>
    <input type="text" name="userName" class="form-control" disabled="disabled"
				value="<%=doctors.getUserName() %>" >
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" name="password" class="form-control"
				value="<%=doctors.getPassword() %>" >
  </div>
  <div class="form-group">
    <label for="spec">Specialization</label>
    <input type="text" name="specialization" class="form-control"
				value="<%=doctors.getSpecialization() %>" >
  </div>
<tr>
				<td>
					<input type="hidden" name="dID"
					value="<%=doctors.getdID() %>" />
					
					<td><input type="hidden" name="docName"
					value="<%=doctors.getDocName() %>" />
				
					<td><input type="hidden" name="NIC"
					value="<%=doctors.getNIC() %>" />
					
					<td><input type="hidden" name="userName"
					value="<%=doctors.getUserName() %>" />
					
					<td><input type="hidden" name="type"
					value="ADMIN" />
					
  <input type="submit" class="btn btn-primary"  value="Update Account"/></td>
 </tr>
</form>
</div>

<jsp:include page="Admin-Footer.jsp"></jsp:include>
</body>
</html>