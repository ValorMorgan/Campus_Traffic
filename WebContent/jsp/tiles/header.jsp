<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/headerStyle.css">
<div id="header">
	<a href="http://www.msu.edu"><img alt="Michigan State University" src="images/MSU-Wordmark-White-120-pxls.gif" /></a>
	<c:choose>
		<c:when test="${not empty username}">
			<div id="nav">
				<ul class="no-js">
					<li>
						<a href="#" class="click">Welcome, ${username} <span style="font-size: .75em;">&#x25BC;</span></a>
						<ul>
							<li><html:link action="/map">Campus Map</html:link></li>
							<li><html:link action="/admin">Edit Markers</html:link></li>
							<li><html:link action="/logout">Logout</html:link></li>
						</ul>
					</li>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			<div id="nav">
				<ul class="no-js">
					<li>
						<a href="#" class="click">Log in <span style="font-size: .75em;">&#x25BC;</span></a>
						<html:form action="/logon" styleId="loginForm">
							<html:text property="name" styleId="namefield"/>
							<html:password property="password" styleId="passfield" />
							<html:submit value="Login" styleId="submit" />
						</html:form>
					</li>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>
	<div style="clear: both;"></div>
	<script type="text/javascript" src="javascript/menuClick.js"></script>
</div>