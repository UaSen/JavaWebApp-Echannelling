<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.echannelling.model.Doctor" %> 
 <%@page import="com.echannelling.service.DoctorService" %>
 <%@page import="com.echannelling.service.iDoctorService" %>    
 <%@page import="com.echannelling.model.Booking" %> 
 <%@page import="com.echannelling.service.BookingService" %>
 <%@page import="com.echannelling.service.IBookingService" %> 
 <%@page import="java.util.ArrayList" %>
 
       
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
		
		<h2 class="text-center">Appointments</h2>

<br>
<div class="container">
	<table border="1" class="table table-striped table-bordered" >
		
		<tr class="thead-dark">
			
			<th>Doctor ID</th>
			<th>No Of Booking</th>
		</tr>
		
		<%
		IBookingService iBookingService = new BookingService();
		ArrayList<Booking> bookList = iBookingService.viewNoOfBooking(ddID);
		
		for ( Booking book : bookList){
		%>
		
		
		<tr>
			<td> <%=book.getdID() %> </td>
			<td> <%=book.getNoOfBooking() %> </td>
		</tr>
		
		<%
		}
		%>
		
	</table>
		</div>

<jsp:include page="Doctor-Footer.jsp"></jsp:include>
</body>
</html>