<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recharge</title>
</head>
<body>
	<h1>Please recharge your phone number</h1>

	<form name="chckOffers"	action="RechargeMobileNum" method="post">
		Entered Mobile Number: <input type="text" name="mobileNum" value="${mobileNum}" readonly="readonly" />
		<br>
		<label>Recharge Amount:</label><input type="text" name="rechargeAmt" />
		<input type="button" value="Offers" name="btnChckOffer" class="btn">

		<input type="submit" class="submit-login" value="Recharge" />
	</form>

</body>
</html>