<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% 
if (session.getAttribute("email")==null) {
	response.sendRedirect("home");
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SmartNotes</title>
    <link 	type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div id="banner">
    <div><h1>SmartNotes</h1></div>
    <div><h3 onclick="window.location='/smart_notes/student/logOut'">LogOut</h3></div>
</div>
<div align="center" style="margin-top: 100px">
    <form:form action="addCourse" modelAttribute="course" method="POST">
        <table class="form" >
            <tr>
                <td><strong>Add a new class</strong></td>
            </tr>
            <tr>
                <td><form:input path="courseNumber" class="TextFields" type="text" placeholder="Course Number" /></td>
            </tr>
            <tr>
                <td><form:input path="courseTitle" class="TextFields" type="text" placeholder="Course Title"/></td>
            </tr>
            <tr>
                <td><form:input path="school" class="TextFields" type="text" placeholder="University"  /></td>
            </tr>
            <tr>
                <td><form:input path="semester" class="TextFields" type="text" placeholder="Semester" /></td>
            </tr>
            <tr>
                <td align="right"><input class="Button" type="submit" value="Add Class"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>