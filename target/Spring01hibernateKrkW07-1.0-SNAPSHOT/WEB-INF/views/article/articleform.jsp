<%--
  Created by IntelliJ IDEA.
  User: filip
  Date: 25.04.2021
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Article add form binded</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    <form:hidden path="id"/>
    <div>
        <label for="title">Title</label>
        <form:input id="title" path="title"/>
        <form:errors path="title" cssClass="error"/>
    </div>
    <div>
        <label for="author">Author</label>
        <form:select id="author" path="author" items="${authors}" itemLabel="lastName" itemValue="id"/>
        <form:errors path="author" cssClass="error"/>
    </div>
    <div>
        <label for="categories">Categories</label>
        <form:select id="categories" path="categories" items="${categories}" itemLabel="name" itemValue="id" multiple="true"/>
        <form:errors path="categories" cssClass="error"/>
    </div>
    <div>
        <label for="content">Content</label>
        <form:textarea id="content" path="content"/>
        <form:errors path="content" cssClass="error"/>
    </div>
    <div>
        <label for="created">Created</label>
        <form:input id="created" path="created" type="date"/>
        <form:errors path="created" cssClass="error"/>
    </div
    <div>
        <label for="updated">Updated</label>
        <form:input id="updated" path="updated" type="date" />
        <form:errors path="updated" cssClass="error"/>
    </div>
    <div>
        <form:errors path="*" element="div" cssClass="error"/>
    </div>
    <div>
        <input type="submit">
    </div>

    <div>
        <a href="http://localhost:8080/SpringCMS_war_exploded/article/4/edit">Edit Book by id</a>
    </div>
    <div>
        <a href="http://localhost:8080/SpringCMS_war_exploded/article/4/delete">Delete Book by id</a>
    </div>
</form:form>
</body>
</html>