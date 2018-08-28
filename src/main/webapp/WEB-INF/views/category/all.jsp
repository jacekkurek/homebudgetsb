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
    <title>All categories</title>
    <link rel="stylesheet" href="../../../../resources/static/css/style.css">
</head>
<body>
<%@include file="../header.jsp"%></br>
<%@include file="category_menu.jsp"%></br>
<h1>All categories</h1>

<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Budget</td>
    </tr>
    </thead>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td> ${category.id} </td>
            <td> ${category.name} </td>
            <td> ${category.budget.name}</td>
            <td>
                <a href="/category/delete/${category.id}">delete</a>
                <a href="/category/edit/${category.id}">edit</a>
            </td>
        </tr>
    </c:forEach>

</table>

<%@include file="../footer.jsp" %>


</body>
</html>