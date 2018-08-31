<div class="form-group">
    <form:hidden path="id"/>
    <form:label path="name">Name</form:label>
    <form:input path="name" cssClass="form-control"/>
    <p class="form-group has-error">
        <form:errors path="name" element="label" cssClass="control-label help-block"/>
    <p/>
</div>
<div class="form-group">
    <label for="users">User name</label>
    <select id="users" class="form-control">
        <option></option>
        <c:forEach items="${users}" var="user">
            <option value="${user.id}">${user.name}</option>
        </c:forEach>
    </select>
</div>
<div class="form-group" id="hiddenSelect" style="display: none">
    <form:label path="budget">Budget</form:label>
    <form:select id="budgets" path="budget" itemLabel="name"  cssClass="form-control"/>
</div>

<button type="submit" id="hiddenButton" style="display: none" class="btn btn-default">Submit</button>


<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script type="text/javascript">
    var selectedUserId;
    $("#users").on("change", function () {
        selectedUserId = $(this).val();
        $("#hiddenSelect").show();
        loadBudgets();
    });

    $("#budgets").on("change", function () {
        $("#hiddenButton").show();
    });

    var budgetList = $('#budgets');
    var loadBudgets = function ()
    {
        $.ajax({
            url: "/api/budgets/" + selectedUserId,
            dataType: "json",
            type: "GET"
        })
            .done(function (budgets){
                budgetList.html("").append($("<option></option>"));
                budgets.forEach(budget => {
                    $("<option value='" + budget.id + "'>" + budget.name + "</option>").appendTo(budgetList);
            })
        });
    };

</script>