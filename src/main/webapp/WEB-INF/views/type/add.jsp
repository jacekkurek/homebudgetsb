<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add type</title>
    <link rel="stylesheet" href="../../../../resources/static/css/style.css">
</head>
<body>

<%@include file="../header.jsp" %>
<%@include file="type_menu.jsp"%>

<h1>Add New Type</h1>

<form:form method="post" modelAttribute="type">
    <%@include file="type_form.jsp" %>
</form:form>

<%@include file="../footer.jsp" %>

</body>
</html>
