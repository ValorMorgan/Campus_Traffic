<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Server Exception</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<p>Something went wrong.  We'll try hard to fix it.</p>
	<p>Error generated from: ${pageContext.errorData.requestURI}</p>
	<p>Status code: ${pageContext.errorData.statusCode}</p>
	<p>Exception Info: ${pageContext.errorData.throwable}</p>
	<a href="${pageContext.request.contextPath}">Go Home</a>
</body>
</html>