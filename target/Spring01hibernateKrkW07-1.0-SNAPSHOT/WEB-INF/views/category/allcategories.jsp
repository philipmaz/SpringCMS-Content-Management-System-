<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Categories List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Description</th>
    <th>isActive</th>
    <th>Activity</th>
    <th>Show</th>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td><c:out value="${category.id}"/></td>
            <td><c:out value="${category.name}"/></td>
            <td><c:out value="${category.description}"/></td>
            <td><c:out value="${category.isActive}"/></td>
            <td><a href="//localhost:8080/SpringCMS_war_exploded/cat/${category.id}/change">Activate/Deactivate</a></td>
            <td><a href="//localhost:8080/SpringCMS_war_exploded/article/${category.id}/articlesbycat">Show articles by this category</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <a href="http://localhost:8080/SpringCMS_war_exploded/article/all">Show All Articles</a>
</div>
</body>
</html>

