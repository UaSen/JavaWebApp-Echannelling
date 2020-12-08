<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.echannelling.model.Feedback" %> 
 <%@page import="com.echannelling.service.FeedbackService" %>
 <%@page import="com.echannelling.service.iFeedbackService" %>
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
		<h2 class="text-center">List of Feedbacks</h2>
		<br>
<div class="container">
	<table border="1" class="table table-striped table-bordered" id="myTable">
		
		<tr class="thead-dark">
			<th>Feedback ID</th>
			<th>Email</th>
			<th>Subject</th>
			<th>Comment</th>
		</tr>
		
		<%
		iFeedbackService iFeedbackService = new FeedbackService();
		ArrayList<Feedback> fdbkList = iFeedbackService.viewFeedback();
		
		for ( Feedback feedback : fdbkList){
		%>
		
		<tr>
			<td> <%=feedback.getFeedbackID() %> </td>
			<td> <%=feedback.getEmail() %> </td>
			<td> <%=feedback.getSubject() %> </td>
			<td> <%=feedback.getComment() %> </td>
		</tr>
		
		<%
		}
		%>
		
	</table>
</div>
<jsp:include page="Admin-Footer.jsp"></jsp:include>
</body>
</html>