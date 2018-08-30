<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>

<div class="form-group">
    <for:label path="name">Name</for:label>
    <form:input path="name" cssClass="form-control"/>
    <p class="form-group has-error">
        <form:errors path="category" element="label" cssClass="control-label"/>
    </p>
</div>
<div class="form-group">
    <form:hidden path="id"/>
    <form:label path="category">Category</form:label>
    <form:select itemLabel="name" path="category" cssClass="form-control" items="${categories}"/>
</div>

<button type="submit" class="btn btn-default">Submit</button>