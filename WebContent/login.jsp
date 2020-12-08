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

<h2 class="text-center">Login to your account</h2>

<div class="container">
<form method="POST" action="LoginServlet">
  <div class="form-group">
    <label for="userName">User Name</label>
    <input type="text" name="userName" class="form-control col-md-6" placeholder="User Name or Email" required>
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" name="password"  class="form-control col-md-6" placeholder="Password" required>
  </div>
  <input type="submit" class="btn btn-primary" value="Login"/>
</form>
</div>
<jsp:include page="FooterHome.jsp"></jsp:include>
</body>
</html>