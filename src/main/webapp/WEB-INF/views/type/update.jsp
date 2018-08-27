<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>

<h1>Podaj id wiersza, który ma zostać zmodyfikowany oraz wartość name na którą ma zostać podmieniony</h1>
<form:form method="post" modelAttribute="type">
    <div>Id wiersza do modyfikacji:</div>
    <form:input type="number" path="id"/>
    <div>Tekst użyty do podmienienia:</div>
    <form:input path="name"/>
    <input type="submit" value="Zatwierdź">
</form:form>

</body>
</html>
