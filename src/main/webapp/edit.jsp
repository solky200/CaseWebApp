<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/1/2023
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="/phones?action=edit" method="post">
    <p>
        <input type="text" name="id" value="${phone.id}">
    </p>
    <p>
        <input type="text" name="name" value="${phone.name}">
    </p>
    <p>
        <input type="text" name="brand" value="${phone.brand}">
    </p>
    <p>
        <input type="text" name="color" value="${phone.color}">
    </p>
    <p>
        <input type="number" name="price" value="${phone.price}">
    </p>
    <p>
        <input type="text" name="urlImage" value="${phone.urlImage}">
    </p>
    <p>
        <input type="submit" value="edit">
    </p>
</form>
<a href="/phones">Back to Home</a>
</body>
</html>
