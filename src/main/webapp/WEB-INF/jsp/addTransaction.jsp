<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="head.jsp" />
<style>
.account-dropdown {
	transform: translate(0px, 0px) !important;
}
</style>
<div class="row w-100">
	<div class="form-container">
		<div class="p-5 ms-5 me-5 mt-5 bg-light">
			<form class="row g-3">
				<div class="col-md-9">
					<label for="inputEmail4" class="form-label">Description</label>
					<input type="email" class="form-control" id="inputEmail4" placeholder="What is this transaction about?">
				</div>
				<div class="col-md-3">
					<label for="inputCity" class="form-label">Date</label>
					<input type="date" class="form-control" id="inputCity">
				</div>
				<div class="col-md-6">
					<label for="inputPassword4" class="form-label">Amount</label>
					<div class="row">
						<div class="col-md-3">
							<input type="text" class="form-control" id="currency" placeholder="PHP" style="text-align: center" readonly />
						</div>
						<div class="col-md-9">
							<input type="number" class="form-control transaction-amount" id="inputPassword4" placeholder="0.00" style="text-align: right">
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<label for="inputState" class="form-label">Type</label>
					<select id="inputState" class="form-select">
						<option>Expense</option>
						<option>Income</option>
						<option>Transfer</option>
						<option>Savings</option>
						<option>Investment</option>
					</select>
				</div>
				<div class="col-md-3">
					<label for="inputState" class="form-label">Jar</label>
					<select id="inputState" class="form-select">
						<option class="text-muted">Select the Jar...</option>
						<option>Necessities</option>
						<option>Relationship</option>
						<option>Long-term Savings</option>
						<option>Give back</option>
						<option>Self-investment</option>
						<option>Investment</option>
					</select>
				</div>

				<div id="bound-accounts" class="row g-3">
					<div class="col-md-6">
						<label for="inputPassword4" class="form-label w-100">Outbound Account:</label>
						<div class="btn-group w-100" style="height: 75px">
							<div class="dropdown-toggle form-control w-100 text-start text-muted h-100" type="text" id="defaultDropdown" data-bs-toggle="dropdown" data-bs-auto-close="true"
								aria-expanded="false">Which account would you like to deduct from?</div>
							<ul class="account-dropdown dropdown-menu dropdown-menu-lg-end w-75" aria-labelledby="defaultDropdown" style="">
								<li><h6 class="dropdown-header">Select account</h6></li>
								<li>
									<div class="dropdown-item">
										<div>
											<div class="row py-1">
												<div class="col-md-4">
													<h6 class="mb-0 fw-bold">Infor Payroll</h6>
													<small>1929570622</small>
												</div>
												<div class="col-md-8 text-end">
													<small style="display: inline-block" class="fw-light me-1">PHP</small>
													<h5 class="mb-0" style="display: inline-block">14,201.00</h5>
												</div>
											</div>
										</div>
									</div>
								</li>
								<li>
									<div class="dropdown-item">
										<div>
											<div class="row py-1">
												<div class="col-md-4">
													<h6 class="mb-0 fw-bold">Yondu Payroll</h6>
													<small>2849234725</small>
												</div>
												<div class="col-md-8 text-end">
													<small style="display: inline-block" class="fw-light me-1">PHP</small>
													<h5 class="mb-0" style="display: inline-block">25,103.12</h5>
												</div>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div><div class="col-md-6">
						<label for="inputPassword4" class="form-label w-100">Inbound Account:</label>
						<div class="btn-group w-100" style="height: 75px">
							<div class="dropdown-toggle form-control w-100 text-start text-muted h-100" type="text" id="defaultDropdown" data-bs-toggle="dropdown" data-bs-auto-close="true"
								aria-expanded="false">Which account would you like to add the amount to?</div>
							<ul class="account-dropdown dropdown-menu dropdown-menu-lg-end w-75" aria-labelledby="defaultDropdown" style="">
								<li><h6 class="dropdown-header">Select account</h6></li>
								<li>
									<div class="dropdown-item">
										<div>
											<div class="row py-1">
												<div class="col-md-4">
													<h6 class="mb-0 fw-bold">Infor Payroll</h6>
													<small>1929570622</small>
												</div>
												<div class="col-md-8 text-end">
													<small style="display: inline-block" class="fw-light me-1">PHP</small>
													<h5 class="mb-0" style="display: inline-block">14,201.00</h5>
												</div>
											</div>
										</div>
									</div>
								</li>
								<li>
									<div class="dropdown-item">
										<div>
											<div class="row py-1">
												<div class="col-md-4">
													<h6 class="mb-0 fw-bold">Yondu Payroll</h6>
													<small>2849234725</small>
												</div>
												<div class="col-md-8 text-end">
													<small style="display: inline-block" class="fw-light me-1">PHP</small>
													<h5 class="mb-0" style="display: inline-block">25,103.12</h5>
												</div>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>


				<!--div class="col-12">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="gridCheck">
						<label class="form-check-label" for="gridCheck"> Check me out </label>
					</div>
				</div-->
				<div class="col-12">
					<button type="submit" class="btn btn-primary">Sign in</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
	$('.transaction-amount').keypress(
			function(e) {
				if ($(this).val().indexOf(".") > -1
						&& ($(this).val().split('.')[1].length > 1)) {
					e.preventDefault();
				}
			});
</script>
<jsp:include page="footer.jsp" />