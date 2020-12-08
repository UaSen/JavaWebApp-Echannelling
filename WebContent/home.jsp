<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.echannelling.model.Hospital" %> 
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
<h2 class="h2 text-center">Welcome to EChannelling!!!!</h2>

<div class="d-flex justify-content-center">
<input class="input-group-text" type="text" id="myInput" onkeyup="myFunction()" placeholder="Search.." required>
</div>
<br>
<br>
<div class="container">
<table border="1" class="table table-striped table-bordered" id="myTable">
	<tr class="thead-dark">
			<th scope="col">Doctor Name</th>
			<th scope="col">Specialization</th>
			<th scope="col">Hospital Name</th>
			<th scope="col"></th>
		</tr>	
	
	
	<%
	ISearchService iSearchService = new SearchService();
	
	ArrayList<Hospital> hosList = iSearchService.viewSearchDetails();
	
	for ( Hospital hospital : hosList) {
		
	%>

	<tr>

	<td><a href="#"> <%=hospital.getDocName() %> </a></td>
	<td><a href="#"> <%=hospital.getSpecialization() %> </a></td>
	<td><a href="#"> <%=hospital.gethName() %> </a></td>
	
	<td>
				<form method="POST" action="GetSearchIdServlet">
					
					<input type="hidden" name="hID" 
					value="<%=hospital.gethID() %>" /> 
					
					<input type="hidden" name="hName" 
					value="<%=hospital.gethName() %>" />
					
					<input class="btn btn-primary" type="submit" value="Book Now"/>
				
				</form>
			</td>

	</tr>
	<%
		}
	%>
	

</table>
</div>

	<script>
	function myFunction() {
		  // Declare variables
		  var input, filter, table, tr, td, i, txtValue;
		  input = document.getElementById("myInput");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable");
		  tr = table.getElementsByTagName("tr");

		  // Loop through all table rows, and hide those who don't match the search query
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[0];
		    if (td) {
		      txtValue = td.textContent || td.innerText;
		      if (txtValue.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }
		  }
		}		

</script>

	<jsp:include page="FooterHome.jsp"></jsp:include>
</body>
</html>