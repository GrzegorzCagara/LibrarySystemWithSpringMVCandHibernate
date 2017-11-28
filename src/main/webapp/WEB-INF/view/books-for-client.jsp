<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>All books</title>
</head>
<body>
<input type="button" value="Home Page" onclick="window.location.href='clientPanel'; return false;"/>
<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
    </tr>
    <c:forEach var="tempBook" items="${books}">
        <tr>
            <c:url var="makeReservation" value="/reservation">
                <c:param name="bookId" value="${tempBook.id}"/>
                <c:param name="clientId" value="${tempBook.id}"/>
            </c:url>

            <td>${tempBook.title}</td>
            <td>${tempBook.author}</td>
            <td>
                <a href="${makeReservation}"
                   onclick="if (!(confirm('Are you sure you want to book this book?'))) return false">Make Reservation</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
