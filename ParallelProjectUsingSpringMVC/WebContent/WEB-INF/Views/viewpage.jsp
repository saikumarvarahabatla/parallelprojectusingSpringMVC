<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
</head>
<body>
	<h1>Customers List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Mobile No</th>
			<th>Name</th>
		<th>Balance</th>
		</tr>
		<c:forEach var="customer" items="${List}">
			<tr>
				<td>${customer.mobileNo}</td>
				<td>${customer.name}</td>
				<td>${customer.wallet.balance}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="registration"><input type="submit"
		value="Add new customer" /></a>
	<a href=""><input type="submit" value="Home" /></a>
</body>
</html>