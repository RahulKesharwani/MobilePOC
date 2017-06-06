<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Offers</title>
</head>
<body>

	<h1>Add offers to phone number</h1>

	<form name="addOffers"	action="AddOffers" method="post">
		Entered Mobile Number: <input type="text" name="mobileNum" />
		<br>
		<label>Offer Amount:</label><input type="text" name="offerAmt" />
		<br></br>
		<input type="submit" class="submit-login" value="Add Offer" />
		<br>
		
		<label>do you want to recharge again </label> <a href="checkMobileNumber">Recharge Again</a>
	</form>
</body>
</html>