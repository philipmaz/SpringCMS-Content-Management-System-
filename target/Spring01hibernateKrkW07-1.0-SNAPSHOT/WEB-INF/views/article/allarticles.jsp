<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Articles List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>ID</th>
    <th>Title</th>
    <th>Author</th>
    <th>Categories</th>
    <th>Content</th>
    <th>Created</th>
    <th>Updated</th>
    </thead>
    <tbody>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td><c:out value="${article.id}"/></td>
            <td><c:out value="${article.title}"/></td>
            <td><c:out value="${article.author}"/></td>
            <td><c:out value="${article.categories}"/></td>
            <td><c:out value="${article.content}"/></td>
            <td><c:out value="${article.created}"/></td>
            <td><c:out value="${article.updated}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

