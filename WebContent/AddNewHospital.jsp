<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page import="com.echannelling.model.Doctor" %>    
    <%@page import="com.echannelling.model.Hospital" %>
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
<h2 class="text-center">Add Hospital</h2>

<%
	DoctorService doc = new DoctorService();
	String ddID = (String) session.getAttribute("dID");
	Doctor doctors = doc.getDoctorByGivenID(ddID);

	String dID = (String)request.getAttribute("doctorID");
	String docName = (String)request.getAttribute("docName");
	String specialization = (String)request.getAttribute("specialization");
%>


<div class="container">
<form method="POST" action="AddHospitalServlet">
  <div class="form-group">
    <label for="id">Doctor ID</label>
    <input type="text" name="dID" class="form-control" disabled="disabled" value="<%=dID %>">
  </div>
  <div class="form-group">
    <label for="subject">Doctor Name</label>
    <input type="text" name="docName" class="form-control" disabled="disabled" value="<%=docName %>">
  </div>
  <div class="form-group">
    <label for="hospital">Hospital Name</label>
    <input type="text" name="hName" class="form-control">
  </div>
  <tr>		
				<td><input type="hidden" name="dID"
					value="<%=dID %>" />
					
					<td><input type="hidden" name="docName"
					value="<%=docName %>" />
				
					<td><input type="hidden" name="specialization"
					value="<%=specialization %>" />
  
  <input type="submit" class="btn btn-primary" value="Add Hospital"/>
  </td>
  </tr>
</form>
</div>



<jsp:include page="Admin-Footer.jsp"></jsp:include>
</body>
</html>