<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 27.08.18
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../resources/static/css/style.css">

</head>
<body>
<%@include file="../header.jsp" %>


<table>
    <thead>
    <tr>

        <td>id</td>
        <td>name</td>
        <td>saldo</td>
        <td>Akcja</td>

    </tr>
    </thead>
    <c:forEach items="${budget}" var="a">
        <tr>
            <td> ${a.id} </td>
            <td> ${a.name} </td>
            <td>${a.saldo} </td>
            <td>
                <a href="/budget/delete/${a.id}">delete</a>
                <a href="/budget/edit/${a.id}">edit</a>
            </td>
        </tr>
    </c:forEach>

</table>

<%@include file="../footer.jsp" %></br>



</body>
</html>
