<div>
	<form id='obstructionInsertForm' method='post' action='${pageContext.request.contextPath}/Admin'
		  onsubmit="return validate(this);">
	<fieldset>
	  <table width='500'>
		  <tbody>
			<tr>
			 <td>
			 Obstruction on Street: 
			 <input id="streetName" type="text" name="streetName"/>
			 </td>
			</tr>
			<tr>
			 <td>
			 	X-Coord: 
			 <input id="xCoord" type="text" name="xCoord"/>
			 </td>
			 <td>
			 	Y-Coord:
			 <input id="yCoord" type="text" name="yCoord"/>
			 </td>
			</tr>
			<tr>
			 <td>
				<textarea id="obstructionDescription" cols="20" rows="2" name="obstructionDescription" form="obstructionInsertForm"></textarea>
			 </td>
			</tr>
			<tr>
			 <td>
			  <input type="submit" name="obstructionSubmit" value="Submit Insert">
			 </td>
			</tr>
		  </tbody>
	  </table>
	</fieldset>
	</form>
</div>
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