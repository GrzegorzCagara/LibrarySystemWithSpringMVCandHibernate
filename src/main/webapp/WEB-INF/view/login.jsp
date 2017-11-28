<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <form:form action="login" modelAttribute="client" method="POST">
        <table>
            <tbody>
            <tr>
                <td><label>Login:</label></td>
                <td><form:input path="login"/></td>
            </tr>
            <tr>
                <td><label>Password:</label></td>
                <td><form:input path="password"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Login" class="btn btn-success">
                    <a href="<c:url value="/addClient"/>" class="btn btn-primary">Register</a>
                </td>

            </tr>
            </tbody>
        </table>
    </form:form>
</body>
</html>
