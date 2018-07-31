<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Details</title>
</head>
<body>
	<div align="center">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>Mobile No</th>
				<th>Name</th>
			<th>Balance</th>
			</tr>
			<tr>
				<td>${customer1.mobileNo}</td>
				<td>${customer1.name}</td>
				<td>${customer1.wallet.balance}</td>
			</tr>
		</table>
		<a href=""><input type="submit" value="Home" /></a>
		</div>
</body>
</html>