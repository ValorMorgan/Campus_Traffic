<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/sql'
	prefix='sql' %>
	<%@ taglib uri='http://java.sun.com/jsp/jstl/core'
	prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Campus Traffic</title>
</head>
<body>
	<sql:setDataSource dataSource="jdbc/CampusTrafficDataSource"/>
	<sql:query var="lots">
		SELECT Lot_Name FROM ParkingLots
	</sql:query>
	<%@ include file="header.jsp" %>
	<a href="./Logon/login.jsp">Try and break in</a>
	<form id="lots" method="post" action="${pageContext.request.contextPath}/lotGet">
		<select id="lotList" name="lotList" >
		
			<c:forEach var='lot' begin='0' items='${lots.rows}'>
				<option value='${lot.Lot_Name}'>Lot ${lot.Lot_Name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Check Lot"/>
	</form>
</body>
</html>