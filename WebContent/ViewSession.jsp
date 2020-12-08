<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.echannelling.model.Session" %> 
 <%@page import="com.echannelling.service.SearchService" %>
 <%@page import="com.echannelling.service.ISearchService" %>
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



<jsp:include page="HeaderHome.jsp"></jsp:include>

<br>
<h2 class="text-center">Sessions</h2>
<br>

<div class="container">
<table border="1" class="table table-striped table-bordered">
		
		<tr class="thead-dark">
			<th>Doctor Name</th>
			<th>Hospital Name</th>
			<th>Day</th>
			<th>Time</th>
			<th>Fee</th>
			<th></th>
		</tr>
				<%
	
		String hID = (String)request.getAttribute("hID");
		String hName = (String)request.getAttribute("hName");
				
		ISearchService iSearchService = new SearchService();
 		ArrayList<Session> sessionList = iSearchService.getSearchSession(hID);
 		
		
 		for ( Session sess : sessionList){
		%>
		<tr>
			<td> <%=sess.getDocName() %> </td>
			<td> <%=hName %> </td>
			<td> <%=sess.getDay() %> </td>
			<td> <%=sess.getTime() %> </td>
			<td> <%=sess.getFee() %> </td>
		
	 	<td>
				<form method="POST" action="GetSearchSessionIdServlet">
					
					<input type="hidden" name="sID" 
					value="<%=sess.getsID() %>" /> 
					
					<input type="hidden" name="hID" 
					value="<%=hID %>" /> 
					
					<input type="hidden" name="dID" 
					value="<%=sess.getdID() %>" />
					
					<input type="hidden" name="docName" 
					value="<%=sess.getDocName() %>" />
					
					<input type="hidden" name="hName" 
					value="<%=hName %>" />
					
					<input type="hidden" name="day" 
					value="<%=sess.getDay() %>" />
					
					<input type="hidden" name="time" 
					value="<%=sess.getTime() %>" />
					
					<input type="hidden" name="fee" 
					value="<%=sess.getFee() %>" />
					
					<input class="btn btn-primary" type="submit" value="Book Now!"/>
				
				</form>
			</td>
	
		
	</tr>	
		<%
		}
		%>
	
		
	</table>
</div>



<jsp:include page="FooterHome.jsp"></jsp:include>

</body>
</html>