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
    <title>All subcategories</title>
    <link rel="stylesheet" href="../../../../resources/static/css/style.css">
</head>
<body>
<%@include file="../header.jsp"%></br>
<%@include file="subcategory_menu.jsp"%></br>
<h1>All subcategories</h1>

<table>
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>category</td>
    </tr>
    </thead>
    <c:forEach items="${subcategories}" var="subcategory">
        <tr>
            <td> ${subcategory.id} </td>
            <td> ${subcategory.name} </td>
            <td> ${subcategory.category.name} </td>
            <td>
                <a href="/category/delete/${subcategory.id}">delete</a>
                <a href="/category/edit/${subcategory.id}">edit</a>
            </td>
        </tr>
    </c:forEach>

</table>

<%@include file="../footer.jsp" %>


</body>
</html>