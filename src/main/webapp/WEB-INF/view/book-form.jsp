<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book form</title>
</head>
<body>
<h3>Save Book</h3>
<form:form action="saveBook" modelAttribute="book" method="POST">
    <form:hidden path="id"/>
    <table>
        <tbody>
        <tr>
            <td><label>Title:</label></td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td><label>Author name:</label></td>
            <td><form:input path="author"/></td>
        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save"></td>
        </tr>
        </tbody>
    </table>
</form:form>
</body>
</html>
