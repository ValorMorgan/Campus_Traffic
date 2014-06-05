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
<title>Admin Page</title>

<script type="text/javascript">
	function validate(form) {
		var streetName = form.streetName.value;
		var xCoord = form.xCoord.value;
		var yCoord = form.yCoord.value;
		var errors = [];
		
		if(!checkLength(streetName)) {
			errors.push("You must enter a street name.");
		}
		if(!checkLength(xCoord)) {
			errors.push("You must enter an X-Coordinate.");
		}
		if(!checkLength(yCoord)) {
			errors.push("You must enter a Y-Coordinate.");
		}
		
		if (errors.length > 0) {
			reportErrors(errors);
			return false;
		}
		
		return true;
	}
	
	function checkLength(text, min, max) {
		min = min || 1;
		max = max || 10000;
		if (text.length < min || text.length > max) {
			return false;
		}
		
		return true;
	}
	
	function reportErrors(errors) {
		var msg = "There were some problems...\n";
		var numError;
		for (var i = 0; i<errors.length; i++) {
			numError = i + 1;
			msg += "\n" + numError + ". " + errors[i];
		}
		
		alert(msg);
	}
</script>
</head>

<body>
<%@ include file="../header.jsp" %>
<%@ include file="form.jsp" %>
<%@ include file="../footer.jsp" %>
</body>
</html>