<jsp:include page="/header" />
<main class="container-fluid p-5">
	<div class="col-sm-6 mx-auto">
		<div class="card card-danger">
			<div class="card-header">
				<h3>Error</h3>
			</div>
			<div class="card-body">
				<p>
					<strong>${err }</strong>
			</div>
			<div class="card-footer text-right">
				<span>Please write to admin@d2h.in if this persists!</span>
			</div>
		</div>
	</div>
</main>
<jsp:include page="/footer" />