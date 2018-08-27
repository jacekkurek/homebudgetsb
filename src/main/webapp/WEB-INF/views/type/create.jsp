<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>

<h1>Podaj nazwę operacji do zapisania w bazie danych w tabeli "type"</h1>

<form:form method="post" modelAttribute="type">
    <div>Nazwa transakcji:<div/>
    <form:input path="name"/>
    <input type="submit" value="Zatwierdź">
</form:form>

</body>
</html>
