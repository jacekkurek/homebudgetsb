<table>
    <tr>
        <td><form:hidden path="id"/></td>
        <td><form:errors path="name" cssClass="error"/></td>
    </tr>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td>
            <form:input path="name"/>
            <form:button>Update</form:button>
        </td>
    </tr>
</table>