<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>

<div class="form-group">
    <form:hidden path="id"/>
    <for:label path="timeTransaction">Time Transaction</for:label>
    <form:input path="timeTransaction" type="date" cssClass="form-control"/>
    <p class="form-group has-error">
        <form:errors path="timeTransaction" element="label" cssClass="control-label help-block"/>
    <p/>
</div>
<div class="form-group">
    <for:label path="name">Name</for:label>
    <form:input path="name" cssClass="form-control"/>
    <p class="form-group has-error">
        <form:errors path="name" element="label" cssClass="control-label help-block"/>
    <p/>
</div>
<div class="form-group">
    <for:label path="value">Value</for:label>
    <form:input path="value" cssClass="form-control"/>
    <p class="form-group has-error">
        <form:errors path="name" element="label" cssClass="control-label help-block"/>
    <p/>
</div>
<div class="form-group">
    <for:label path="user">User</for:label>
    <form:select itemLabel="name" path="user" cssClass="form-control" items="${users}"/>
</div>
<div class="form-group">
    <for:label path="budget">Budget</for:label>
    <form:select itemLabel="name" path="budget" cssClass="form-control" items="${budgets}"/>
</div>
<div class="form-group">
    <for:label path="category">Category</for:label>
    <form:select itemLabel="name" path="category" cssClass="form-control" items="${categories}"/>
</div>
<div class="form-group">
    <for:label path="subcategory">Subcategory</for:label>
    <form:select itemLabel="name" path="subcategory" cssClass="form-control" items="${subcategories}"/>
</div>
<div class="form-group">
    <for:label path="type">Type</for:label>
    <form:select itemLabel="name" path="type" cssClass="form-control" items="${types}"/>
</div>

<button type="submit" class="btn btn-default">Submit</button>