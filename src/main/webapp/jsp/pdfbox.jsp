<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>

<script type="text/javascript">

	document.addEventListener('DOMContentLoaded', function(){ 
		changeChoice(document.getElementById('uploadPdfBox_choosedChoice').value);
	}, false);

	function changeChoice(id) {
		if(id == '0') {
			document.getElementById('divSuppr').style.display = "none";
			document.getElementById('divAdd').style.display = "none";
		}
		// Ajout
		if(id == '1') {
			document.getElementById('divSuppr').style.display = "none";
			document.getElementById('divAdd').style.display = "block";
		}
		// Suppression
		if(id == '2') {
			document.getElementById('divSuppr').style.display = "block";
			document.getElementById('divAdd').style.display = "none";
		}
	}
</script>

</head>
<body>

	<s:if test="%{getErrors().isEmpty()}">
		<!-- no errors -->
	</s:if>
	<s:else>
		<table>
			<s:iterator value="errors" var="vvv">
				<tr><td style="color:red;"><s:property/></td></tr>
			</s:iterator>
		</table>
	</s:else>

	<s:form action="uploadPdfBox" method="post" enctype="multipart/form-data">
	
		<table>
			<tr style="display:block;">
				<td>Que faire ?</td>
				<td><s:select list="choices" listKey="id" listValue="label" name="choosedChoice" onchange="changeChoice(this.value);"></s:select></td>
			</tr>
			
			<tr id="divOriginalFile" style="display:block;">
				<td>Fichier PDF d'origine :</td>
				<td><s:file name="originalPdfFile"/></td>
			</tr>
			
			<tr id="divAdd" style="display:none;">
				<td>Fichier PDF à ajouter :</td>
				<td><s:file name="fileToAddPdfFile"/></td>
			</tr>
			
			<tr id="divSuppr" style="display:none;">
				<td>Suppr</td>
				<td>Suppr</td>
			</tr>
		</table>
		
		<s:submit value="Lancer l'action"/>
	</s:form>
</html>
</body>