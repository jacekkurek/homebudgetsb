<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>

<%@include file="../header.jsp" %>
<%@include file="type_menu.jsp"%>

<h1>All Types</h1>

<table>
    <thead>
    <tr>
        <td>Name</td>
        <td>Action</td>
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
</table>

<%@include file="../footer.jsp" %>

</body>
</html>
