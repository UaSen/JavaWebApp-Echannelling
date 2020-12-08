<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="javax.servlet.http.HttpSession" %>
 <%@page import="com.echannelling.model.Doctor" %> 
 <%@page import="com.echannelling.service.DoctorService" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>E Channelling</title>
</head>
<body>



<%  try {
	
	if(session.getAttribute("userName") != null) { 
	
		DoctorService doc = new DoctorService();
		String ddID = (String) session.getAttribute("dID");
		Doctor doctors = doc.getDoctorByGivenID(ddID);
	%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Admin-Dashboard.jsp">Dashboard</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="Admin-Account.jsp">Admin Account</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="showFeedbackList.jsp">Veiw Feedback</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="AddNewDoctor.jsp">Add Doctor</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="showdcotorList.jsp">List Doctor</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="showHospitalList.jsp">List Hospitals</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="showSessionList.jsp">List Session</a>
      </li>
    </ul>
    <form method="post" class="form-inline my-2 my-lg-0" action="LogoutServlet" >
        	<input class="btn btn-info" type="submit" value="Logout"/>       	
    </form>
  </div>
</nav>


    
     <% } 
	} catch (Exception e) {
    	e.printStackTrace();
    }%>

 



</body>
</html>