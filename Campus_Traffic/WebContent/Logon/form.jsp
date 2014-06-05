<form method='post' action='${pageContext.request.contextPath}/login'
	  onsubmit="return validate(this);">
  <table width='500'>
  <tbody>
	<tr>
	 <td>
	 UserID: 
	 <input type="text" name="loginId"/>
	 </td>
	</tr>
	<tr>
	 <td>
	 Password: 
	 <input type="text" name="loginPass"/>
	 </td>
	</tr>
	<tr>
	 <td>
	  <input type="submit" name="logMeIn" value="logIn">
	 </td>
	</tr>
  </tbody>
  </table>
</form>