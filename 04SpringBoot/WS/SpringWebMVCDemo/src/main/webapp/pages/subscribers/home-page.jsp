<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="/header" />
<main class="container-fluid p-4">
	<h4>Subscribers </h4>
	<c:choose>
		<c:when test="${subscribers==null || subscribers.isEmpty() }">
			<p class="alert alert-danger m-2 p-2"><strong>No subscribers To Display</strong></p>
		</c:when>
		<c:otherwise>
			<table class="table table-border table-stropped table-hover">
				<thead>
					<tr>
						<th>Subsriber#</th>
						<th>Name</th>
						<th>Email</th>
						<th>Mobile</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="s" items="${subscribers}">
						<tr>
							<td>${s.subscriberId }</td>
							<td>${s.fullName}</td>
							<td>${s.emailId}</td>
							<td>${s.mobile }</td>
							<td>
								<a href="/subscriptions/${s.subscriberId}" class="btn btn-sm btn-info">SUBSCRIPTIONS</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</main>
<jsp:include page="/footer" />