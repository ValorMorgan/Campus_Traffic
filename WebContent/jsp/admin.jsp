<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insert definition="standardDef" flush="true">
	<tiles:put name="title" value="Campus Traffic - ADMIN" type="string"/>
	
	<tiles:put name="head" type="string">
		<link rel="stylesheet" type="text/css" href="css/adminStyle.css" />
		<script type="text/javascript" src="javascript/jquery-1.11.1.min.js"></script>
	</tiles:put>
	
	<tiles:put name="body" type="string">
		<div class="wrapper">
			<div id="maincontent">
			<div id="pushDown"></div>
				<html:messages id="error" message="false" header="errors.header" footer="errors.footer">
			    	<li>${error}</li>
			    </html:messages>
			    
				<table id="obstructionSet">
					<tr>
						<th colspan=4>Obstructions</th>
					</tr>
					<tr>
						<th>Street Name</th>
						<th>Latitude</th>
						<th>Longitude</th>
						<th>Description</th>
					</tr>
					<c:forEach var='obstruction' items='${obstructions}'>
						<html:form action="/adminObstructions">
							<tr>
								<html:hidden property="ID" value="${obstruction.id}"/>
								<td><html:text property="streetName" value="${obstruction.streetName}" size="15"/></td>
								<td><html:text property="xCoord" value="${obstruction.xCoord}" size="10" maxlength="10"/></td>
								<td><html:text property="yCoord" value="${obstruction.yCoord}" size="10" maxlength="10"/></td>
								<td><html:text property="description" value="${obstruction.description}" size="20" maxlength="80"/></td>
								<td><html:submit property="Edit" value="Edit" onclick="return confirm('Are you sure you want to submit?')"/></td>
								<td><html:submit property="Remove" value="Remove" onclick="return confirm('Are you sure you want to submit?')"/></td>
							</tr>
						</html:form>
					</c:forEach>
					<html:form action="/adminObstructions">
						<tr>
						 <td><html:text property="streetName" value="${old_streetName}" size="15"/></td>
						 <td><html:text property="yCoord" value="${old_yCoord}" size="10" maxlength="10"/></td>
						 <td><html:text property="xCoord" value="${old_xCoord}" size="10" maxlength="10"/></td>
						 <td><html:text property="description" value="${old_description}" size="20" maxlength="80"/></td>
						 <td><html:submit property="Add" value="Add" onclick="return confirm('Are you sure you want to submit?')"/></td>
						</tr>
					</html:form>
				</table>
			
				<table id="parkingLotSet">
					<tr>
						<th colspan=6>Parking Lots</th>
					</tr>
					<tr>
						<th width="50px">Lot Name</th>
						<th width="80px">Latitude</th>
						<th width="80px">Longitude</th>
						<th width="50px">Capacity</th>
						<th width="50px">Number Vehicles</th>
						<th width="50px">Lot Open?</th>
					</tr>
					<c:forEach var='parkingLot' items='${parkingLots}'>
						<html:form action="/adminParkingLots">
							<tr>
								<td><html:text property="lotName" value="${parkingLot.lotName}" readonly="true" size="5"/></td>
								<td><html:text property="xCoord" value="${parkingLot.xCoord}" readonly="true" size="10" maxlength="10"/></td>
								<td><html:text property="yCoord" value="${parkingLot.yCoord}" readonly="true" size="10" maxlength="10"/></td>
								<td><html:text property="capacity" value="${parkingLot.capacity}" size="4" maxlength="4"/></td>
								<td><html:text property="vehicles" value="${parkingLot.curCars}" size="4" maxlength="4"/></td>
								<td><html:select property="lotOpen" value="${parkingLot.lotOpen}">
									<html:option value="false">False</html:option>
									<html:option value="true">True</html:option>
								</html:select></td>
								<td><html:submit property="Edit" value="Edit" onclick="return confirm('Are you sure you want to submit?')"/></td>
							</tr>
						</html:form>
					</c:forEach>
				</table>
			<div id="push"></div>
			</div>
		</div>
	</tiles:put>
</tiles:insert>