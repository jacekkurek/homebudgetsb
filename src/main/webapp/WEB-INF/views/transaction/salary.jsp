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


<c:if test="${b==1}">
    <h1>MASZ ZA MAŁO PIENIĘDZY</h1>
</c:if>
<c:if test="${b==2}">
    <h1>WYSTARCZY CI NA WYDATKI</h1>
</c:if>

<%--<table>--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<td>id</td>--%>
<%--<td>timeAdded</td>--%>
<%--<td>timeTransaction</td>--%>
<%--<td>name</td>--%>
<%--<td>value</td>--%>
<%--<td>user</td>--%>
<%--<td>budget</td>--%>
<%--<td>category</td>--%>
<%--<td>subcategory</td>--%>
<%--<td>type</td>--%>
<%--<td>Akcja</td>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--<c:forEach items="${st}" var="transaction">--%>
<%--<tr>--%>
<%--<td>${transaction.id}</td>--%>
<%--<td>${transaction.timeAdded}</td>--%>
<%--<td>${transaction.timeTransaction}</td>--%>
<%--<td>${transaction.name}</td>--%>
<%--<td>${transaction.value}</td>--%>
<%--<td>${transaction.user.name}</td>--%>
<%--<td>${transaction.budget.name}</td>--%>
<%--<td>${transaction.category.name}</td>--%>
<%--<td>${transaction.subcategory.name}</td>--%>
<%--<td>${transaction.type.name}</td>--%>
<%--<td>--%>
<%--<a href="/transaction/delete/${transaction.id}">delete</a>--%>
<%--<a href="/transaction/edit/${transaction.id}">edit</a>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>

<%--</table>--%>


<form method="post">
    <table>

        <tr>
            <td>
                <%--<label>name <input name="a"/></label>--%>
                User:
                <select name='username'>

                    <c:forEach items="${users}" var="user">
                        <option value="${user.name}">${user.name}</option>
                    </c:forEach>
                </select>
                <label>After <input name="after" type="date"/></label>
                <label>Before <input name="before" type="date"/></label>
                <input type="submit" value="Find">
            </td>
        </tr>
    </table>


</form>

<%@include file="../footer.jsp" %>

</body>
</html>
