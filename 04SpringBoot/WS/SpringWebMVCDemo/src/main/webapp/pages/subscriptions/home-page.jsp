<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<jsp:include page="/header" />
<main class="container-fluid p-4">

	<table class="table">
		<tr class="text-left">
			<th>Subsriber#</th>
			<td>${subscriber.subscriberId }</td>
			<th>Email</th>
			<td>${subscriber.emailId}</td>
		</tr>
		<tr class="text-left">
			<th>Name</th>
			<td>${subscriber.fullName}</td>
			<th>Mobile</th>
			<td>${subscriber.mobile }</td>
		</tr>
	</table>

	<h4>Subscriptions</h4>

	<table class="table table-border table-stropped table-hover">
		<thead>
			<tr>
				<th>Channel</th>
				<th>ActivationDate</th>
			</tr>
		</thead>
		<tbody>

			<c:choose>
				<c:when test="${subscriptions==null || subscriptions.isEmpty() }">
					<tr>
						<td colspan="2"><strong>No Subscriptions To Display</strong></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="s" items="${subscriptions}">
						<tr>
							<td>${s.channelName }</td>
							<td>${s.subscriptionActivationDate}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<form class="form-inline">
						<select class="form-control">
							<option value="">---SELECT CHANNEL---</option>
						</select>
						<button class="ml-2 btn btn-sm btn-primary">Subscribe Now</button>
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
</main>
<jsp:include page="/footer" />