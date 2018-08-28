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

<%@include file="../header.jsp" %>
<%@include file="transaction_menu.jsp" %>

<table>
    <thead>
    <tr>
        <td>id</td>
        <td>timeAdded</td>
        <td>timeTransaction</td>
        <td>name</td>
        <td>value</td>
        <td>user</td>
        <td>Akcja</td>
    </tr>
    </thead>
    <c:forEach items="${transactions}" var="transaction">
        <tr>
            <td>${transaction.id}</td>
            <td>${transaction.timeAdded}</td>
            <td>${transaction.timeTransaction}</td>
            <td>${transaction.name}</td>
            <td>${transaction.value}</td>
            <td>${transaction.user.name}</td>
            <td>
                <a href="/transaction/delete/${transaction.id}">delete</a>
                <a href="/transaction/edit/${transaction.id}">edit</a>
            </td>
        </tr>
    </c:forEach>

</table>

<%@include file="../footer.jsp" %>

</body>
</html>
