<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Campus Traffic</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<a href="./Logon/login.jsp">Try and break in</a>
	<form id="lots" method="post" action="${pageContext.request.contextPath}/lotGet">
		<select id="lotList" name="lotList" >
			<option value="79">Lot 79</option>
			<option value="79e">Lot 79e</option>
			<option value="lol">Lot 80</option>
			<option value="56">Lot 56</option>
			<option value="55">Lot 55</option>
			<option value="57">Lot 57</option>
			<option value="39">Lot 39</option>
			<option value="40">Lot 40</option>
			<option value="38">Lot 38</option>
			<option value="41">Lot 41</option>
			<option value="43">Lot 43</option>
		</select>
		<input type="submit" value="Check Lot"/>
	</form>
</body>
</html>