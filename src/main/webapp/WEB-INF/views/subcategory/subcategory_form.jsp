<div class="form-group">
<form:hidden path="id"/>

    <form:label path="name">Category:</form:label>
<form:select itemLabel="name" path="category" items="${categories}" /><br/>
    <div class="form-group has-error">
        <form:errors path="name" element="label" cssClass="control-label"/>
    </div>

    <form:input cssClass="form-control" path="name"/>
</div>

<button type="submit" class="btn btn-default">Submit</button>




