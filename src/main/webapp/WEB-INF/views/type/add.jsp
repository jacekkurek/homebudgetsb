<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New</title>
</head>
<body>

<%@include file="../header.jsp" %>

<h1>Add New Type</h1>

<form:form method="post" modelAttribute="type">
    <%@include file="type_form.jsp" %>
</form:form>

</body>
</html>
