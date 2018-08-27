<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read</title>
</head>
<body>

<h1>Podaj id dla wyszukania w tabeli "type"</h1>
<form method="post">
    Numer id do wyszukania:
    <input type="number" name="id">
    <input type="submit" value="Zatwierdź">
</form>

<c:if test="${not empty information}">${information}</c:if>

<c:if test="${not empty type}">
    <table>
        <tr>
            <td>${type.id}</td> <td>${type.name}</td>
        </tr>
    </table>
</c:if>

</body>
</html>
