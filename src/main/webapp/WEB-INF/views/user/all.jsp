<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 27.08.18
  Time: 09:55
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
<%@include file="user_menu.jsp" %></br>


<table>
    <thead>
    <tr>

        <td>Id</td>
        <td>Name</td>
        <td>PIN</td>
        <td>Salary</td>
    </tr>
    </thead>
    <c:forEach items="${users}" var="budget">
        <tr>
            <td> ${budget.id} </td>
            <td> ${budget.name} </td>
            <td> ${budget.pin} </td>
            <td> ${budget.salary}</td>
            <td>
                <a href="/user/delete/${budget.id}">delete</a>
                <a href="/user/edit/${budget.id}">edit</a>
            </td>
        </tr>
    </c:forEach>

</table>

<%@include file="../footer.jsp" %></br>

</body>
</html>