

		<div class="ui segment">
			<h3>List of Users</h3>

			<!--  add our html table here -->
			<table class="ui celled  striped table">
				<thead>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
				</thead>
				<!-- loop over and print our users -->
				<c:forEach var="tempUser" items="${users}">

					<tr>
						<td>${tempUser.firstName}</td>
						<td>${tempUser.lastName}</td>
						<td>${tempUser.email}</td>
						<td>${tempUser.role}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
