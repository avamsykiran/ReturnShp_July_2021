<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="/header" />
<main class="container-fluid p-4">
	<h4>Channels </h4>
	<c:choose>
		<c:when test="${channels==null || channels.isEmpty() }">
			<p class="alert alert-danger m-2 p-2"><strong>No channels To Display</strong></p>
		</c:when>
		<c:otherwise>
			<table class="table table-border table-stropped table-hover">
				<thead>
					<tr>
						<th>Channel#</th>
						<th>Title</th>
						<th>Monthly Fee</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ch" items="${channels }">
						<tr>
							<td>${ch.channelId }</td>
							<td>${ch.channelName }</td>
							<td>${ch.monthlyFee }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</main>
<jsp:include page="/footer" />