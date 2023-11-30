<%@page import="com.app.dao.EmployeeDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id = "emp" class = "com.app.bean.Employee"/>
<jsp:setProperty property = "*" name= "emp" />
<%
int i =EmployeeDao.registerEmp(emp);

if(i>0){
	response.sendRedirect("success.jsp");
}
else{
	response.sendRedirect("error.jsp");
}
%>

</body>
</html>