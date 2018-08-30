<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>

<div class="form-group">
    <form:hidden path="id"/>
    <form:label path="name">Name</form:label>
    <form:input path="name" cssClass="form-control"/>
    <p class="form-group has-error">
        <form:errors path="name" element="label" cssClass="control-label help-block"/>
    <p/>
</div>
<div class="form-group">
    <form:label path="description">Description</form:label>
    <form:input path="description" cssClass="form-control"/>
</div>
<div class="form-group">
    <form:label path="user">User</form:label>
    <form:select path="user" itemLabel="name" cssClass="form-control" items="${users}"/>
</div>

<button type="submit" class="btn btn-default">Submit</button>