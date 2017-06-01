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

<form:form modelAttribute="mobileNumModel" action="saveMobileNumber"
		method="post">
		
		Recharge Amount:<form:input type="text" path="rechargeAmt" />
		<input type="button"  value="Offers" onclick="" />
		<br></br>
		
		<input type="submit" class="submit-login" value="Recharge" />
	</form:form>
	
</body>
</html>