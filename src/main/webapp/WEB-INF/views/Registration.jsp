<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Please register your Mobile Number first</h1>

	<form:form modelAttribute="mobileNumModel" action="saveMobileNumber"
		method="post">
		Mobile Number:<form:input type="text" path="mobileNumber"
			readOnly="${mobileNumber?false:true}" />
		</br></br>
		First Name:<form:input type="text" path="firstName" />
		<br></br>
		Last Name:<form:input type="text" path="lastName" />
		<br></br>
		Status:<form:input type="text" path="status" />
		<br></br>

		<input type="submit" class="submit-login" value="Save" />
	</form:form>
</body>

</body>
</html>