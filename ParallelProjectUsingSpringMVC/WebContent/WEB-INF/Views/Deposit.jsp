<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit</title>
</head>
<body>
	<div align="center">
		<h2>Deposit Amount Here</h2>
		<table>
			<form:form action="depositNew" method="post"
				modelAttribute="customer">


				<tr>
					<td>Mobile No:</td>
					<td><form:input path="mobileNo" size="30" /></td>
					<td><form:errors path="mobileNo" cssclass="errors" /></td>
				</tr>


				<tr>
					<td>Amount:</td>
					<td><form:input path="wallet.balance" size="30" /></td>
					<td><form:errors path="wallet.balance" cssclass="errors" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="submit" /></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>