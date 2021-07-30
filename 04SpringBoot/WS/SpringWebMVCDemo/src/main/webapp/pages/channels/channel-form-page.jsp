<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="/header" />
<main class="container-fluid p-4">
	<div class="col-sm-5 mx-auto">
		<h4>New Channel</h4>

		<form:form method="POST" modelAttribute="channel">
			<div class="form-group">
				<form:label path="channelId">Channel Id</form:label>
				<form:input path="channelId" type="number" readonly="true"
					class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="channelName">Channel Name</form:label>
				<form:input path="channelName" class="form-control" />
				<form:errors path="channelName" />
			</div>
			<div class="form-group">
				<form:label path="monthlyFee">Monthly Fee</form:label>
				<form:input path="monthlyFee" type="decimal" class="form-control" />
				<form:errors path="monthlyFee" />
			</div>
			<button class="btn btn-primary btn-block">Save Channel</button>
		</form:form>
	</div>
</main>
<jsp:include page="/footer" />