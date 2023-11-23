<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/24/2023
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Form</title>
</head>
<body>
<form action="/phones?action=create" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>

        <tr>
            <td>Brand</td>
            <td><input type="text" name="brand"></td>
        </tr>

        <tr>
            <td>color</td>
            <td><input type="text" name="color"></td>
        </tr>

        <tr>
            <td>Price</td>
            <td><input type="number" name="price"></td>
        </tr>

        <tr>
            <td>UrlImage</td>
            <td><input type="text" name="urlImage"></td>
        </tr>
        <input type="submit" value="create">
    </table>

    <a href="phones?action=phones">Back to Home</a>

</form>
</body>
</html>
