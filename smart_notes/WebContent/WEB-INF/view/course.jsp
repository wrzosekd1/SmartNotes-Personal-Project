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
    <title>SmartNotes</title>
   <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div id="banner">
    <div><h1>SmartNotes</h1></div>
    <div><h3 onclick="window.location='/smart_notes/student/logOut'">LogOut</h3></div>
</div>
<div id="containerClassInfo">
    <div id="courseInfo">
        <h1>Course Info</h1>
            <h4>${course.courseNumber}</h4>
            <h4>${course.courseTitle}</h4>
            <h4>${course.school}</h4>
            <h4>${course.semester}</h4>
            
    </div>
    <div id="notes" >
        <table  class="classTable">
            <col style="500px">
            <col style="100px">
            <tr>
                <th>Description</th>
                <th>Action</th>
            </tr>
            <c:forEach var="tempNotes" items="${notes}">

			
			<c:url var="viewLink" value="/student/viewNotes">
				<c:param name="notesId" value="${tempNotes.id}" />
				<c:param name="courseId" value="${tempNotes.courseId}" />
			</c:url>

			<c:url var="deleteLink" value="/student/deleteNotes">
				<c:param name="notesId" value="${tempNotes.id}" />
			</c:url>

			<tr>
				<td>${tempNotes.description}</td>
				<td><a href="${viewLink}">View</a>
				|
				<a href="${deleteLink}"
					onclick="if(!(confirm('Are you sure you want to delete these notes?'))) return false">Delete</a></td>
			</tr>
		</c:forEach>
            
            
        </table>
        <input style="margin-top: 30px" class="Button" type="submit" value="Add More Notes"  onclick="window.location='/smart_notes/student/addNotes?id=${course.id}';">
    </div>
</div>

</body>
</html>