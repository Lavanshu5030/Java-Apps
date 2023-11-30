<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="register.jsp" method="post">
		<table>

			<tr>
				<td>Enter Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Enter email:</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register" /></td>
			</tr>
		</table>

	</form>
</body>
</html>