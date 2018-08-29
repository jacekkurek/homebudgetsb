<div class="form-group">
    <form:hidden path="id"/>
    <form:label path="name">Name</form:label>
    <form:input path="name" cssClass="form-control"/>
</div>
<div class="form-group">

    <form:label path="budget">Budget</form:label>

    <form:select itemLabel="name" path="budget" items="${budgets}"/><br/>
</div>


<button type="submit" class="btn btn-default">Submit</button>



