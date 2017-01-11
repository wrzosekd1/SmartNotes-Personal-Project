<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <h1>SmartNotes</h1>
</div>
<div id="container">
    <div id="welcome">
        <h1>Welcome to SmartNotes</h1>
    </div>
    <div id="forms">
        <div id="login">
            <!-- LOGIN FORM-->
            <form:form action="logIn" modelAttribute="student" method="POST">
                <table>
                    <tr>
                        <td><strong>Sign in with existing account</strong></td>
                    </tr>
                    <tr>
                        <td><form:input path="email" class="TextFields" type="text" placeholder="Email" /></td>
                    </tr>
                    <tr>
                        <td><form:input path="password" class="TextFields" type="password" placeholder="Password" /></td>
                    </tr>
                    <tr>
                        <td align="right"><input class="Button" type="submit" value="Sign In"></td>
                    </tr>
                    <tr>
                    	<td>${logInMessage}</td>
                    </tr>
                    
                </table>
            </form:form>
        </div>
        <!-- REGISTER FORM-->
        <div id="register" >
            <form:form action="addUser" modelAttribute="student" method="POST">
                <table>
                    <tr>
                        <td>Don't have an account?</td>
                    </tr>
                    <tr>
                        <td><strong>Create Account</strong></td>
                    </tr>
                    <tr>
                        <td><form:input path="firstName" class="TextFields" placeholder="First Name" autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td><form:input path="lastName" class="TextFields" placeholder="Last Name" autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td><form:input path="school" class="TextFields" placeholder="School"  autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td><form:input path="email" class="TextFields" placeholder="Email"  autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td><form:input path="password" class="TextFields" placeholder="Password" type="password" autocomplete="off"/></td>
                    </tr>
                    <tr>
                        <td align="right"><input class="Button" type="submit" value="Sign Up"></td>
                    </tr>
                    <tr>
                    	<td>${registerMessage}</td>
                    </tr>
                              
                </table>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
