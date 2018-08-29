<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

        <td>Id</td>
        <td>Time Added</td>
        <td>Time Transaction</td>
        <td>Name</td>
        <td>Value</td>
        <td>user</td>
        <td>budget</td>
        <td>category</td>
        <td>subcategory</td>
        <td>type</td>
        <td>Action</td>
    </tr>
    </thead>
    <c:forEach items="${raports}" var="raport">
        <tr>
            <td>${raport.id}</td>
            <td>${raport.timeAdded}</td>
            <td>${raport.timeTransaction}</td>
            <td>${raport.name}</td>
            <td>${raport.value}</td>
            <td>${raport.user.name}</td>
            <td>${raport.budget.name}</td>
            <td>${raport.category.name}</td>
            <td>${raport.subcategory.name}</td>
            <td>${raport.type.name}</td>
            <td>
                <a href="/transaction/delete/${raport.id}">Delete</a>
                <a href="/transaction/edit/${raport.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

<form method="post">
    <table>
        <tr>
            <td><label>After <input name="after" type="date"/></label></td>
        </tr>
        <tr>
            <td>
                <label>Before <input name="before" type="date"/></label>
                <input type="submit" value="Find">
            </td>
        </tr>
    </table>
</form>

<%@include file="../footer.jsp" %>

</body>
</html>
