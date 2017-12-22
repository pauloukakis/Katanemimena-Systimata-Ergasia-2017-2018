<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Car</h3>

	<form:form action="saveCar" modelAttribute="car" method="POST" class="ui form">
		<div class="field">
			<label>ID</label> 
			<form:input path="id"/>
		</div>
		<div class="field">
			<label>Owner Name</label> 
			<form:input path="ownerName"/>
		</div>
		<div class="field">
			<label>Last Date</label>
			<form:input path="lastDate"/>
		</div>
		<div class="field">
			<label>Car Model</label> 
			<form:input path="carModel"/>
		</div>
		<div class="field">
			<label>Car Type</label> 
			<form:input path="carType"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>