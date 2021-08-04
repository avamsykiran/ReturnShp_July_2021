<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="/header" />
<main class="container-fluid p-4">
	<div class="col-sm-5 mx-auto">
		<h4>New Subscriber</h4>

		<form:form method="POST" modelAttribute="subscriber">
			<div class="form-group">
				<form:label path="subscriberId">Subscriber Id</form:label>
				<form:input path="subscriberId" type="number" readonly="true"
					class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="fullName">Full Name</form:label>
				<form:input path="fullName" class="form-control" />
				<form:errors path="fullName" />
			</div>
			<div class="form-group">
				<form:label path="gender">Gender</form:label>
				<form:select path="gender" items="${genders }" class="form-control" />
				<form:errors path="gender" />
			</div>
			<div class="form-group">
				<form:label path="emailId">Email Id</form:label>
				<form:input path="emailId" class="form-control" />
				<form:errors path="emailId" />
			</div>
			<div class="form-group">
				<form:label path="mobile">Mobile Number</form:label>
				<form:input path="mobile" class="form-control" />
				<form:errors path="mobile" />
			</div>
			<button class="btn btn-primary btn-block">Save Subscriber</button>
		</form:form>
	</div>
</main>
<jsp:include page="/footer" />