<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% 
if (session.getAttribute("email")==null) {
	response.sendRedirect("/home");
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Notes</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
	<div id="banner">
		<div>
			<h1>SmartNotes</h1>
		</div>
		<div>
			<h3 onclick="window.location='/smart_notes/student/logOut'">LogOut</h3>
		</div>
	</div>
	<div style="margin-right: 25%" style="margin-top:100px">
		 <form:form action="saveNotes" modelAttribute="notes" method="POST">
		 
		 <input type="hidden" name="courseId" value="${course.id}" />
		 <input type="hidden" name="notesId" value="${notes.id}" />
			<table  style="position:relative;" class="form">
				<tr>
					<td>
						<h3>
							${course.courseTitle }
						</h3>
					</td>
				</tr>

				<tr>

					<td colspan=><form:textarea path="description" maxlength="200" rows="2" cols="108"
							id="notesDescription" placeholder="Description"/></td>
				</tr>
				<tr>
					<td>Notes:</td>
				</tr>
				<tr>
					<td colspan="3"><form:textarea path="text" rows="40" cols="108" id="notesBody" /></td>
				</tr>
				<tr>
					<td colspan="3" align="right"><input class="Button"
						type="submit" value="Add Notes"></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>
