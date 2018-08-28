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
<%@include file="transaction_menu.jsp" %></br>

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
    <c:forEach items="${transactions}" var="budget">
        <tr>
            <td> ${budget.id} </td>
            <td> ${budget.time_added} </td>
            <td>${budget.time_transaction} </td>
            <td>${budget.name}</td>
            <td>${budget.value}</td>
            <td>
                <a href="/transaction/delete/${budget.id}">delete</a>
                <a href="/transaction/edit/${budget.id}">edit</a>
            </td>
        </tr>
    </c:forEach>

</table>


<%@include file="../footer.jsp" %></br>

</body>
</html>
