<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Campus Traffic - Admin Login</title>

<script type="text/javascript">
	function validate(form) {
		var loginId = form.loginId.value;
		var loginPass = form.loginPass.value;
		var errors = [];
		
		if(!checkLength(loginId)) {
			errors.push("You must enter a username.");
		}
		if(!checkLength(loginPass)) {
			errors.push("You must enter a password.");
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
<center>
<%@ include file='/jsp/header.jsp' %>

<!-- Failed log in message -->

<%@ include file="form.jsp" %>

<%@ include file='/jsp/footer.jsp' %>
</center>
</body>
</html>