<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insert definition="standardDef" flush="true">
	<tiles:put name="title" value="Campus Traffic" type="string"/>

	<tiles:put name="head" type="string">
		<script type="text/javascript"
			    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCyghpoCtwoWIVDnTaOWba8PFyUGzEazGs">
		</script>
		<script type="text/javascript" src="javascript/jquery-1.11.1.min.js"></script>
		<script>
		var map;
		var markers = {};
		
		<logic:messagesPresent>
		alert("<html:messages id="error" message="false"><c:out value='${error}'></c:out>\n</html:messages>");
		</logic:messagesPresent>
		
		function init(){
			// Initialize coordinates to MSU center
			var latLng = new google.maps.LatLng(42.7230, -84.4810);
			var mapOptions = {
					center: latLng,
					zoom:17,
					mapTypeControl: false,
					panControl: false,
					streetViewControl: false,
					zoomControlOptions: {
						position: google.maps.ControlPosition.RIGHT_BOTTOM
					}
			};
			
			map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
			
			var lotInfoWindow = null;
			var marker = null;
			var info = null;
			var image;
			
			<%-- Code to add in each of the markers --%>
			<c:forEach var='lot' items='${parkingLots}' >
			// Marker for Lot ${lot.lotName}
			<c:choose>
			<c:when test='${lot.lotOpen eq "false" or (lot.curCars/lot.capacity) ge .95}'>image = "images/PMred.png";<c:set var="capacityText" value="red"/></c:when>
			<c:when test='${(lot.curCars/lot.capacity) ge .75}'>image = "images/PMorange.png";<c:set var="capacityText" value="orange"/></c:when>
			<c:when test='${(lot.curCars/lot.capacity) ge .50}'>image = "images/PMyellow.png";<c:set var="capacityText" value="yellow"/></c:when>
			<c:otherwise>image = "images/PMgreen.png";<c:set var="capacityText" value="green"/></c:otherwise>
			</c:choose>

			info = '<div class="info-window"><h2>Lot <c:out value="${lot.lotName}"></c:out></h2><p>status: <span class=\"${lot.lotOpen ? "green" : "red"}\">${lot.lotOpen ? "Open" : "Closed"}</span></p><p>capacity: <span class="${capacityText}"><c:out value="${lot.curCars}/${lot.capacity}"></c:out></span></p></div>';
			
			lotInfoWindow = new google.maps.InfoWindow();
			latLng = new google.maps.LatLng(${lot.xCoord}, ${lot.yCoord});
			marker = new google.maps.Marker({
				position: latLng,
				map: map,
				title: '<c:out value="${lot.lotName}"></c:out>',
				icon: image
			});
			google.maps.event.addListener(marker,'click',function(content, marker){
				return function() {
					lotInfoWindow.setContent(content);
					lotInfoWindow.open(map,marker);
				};
			}(info, marker));
			
			var name = "<c:out value="${lot.lotName}"></c:out>";
			markers[name] = marker;
			</c:forEach>
			
			<c:forEach var='obs' items='${obstructions}' >
			// Marker for ${obs.streetName} obstruction
			info = "<h2><c:out value="${obs.streetName}"></c:out></h2><p><c:out value="${obs.description}"></c:out></p>";
			lotInfoWindow = new google.maps.InfoWindow();
			latLng = new google.maps.LatLng(<c:out value="${obs.xCoord}"></c:out>, <c:out value="${obs.yCoord}"></c:out>);
			marker = new google.maps.Marker({
				position: latLng,
				map: map,
				title: "<c:out value="${obs.streetName}"></c:out>",
				icon: '<c:url value="images/obstructionmarker.png" />'
			});
			google.maps.event.addListener(marker,'click',function(content, marker){
				return function() {
					lotInfoWindow.setContent(content);
					lotInfoWindow.open(map,marker);
				};
			}(info, marker));
			
			var name = "<c:out value="${lot.lotName}"></c:out>";
			markers[name] = marker;
			</c:forEach>

		}
		
		function scrollToMarker(selection){
			if(selection != "none"){
				var marker = markers[selection];
				map.panTo(marker.getPosition());
				google.maps.event.trigger(marker, 'click');
			}
		}
		
		google.maps.event.addDomListener(window, 'load', init);
		</script>
		<link rel="stylesheet" type="text/css" href="css/mapStyle.css" />
	</tiles:put>
	<tiles:put name="body" type="string">
		<div id="search-div">
			<p>Jump to Lot</p>
			<select id="lot-select" onchange="scrollToMarker(this.value)">
				<option value="none">Select a lot</option>
				<c:forEach var='lot' items='${parkingLots}' >
				<option value="${lot.lotName}">Lot ${lot.lotName}</option>
				</c:forEach>
			</select>
		</div>
		<div id="map-container">
			<div id="map-canvas"></div>
		</div>
	</tiles:put>
</tiles:insert>