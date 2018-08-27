<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>

<h1>Types List</h1>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
    </tr>
    </thead>
    <c:forEach items="${types}" var="type">
        <tr>
            <td> ${type.id} </td>
            <td> ${type.name}</td>
            <td>
                <a class="confirm" href="/type/delete/${type.id}">delete</a>
                <a class="confirm" href="/type/update?id=${type.id}">edit</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
