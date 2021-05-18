<%--
  Created by IntelliJ IDEA.
  User: filip
  Date: 12.05.2021
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Category Form</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <div>
    <label for="name">Category Name</label>
    <form:input id="name" path="name"/>
    <form:errors path="name"/>
    </div>
    <div>
    <label for="description">Category Description </label>
    <form:input id="description" path="description"/>
    <form:errors path="description"/>
    </div>
    <div>
        <label for="isActive">is Category Active</label>
        <form:checkbox id="isActive" path="isActive"/>
        <form:errors path="isActive"/>
    </div>
    <div>
        <input type="submit">
    </div>
    <div>
        <form:errors path="*"/>
    </div>
</form:form>
</body>
</html>
