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
<%@include file="budget_menu.jsp" %></br>


<table>
    <thead>
    <tr>

        <td>Id</td>
        <td>Name</td>
        <td>Description</td>
        <td>Users</td>
        <td>Akcja</td>


    </tr>
    </thead>
    <c:forEach items="${budgets}" var="budget">
        <tr>
            <td> ${budget.id} </td>
            <td> ${budget.name} </td>
            <td>${budget.description} </td>
            <td><c:forEach items="${budget.users}" var="a">
                ${a.name},
            </c:forEach></td>
            <td>
                <a href="/budget/delete/${budget.id}">delete</a>
                <a href="/budget/edit/${budget.id}">edit</a>
            </td>
        </tr>
    </c:forEach>

</table>

<%@include file="../footer.jsp" %></br>


</body>
</html>
