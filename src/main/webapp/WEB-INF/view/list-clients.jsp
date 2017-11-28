<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>All clients</title>
</head>
<body>
<input type="button" value="Add Customer" onclick="window.location.href='addClient'; return false;"
       class="add-button"/>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Login</th>
        <th>Password</th>
    </tr>
    <c:forEach var="tempClient" items="${clients}">
        <tr>
            <c:url var="updateLink" value="/admin/updateClient">
                <c:param name="clientId" value="${tempClient.id}"/>
            </c:url>

            <c:url var="deleteLink" value="/admin/deleteClient">
                <c:param name="clientId" value="${tempClient.id}"/>
            </c:url>
            <td>${tempClient.firstName}</td>
            <td>${tempClient.lastName}</td>
            <td>${tempClient.login}</td>
            <td>${tempClient.password}</td>
            <td><a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
