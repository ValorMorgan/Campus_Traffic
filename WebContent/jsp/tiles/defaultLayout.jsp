<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<title><tiles:getAsString name="title"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<tiles:insert attribute="head"/>
</head>
<body>
<tiles:insert attribute="header"/>
<tiles:insert attribute="body"/>
</body>
</html:html>