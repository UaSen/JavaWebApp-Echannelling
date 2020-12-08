<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h2 class="text-center">Cancel Appointment</h2>

<div class="container">
<form method="POST" action="CancelBookingServlet">
  <div class="form-group">
    <label for="email">Enter your Email address</label>
    <input type="email" name="email" class="form-control" placeholder="Enter email" required>
  </div>
  <div class="form-group">
    <label for="subject">Enter Reference NO</label>
    <input type="text" name="refNO" class="form-control" placeholder="B1001" required>
  </div>
  <input type="submit" class="btn btn-primary" value="cancel appointment"/>
</form>
</div>

<jsp:include page="FooterHome.jsp"></jsp:include>
</body>
</html>