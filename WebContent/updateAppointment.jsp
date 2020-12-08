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
<h2 class="text-center">Update Appointment</h2>

<div class="container">
<form method="POST" action="Updatecustomerservlet">
  <div class="form-group">
    <label for="ref">Reference number</label>
    <input type="text" name="refnumber" class="form-control" required>
  </div>
  <div class="form-group">
    <label for="subject">Customer name</label>
    <input type="text" name="customer_name" class="form-control"required>
  </div>
  <div class="form-group">
    <label for="email">Customer email</label>
    <input type="email" name="customer_email" class="form-control" required>
  </div>
   <div class="form-group">
    <label for="email">Customer NIC</label>
    <input type="text" name="customer_nic" class="form-control" required>
  </div>
  <input type="submit" class="btn btn-primary" value="Upadte details"/>
</form>
</div>

<jsp:include page="FooterHome.jsp"></jsp:include>
</body>
</html>