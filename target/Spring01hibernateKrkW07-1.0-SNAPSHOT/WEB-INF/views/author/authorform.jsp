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
    <title>Author Form</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <div>
        <label for="firstName">Author First Name</label>
        <form:input id="firstName" path="firstName"/>
        <form:errors path="firstName" cssClass="error" element="div"/>
    </div>
    <div>
        <label for="lastName">Author Last Name</label>
        <form:input id="lastName" path="lastName"/>
        <form:errors path="lastName" cssClass="error" element="div"/>
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
