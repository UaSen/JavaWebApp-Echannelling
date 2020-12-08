<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
<h2 class="text-center">List Doctor</h2>
<br>

<div class="d-flex justify-content-center">
<a class="btn btn-info" href="AddNewDoctor.jsp">Add Doctor</a>
</div>
<br>
<div class="container">
	<table border="1" class="table table-striped table-bordered" id="myTable">
		
		<tr class="thead-dark">
			<th scope="col">Doctor ID</th>
			<th scope="col">Doctor Name</th>
			<th scope="col">NIC</th>
			<th scope="col">Phone Number</th>
			<th scope="col">Email Address</th>
			<th scope="col">user Name</th>
			<th scope="col">Password</th>
			<th scope="col">Specialization</th>
			<th scope="col"></th>
			<th scope="col"></th>
		</tr>

	<%
	
		iDoctorService iDoctorService = new DoctorService();
		ArrayList<Doctor> docList = iDoctorService.viewDoctors();
		
		for ( Doctor doctor : docList){
		%>
		
		<tr>
			<td> <%=doctor.getdID() %> </td>
			<td> <%=doctor.getDocName() %> </td>
			<td> <%=doctor.getNIC() %> </td>
			<td> <%=doctor.getPhone() %> </td>
			<td> <%=doctor.getEmail() %> </td>
			<td> <%=doctor.getUserName() %> </td>
			<td> <%=doctor.getPassword() %> </td>
			<td> <%=doctor.getSpecialization() %> </td>
			
 			<td>
				<form method="POST" action="DeleteDoctorServlet">
					
					<input type="hidden" name="doctorID" 
					value="<%=doctor.getdID() %>" /> 
					
					<input class="btn btn-warning" type="submit" value="Delete Doctor"/>
				
				</form>
			</td>
			
			<td>
				<form method="POST" action="GetDoctorServlet">
					
					<input type="hidden" name="doctorID" 
					value="<%=doctor.getdID() %>" /> 
					
					<input type="hidden" name="doctorName" 
					value="<%=doctor.getDocName() %>" /> 
					
					<input type="hidden" name="specialization" 
					value="<%=doctor.getSpecialization() %>" />
					
					<input class="btn btn-primary" type="submit" value="Add Hospital"/>
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