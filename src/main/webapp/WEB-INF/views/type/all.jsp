<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>

<%@include file="../header.jsp" %>

<h1>Type List</h1>

<table>
    <thead>
    <tr>
        <td>Name</td>
        <td>Operation</td>
    </tr>
    </thead>
    <c:forEach items="${types}" var="type">
        <tr>
            <td>${type.name}</td>
            <td>
                <a href="/type/delete/${type.id}">Delete</a>
                <a href="/type/edit?id=${type.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td></td>
        <td><a href="/type/add">Add</a></td>
    </tr>
</table>

</body>
</html>
