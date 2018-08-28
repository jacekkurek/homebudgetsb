<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 27.08.18
  Time: 14:32
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

<%@include file="../header.jsp" %></br>

<table>
    <thead>
    <tr>

        <td>id</td>
        <td>time_added</td>
        <td>time_transaction</td>
        <td>name</td>
        <td>value</td>
        <td>Akcja</td>
    </tr>
    </thead>
    <c:forEach items="${transactions}" var="a">
        <tr>
            <td> ${a.id} </td>
            <td> ${a.time_added} </td>
            <td>${a.time_transaction} </td>
            <td>${a.name}</td>
            <td>${a.value}</td>
            <td>
                <a href="/transaction/delete/${a.id}">delete</a>
                <a href="/transaction/edit/${a.id}">edit</a>
            </td>
        </tr>
    </c:forEach>

</table>


<%@include file="../footer.jsp" %></br>

</body>
</html>