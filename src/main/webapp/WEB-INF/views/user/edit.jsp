<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 27.08.18
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../../resources/static/css/style.css">

</head>
<body>
<%@include file="../header.jsp" %></br>

<form:form method="post"  modelAttribute="user">
    <%@include file="user_form.jsp"%>
    <input type="submit" value="Update">
</form:form>

<%@include file="../footer.jsp" %></br>

</body>
</html>