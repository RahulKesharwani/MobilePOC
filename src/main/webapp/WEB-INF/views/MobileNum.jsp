<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobile Number</title>
</head>
<body id="login-bg">
	<h2>${message}</h2>
	<form:form modelAttribute="mobileNumModel" action="checkMobileNumber"
		method="post">
		Mobile Number:<form:input type="text" path="mobileNumber" />
		<input type="submit" class="submit-login" value="Next"/>
	</form:form>
</body>
</html>