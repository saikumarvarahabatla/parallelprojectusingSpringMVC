<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Successful</title>
</head>
<body>
	<div align="center">
		<h2>Welcome ${ customer.name} Your registration has been done
			successfully.</h2>
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>Mobile No</th>
				<th>Name</th>
			<th>Balance</th>
			</tr>
			<tr>
				<td>${ customer.mobileNo}</td>
				<td>${customer.name}</td>
				<td>${customer.wallet.balance}</td>
			</tr>
		</table>
		<a href="registration"><input type="submit"
			value="Add New Customer" /></a> <a href=""><input type="submit"
			value="Home" /></a> <a href="viewpage"><input type="submit"
			value="show all entries" /></a>
	</div>
</body>
</html>