<div class="form-group">
    <form:hidden path="id"/>
    <form:label path="name">Name</form:label>
    <div class="form-group has-error">
        <form:errors path="name" element="label" cssClass="control-label"/>
    </div>

    <form:input cssClass="form-control" path="name"/>
</div>

<button type="submit" class="btn btn-default">Submit</button>
