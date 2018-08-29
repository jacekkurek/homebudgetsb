<div class="form-group">
    <form:hidden path="id"/>
    <form:label path="name">Name</form:label>
    <form:input cssClass="form-control" path="name"/>
    <p class="form-group has-error">
        <form:errors path="name" element="label" cssClass="control-label help-block"/>
    <p/>
</div>

<button type="submit" class="btn btn-default">Submit</button>