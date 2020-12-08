<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E Channelling</title>
</head>
<body>




<jsp:include page="HeaderHome.jsp"></jsp:include>
<%

	String sID = (String)request.getAttribute("sID");
	String hID = (String)request.getAttribute("hID");
	String dID = (String)request.getAttribute("dID");
	String docName = (String)request.getAttribute("docName");
	String hName = (String)request.getAttribute("hName");
	String day = (String)request.getAttribute("day");
	String time = (String)request.getAttribute("time");
	String fee = (String)request.getAttribute("fee");

%>

<h2>Session Details</h2>

<table>	
	<tr>Doctor Name : - <%=docName %></tr><br/>
	<tr>Hospital Name : - <%=hName %></tr><br/>
	<tr>Day : - <%=day %></tr><br/>
	<tr>Time : - <%=time %></tr><br/>
</table>

<h2>Enter Your Details</h2>

<form method="POST" action="AddBookingServlet">
	
		<table>
			<tr>
				<td>Enter name</td>
				<td><input type="text" name="cName"/></td>
			</tr>
			
			<tr>
				<td>Enter Email Address</td>
				<td><input type="text" name="cEmail"/></td>
			</tr>
	
			<tr>
				<td>Enter NIC</td>
				<td><input type="text" name="cNIC"/></td>
			</tr>
			

			<tr>
				<td>Name on Card</td>
				<td><input type="radio" name="cardName" value="visa">VISA</td>
				<td><input type="radio" name="cardName" value="master">MASTER</td>
			</tr>


			<tr>
				<td>Card Number</td>
				<td><input type="text" name="cardNo"/></td>
			</tr>

			<tr>
				<td>Exp Date</td>
				<td><input type="text" name="expDate"/></td>
			</tr>
			
			<tr>
				<td>CVC</td>
				<td><input type="text" name="cvc"/></td>
			</tr>

			<tr>
				<td>Fee</td>
				<td><input type="text" name="fee" disabled="disabled"
					value="<%=fee %>" /></td>
			</tr>
		
			<tr>
				
				<td>
				<input type="hidden" name="sID"
					value="<%=sID %>" />
				<input type="hidden" name="hID"
					value="<%=hID %>" />
				<input type="hidden" name="dID"
					value="<%=dID %>" />
				<input type="hidden" name="fee"
					value="<%=fee %>" />
									
				<input type="submit" value="Book"/></td>
			</tr>
			
		</table>
	
	</form>
	


<jsp:include page="FooterHome.jsp"></jsp:include>

</body>
</html>