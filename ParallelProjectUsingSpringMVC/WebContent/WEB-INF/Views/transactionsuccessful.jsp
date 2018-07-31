<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Successful</title>
</head>
<body>
	<div align="center">
		<h2>Welcome $(customerNew.name) Your Transaction has been done
			successfully.</h2>
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>Mobile No</th>
				<th>Name</th>
			<th>Updated Balance</th>
			</tr>
			<tr>
				<td>${ customerNew.mobileNo}</td>
				<td>${ customerNew.name}</td>
				<td>${ customerNew.wallet.balance}</td>
			</tr>
		</table>
		<br> <a href=""><input type="submit" value="Home" /></a>
	</div>
</body>
</html>