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
    <form:label path="pin">Pin</form:label>
    <form:input path="pin" cssClass="form-control"/>
    <p class="form-group has-error">
        <form:errors path="pin" element="label" cssClass="control-label help-block"/>
    <p/>
</div>
<div class="form-group">
    <form:label path="salary">Salary</form:label>
    <form:input path="salary" cssClass="form-control"/>
    <p class="form-group has-error">
        <form:errors path="salary" element="label" cssClass="control-label help-block"/>
    <p/>
</div>

<button type="submit" class="btn btn-default">Submit</button>