<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>404</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div width="500px">
	<img width="500px" src='${pageContext.request.contextPath}/images/sherlock.png'/>
	</div>
	<p>Even Sherlock can't find the page you're looking for!</p>
	<a href="${pageContext.request.contextPath}">Go Home</a>
</body>
</html>