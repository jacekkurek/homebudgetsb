<form:hidden path="id"/>

Name:
<form:input path="name"/></<br>
Description:
<form:input path="description"/></<br>
User:
<form:select itemLabel="name" path="users" items="${users}"/><br/>
