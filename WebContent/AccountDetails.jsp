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





<jsp:include page="Doctor-Header.jsp"></jsp:include>

<% 	
	DoctorService doc = new DoctorService();
	String ddID = (String) session.getAttribute("dID");
	Doctor doctors = doc.getDoctorByGivenID(ddID);
%>

<br>
<h2 class="text-center">Account Details</h2>
<br>

<div class="container">
	<form method="POST" action="UpdateDoctorServlet">
	<div class="form-group">
		<table>
		
			<tr>
				<td>Doctor ID</td>
				<td><input type="text" class="form-control" name="dID" disabled="disabled"
				value="<%=doctors.getdID() %>" /></td>
			</tr>
		
			<tr>
				<td>Doctor Name</td>
				<td><input type="text" class="form-control" name="docName" disabled="disabled"
				value="<%=doctors.getDocName() %>" /></td>
			</tr>
		
			<tr>
				<td>NIC</td>
				<td><input type="text" class="form-control" name="NIC" disabled="disabled"
				value="<%=doctors.getNIC() %>" /></td>
			</tr>
		
			<tr>
				<td>Phone Number</td>
				<td><input type="text" class="form-control" name="phone"
				value="<%=doctors.getPhone() %>" /></td>
			</tr>
		
			<tr>
				<td>Email Address</td>
				<td><input type="text" class="form-control" name="email"
				value="<%=doctors.getEmail() %>" /></td>
			</tr>
		
			<tr>
				<td>User Name</td>
				<td><input type="text" class="form-control" name="userName"
				value="<%=doctors.getUserName() %>" /></td>
			</tr>
		
			<tr>
				<td>Password</td>
				<td><input type="password" class="form-control" name="password"
				value="<%=doctors.getPassword() %>" /></td>
			</tr>
		
			<tr>
				<td>Specialization</td>
				<td><input type="text" class="form-control"  name="specialization" disabled="disabled"
				value="<%=doctors.getSpecialization() %>" /></td>
			</tr>
			
			<tr>
				<td>
					<input type="hidden" name="dID"
					value="<%=doctors.getdID() %>" />
					
					<td><input type="hidden" name="docName"
					value="<%=doctors.getDocName() %>" />
				
					<td><input type="hidden" name="NIC"
					value="<%=doctors.getNIC() %>" />
					
					<td><input type="hidden" name="specialization"
					value="<%=doctors.getSpecialization() %>" />
					
					<td><input type="hidden" name="type"
					value="DOCTOR" />
				<br>
				<input class="btn btn-primary"  type="submit"  value="Update Account"/>
				</td>
			</tr>
			
		</table>
	</div>
	</form>

</div>


<jsp:include page="Doctor-Footer.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


</body>
</html>