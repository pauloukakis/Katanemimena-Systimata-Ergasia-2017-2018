<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a User</h3>

	<form:form action="saveUser" modelAttribute="user" method="POST" class="ui form">
		<div class="field">
			<label>First Name</label> 
			<form:input path="firstName"/>
		</div>
		<div class="field">
			<label>Last Name</label>
			<form:input path="lastName"/>
		</div>
		<div class="field">
			<label>Email</label> 
			<form:input path="email"/>
		</div>
		<div class="field">
			<label>Role</label> 
			<form:input path="role"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>