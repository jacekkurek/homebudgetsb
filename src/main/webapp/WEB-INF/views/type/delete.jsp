<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>

<h1>Podaj id wiersza, który chesz usunąć</h1>
<form method="post">
    Podaj id:
    <input type="number" name="id">
    <input type="submit" value="Zatwierdź">
</form>

<c:if test="${not empty information}">${information}</c:if>

</body>
</html>
