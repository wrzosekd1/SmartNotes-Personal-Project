<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
if (session.getAttribute("email")==null) {
	response.sendRedirect("/home");
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
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
	<h1 style="margin-top: 60px; margin-left: 400px;">
		Welcome
		<%= session.getAttribute("email") %>
	</h1>
	<table style="width: 40%;" class="classTable" align="center">
		<!-- set column widths-->
		<col style="width: 15%">
		<col style="width: 60%">
		<col style="width: 15%">
		<col style="width: 10%">
		<tr>
			<th>Course Number</th>
			<th>Course Title</th>
			<th>Semester</th>
			<th>Action</th>
		</tr>

		<!-- loop over and print our customers -->
		<c:forEach var="tempCourse" items="${courses}">

			
			<c:url var="viewLink" value="/student/viewCourse">
				<c:param name="courseId" value="${tempCourse.id}" />
			</c:url>

			<c:url var="deleteLink" value="/student/deleteCourse">
				<c:param name="courseId" value="${tempCourse.id}" />
			</c:url>

			<tr>
				<td>${tempCourse.courseNumber}</td>
				<td>${tempCourse.courseTitle}</td>
				<td>${tempCourse.semester}</td>
				<td><a href="${viewLink}">View</a>
				|
				<a href="${deleteLink}"
					onclick="if(!(confirm('Are you sure you want to delete this course?'))) return false">Delete</a></td>
			</tr>
		</c:forEach>

	</table>
	<input style="margin-left: 1200px; margin-top: 20px;" class="Button"
		type="submit" value="Add New Class"
		onclick="window.location='/smart_notes/student/addCourse';">





</body>
</html>
