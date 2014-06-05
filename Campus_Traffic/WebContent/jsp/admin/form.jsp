

<div>
	
</div>

	<sql:setDataSource dataSource="jdbc/CampusTrafficDataSource"/>
	<sql:query var="obstructions">
		SELECT * FROM Obstructions
	</sql:query>
		<table>
			<tr>
				<th>Street Name</th>
				<th>X Coordinate</th>
				<th>Y Coordinate</th>
				<th>Description</th>
			</tr>
			<c:forEach var='obstruction' begin='0' items='${obstructions.rows}'>
				<form method='post' action='${pageContext.request.contextPath}/Admin'>
					<tr>
						<td><input type="text" name="${obstruction.Street_Name}" value="${obstruction.Street_Name}"/></td>
						<td><input type="text" name="${obstruction.X_Coord}" value="${obstruction.X_Coord}"/></td>
						<td><input type="text" name="${obstruction.Y_Coord}" value="${obstruction.Y_Coord}"/></td>
						<td><input type="text" name="${obstruction.Description}" value="${obstruction.Description}"/></td>
						<td><input type="submit" name="edit" value="Edit"/></td>
						<td><input type="submit" name="remove" value="Remove"/></td>
					</tr>
				</form>
			</c:forEach>
			<form id='obstructionInsertForm' method='post' action='${pageContext.request.contextPath}/Admin' onsubmit="return validate(this);">
				<tr>
				 <td><input id="streetName" type="text" name="streetName"/></td>
				 <td><input id="xCoord" type="text" name="xCoord"/></td>
				 <td><input id="yCoord" type="text" name="yCoord"/></td>
				 <td><input id="obstructionDescription" name="obstructionDescription" /></td>
				 <td colspan="2"><input type="submit" name="obstructionSubmit" value="Insert"></td>
				</tr>
			</form>
		</table>

<%--  Obstruction Remove Form
<div>
	<form id='obstructionRemoveForm' method='post' action='${pageContext.request.contextPath}/Admin'>
	<fieldset>
	  <table width='500'>
		  <tbody>
			<tr>
			 <td>
			 Street Name: 
			 <input id="streetName" type="text" name="streetName"/>
			 </td>
			</tr>
			
			<tr>
			 <td>
			  <input type="submit" name="obstructionSubmit" value="Submit Removes">
			 </td>
			</tr>
		  </tbody>
	  </table>
	</fieldset>
	</form>
</div> --%>