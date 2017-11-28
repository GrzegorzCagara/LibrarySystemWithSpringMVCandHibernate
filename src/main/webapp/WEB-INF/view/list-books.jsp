<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>All books</title>
</head>
<body>
<input type="button" value="Add Book" onclick="window.location.href='addBook'; return false;"
       class="add-button"/>
<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
    </tr>
    <c:forEach var="tempBook" items="${books}">
        <tr>
            <c:url var="updateLink" value="/admin/updateBook">
                <c:param name="bookId" value="${tempBook.id}"/>
            </c:url>

            <c:url var="deleteLink" value="/admin/deleteBook">
                <c:param name="bookId" value="${tempBook.id}"/>
            </c:url>
            <td>${tempBook.title}</td>
            <td>${tempBook.author}</td>
            <td><a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
