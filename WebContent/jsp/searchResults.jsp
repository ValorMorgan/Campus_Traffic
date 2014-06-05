<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt'
	prefix='fmt' %>
	<%@ taglib uri='http://java.sun.com/jsp/jstl/core'
	prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JavaTunes Search Results</title>
	<script type="text/javascript"
	      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCyghpoCtwoWIVDnTaOWba8PFyUGzEazGs">
	</script>
	<script>
	function init(){
		var latLng = new google.maps.LatLng(${xCoord},${yCoord});
		var mapOptions = {
				center: latLng,
				zoom:16
		};
		
		var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
		
		var lotOpen = ${yourLot.lotOpen} ? '<p>Yes!</p>' : '<p>No D:</p>';
		
		var lotInfo = '<div><h1>Lot: ${yourLot.lotName}</h1><p>Lot ${yourLot.lotName} is open?</p>' + lotOpen + '</div>';
		
		var lotInfoWindow = new google.maps.InfoWindow({content:lotInfo});
		
		var marker = new google.maps.Marker({
			position: latLng,
			map: map,
			title: '${yourLot.lotName}'
		});
		
		google.maps.event.addListener(marker,'click',function(){
			lotInfoWindow.open(map,marker);
		});
	}
	google.maps.event.addDomListener(window, 'load', init);
	</script>
</head>
<body>
<center>
	<%@ include file="/jsp/header.jsp" %>
	<h2>Searched lot: ${yourLot.lotName}</h2>
	<p>
		 ${xCoord} - ${yCoord} - ${yourLot.totalCapacity} - ${yourLot.numberVehicles} - ${yourLot.lotOpen}
	</p>
	<%--<c:forEach items='${oList}' var='oItem'>
		  Obstruction X: <c:out value='${oItem.xCoord}' />
	</c:forEach>--%>
	<div id="map-canvas" style="width:500px;height:300px"></div>
	<a href="${pageContext.request.contextPath}">Go Home</a>
</center>
</body>
</html>