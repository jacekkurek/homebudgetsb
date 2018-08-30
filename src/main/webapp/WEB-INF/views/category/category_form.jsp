<div class="form-group">
    <form:hidden path="id"/>
    <form:label path="name">Name</form:label>
    <form:input path="name" cssClass="form-control"/>
    <p class="form-group has-error">
        <form:errors path="name" element="label" cssClass="control-label help-block"/>
    <p/>
</div>
<div class="form-group">
    <form:label path="budget">Budget</form:label>
    <form:select path="budget" itemLabel="name"  cssClass="form-control" items="${budgets}"/>
</div>

<button type="submit" class="btn btn-default">Submit</button>