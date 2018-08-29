<form:hidden path="id"/>

timeTransaction
<form:input path="timeTransaction" type="date"/></<br>
name
<form:input path="name"/></<br>
value
<form:input path="value"/></<br>
User:
<form:select itemLabel="name" path="user" items="${users}"/>
Budget:
<form:select itemLabel="name" path="budget" items="${budgets}"/>
Category:
<form:select itemLabel="name" path="category" items="${categories}"/>
Subcategory:
<form:select itemLabel="name" path="subcategory" items="${subcategories}"/>
Type:
<form:select itemLabel="name" path="type" items="${types}"/><br/>

