<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.echannelling.model.Feedback" %> 
 <%@page import="com.echannelling.service.FeedbackService" %>
 <%@page import="com.echannelling.service.iFeedbackService" %>
 <%@page import="com.echannelling.servlet.GiveFeedbackServlet" %>  

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
<h2 class="text-center">Leave a feedback</h2>

<div class="container">
<form method="POST" action="GiveFeedbackServlet">
  <div class="form-group">
    <label for="email">Enter your Email address</label>
    <input type="email" name="email" class="form-control" placeholder="Enter email" required>
  </div>
  <div class="form-group">
    <label for="subject">Enter Subject</label>
    <input type="text" name="subject" class="form-control" placeholder="your reason" required>
  </div>
  <div class="form-group">
    <label for="feedback">Enter your Feedback</label>
    <input type="text" name="comment" class="form-control" placeholder="leave a message" required>
  </div>
  <input type="submit" class="btn btn-primary" value="Add Feedback"/>
</form>
</div>

 
 <jsp:include page="FooterHome.jsp"></jsp:include>
 
</body>
</html>