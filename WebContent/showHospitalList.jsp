<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.echannelling.model.Hospital" %> 
 <%@page import="com.echannelling.service.HospitalService" %>
 <%@page import="com.echannelling.service.IHospitalService" %>
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
<h2 class="text-center">List Hospital</h2>
<br>
<div class="container">
<table border="1" class="table table-striped table-bordered">
		
		<tr class="thead-dark">
			<th>Hospital ID</th>
			<th>Doctor ID</th>
			<th>Doctor Name</th>
			<th>Hospital Name</th>
			<th scope="col"></th>
			<th scope="col"></th>
			<th scope="col"></th>
		</tr>

	<%
		IHospitalService iHospitalService = new HospitalService();
		ArrayList<Hospital> hospitalList = iHospitalService.viewHospital();
		
		for ( Hospital hospital : hospitalList){
		%>
		
		<tr>
			<td> <%=hospital.gethID() %> </td>
			<td> <%=hospital.getdID() %> </td>
			<td> <%=hospital.getDocName() %> </td>
			<td> <%=hospital.gethName() %> </td>

		
			<td> 
				<form method="POST" action="DeleteHospitalServlet">
					
					<input type="hidden" name="hID" 
					value="<%=hospital.gethID() %>" /> 
					
					<input class="btn btn-warning"  type="submit" value="Delete Hospital"/>
				
				</form>
			</td>
		
			<td>
				<form method="POST" action="GetHospitalServlet">
					
					<input type="hidden" name="hID" 
					value="<%=hospital.gethID() %>" /> 
					<input type="hidden" name="dID" 
					value="<%=hospital.getdID() %>" />
					<input type="hidden" name="docName" 
					value="<%=hospital.getDocName() %>" />
					
					<input type="hidden" name="type" 
					value="VIEW" />
					
					<input class="btn btn-primary"  type="submit" value="Add Session"/>
				</form>
			</td>
		
			<td> 
				<form method="POST" action="GetHospitalServlet">
					
					<input type="hidden" name="hID" 
					value="<%=hospital.gethID() %>" /> 
					<input type="hidden" name="dID" 
					value="<%=hospital.getdID() %>" />
					<input type="hidden" name="docName" 
					value="<%=hospital.getDocName() %>" />
					<input type="hidden" name="hName" 
					value="<%=hospital.gethName() %>" />
					
					
					
					<input type="hidden" name="type" 
					value="UPDATE" />
					
					<input class="btn btn-info"  type="submit" value="Update Hospital"/>
				
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