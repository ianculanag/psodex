<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="head.jsp" />
<style>
.account-dropdown {
	transform: translate(0px, 0px) !important;
}

.dropdown-toggle::after {
	right: 10px;
	top: 12.5px;
	position: absolute;
}

.account-selected::after {
	display: none;
}
</style>
<div class="row w-100">
	<div class="form-container">
		<div class="p-5 ms-5 me-5 mt-5 bg-light">
			<h5 class="text-muted mb-4">Add Transaction</h5>
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
					<select id="select-transaction-type" class="form-select">
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
					<div id="outbound-account-select" class="col-md-6">
						<label for="inputPassword4" class="form-label w-100">Outbound Account:</label>
						<div class="btn-group w-100" style="height: 75px">
							<div class="dropdown-toggle form-control w-100 text-start h-100 p-0" id="defaultDropdown" data-bs-toggle="dropdown" data-bs-auto-close="true" aria-expanded="false">

								<div class="account-card-input-empty text-muted px-2 pt-2">Which account would you like to deduct from?</div>

								<div class="account-card-input-selected border-start border-info border-4 w-100 h-100 px-2 py-1 collapse">
									<div class="row py-1">
										<div class="col-md-4">
											<h5 class="mb-0 account-card-input-account-name"></h5>
											<small class="account-card-input-account-number"></small>
										</div>
										<div class="col-md-8 text-end">
											<small style="display: inline-block" class="fw-light me-1">PHP</small>
											<h4 class="mb-0 account-card-input-balance" " style="display: inline-block"></h4>
											<small style="display: block" class="text-muted">Available Balance</small>
										</div>
									</div>
								</div>

							</div>
							<ul class="account-dropdown dropdown-menu dropdown-menu-lg-end w-75" aria-labelledby="defaultDropdown" style="">
								<li><h6 class="dropdown-header">Select account</h6></li>
								<li>
									<div class="dropdown-item">
										<div>
											<div class="row py-1">
												<div class="col-md-4">
													<h6 class="mb-0 account-select-account-name">Infor Payroll</h6>
													<small class="account-select-account-number">1929570622</small>
												</div>
												<div class="col-md-8 text-end">
													<small style="display: inline-block" class="fw-light me-1">PHP</small>
													<h5 class="mb-0 account-select-balance" style="display: inline-block">94,266.73</h5>
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
													<h6 class="mb-0 account-select-account-name">Yondu Payroll</h6>
													<small class="account-select-account-number">2849234725</small>
												</div>
												<div class="col-md-8 text-end">
													<small style="display: inline-block" class="fw-light me-1">PHP</small>
													<h5 class="mb-0 account-select-balance" style="display: inline-block">55,103.12</h5>
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
													<h6 class="mb-0 account-select-account-name">GCash</h6>
													<small class="account-select-account-number">639060568265</small>
												</div>
												<div class="col-md-8 text-end">
													<small style="display: inline-block" class="fw-light me-1">PHP</small>
													<h5 class="mb-0 account-select-balance" style="display: inline-block">2,700.29</h5>
												</div>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<div id="inbound-account-select" class="col-md-6 collapse">
						<label for="inputPassword4" class="form-label w-100">Inbound Account:</label>
						<div class="btn-group w-100" style="height: 75px">
							<div class="dropdown-toggle form-control w-100 text-start h-100 p-0" id="defaultDropdown" data-bs-toggle="dropdown" data-bs-auto-close="true" aria-expanded="false">

								<div class="account-card-input-empty text-muted px-2 pt-2">Which account would you like to add the amount to?</div>

								<div class="account-card-input-selected border-start border-info border-4 w-100 h-100 px-2 py-1 collapse">
									<div class="row py-1">
										<div class="col-md-4">
											<h5 class="mb-0 account-card-input-account-name"></h5>
											<small class="account-card-input-account-number"></small>
										</div>
										<div class="col-md-8 text-end">
											<small style="display: inline-block" class="fw-light me-1">PHP</small>
											<h4 class="mb-0 account-card-input-balance" " style="display: inline-block"></h4>
											<small style="display: block" class="text-muted">Available Balance</small>
										</div>
									</div>
								</div>

							</div>
							<ul class="account-dropdown dropdown-menu dropdown-menu-lg-end w-75" aria-labelledby="defaultDropdown" style="">
								<li><h6 class="dropdown-header">Select account</h6></li>
								<li>
									<div class="dropdown-item">
										<div>
											<div class="row py-1">
												<div class="col-md-4">
													<h6 class="mb-0 account-select-account-name">Yondu Payroll</h6>
													<small class="account-select-account-number">2849234725</small>
												</div>
												<div class="col-md-8 text-end">
													<small style="display: inline-block" class="fw-light me-1">PHP</small>
													<h5 class="mb-0 account-select-balance" style="display: inline-block">55,103.12</h5>
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
													<h6 class="mb-0 account-select-account-name">GCash</h6>
													<small class="account-select-account-number">639060568265</small>
												</div>
												<div class="col-md-8 text-end">
													<small style="display: inline-block" class="fw-light me-1">PHP</small>
													<h5 class="mb-0 account-select-balance" style="display: inline-block">2,700.29</h5>
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
					<button type="submit" class="btn btn-primary">Submit</button>
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

	$('#select-transaction-type').change(
			function() {
				$('#outbound-account-select').find('.account-card-input-empty')
						.removeClass('collapse');
				$('#outbound-account-select').find(
						'.account-card-input-selected').addClass('collapse');

				$('#inbound-account-select').find('.account-card-input-empty')
						.removeClass('collapse');
				$('#inbound-account-select').find(
						'.account-card-input-selected').addClass('collapse');

				var transactionType = $(this).val();
				if (transactionType == 'Transfer') {
					$('#inbound-account-select').removeClass('collapse');
					$('#outbound-account-select').removeClass('collapse');
					return;
				}
				if (transactionType == 'Income') {
					$('#inbound-account-select').removeClass('collapse');
					$('#outbound-account-select').addClass('collapse');
					return;
				}
				$('#inbound-account-select').addClass('collapse');
				$('#outbound-account-select').removeClass('collapse');
			});

	$('.dropdown-item').click(
			function() {
				var accountName = $(this).find('.account-select-account-name')
						.html();
				var accountNumber = $(this).find(
						'.account-select-account-number').html();
				var balance = $(this).find('.account-select-balance').html();

				var accountInput = $(this).parent().parent().parent().find(
						".dropdown-toggle");

				accountInput.addClass('account-selected');
				accountInput.find('.account-card-input-empty').addClass(
						'collapse');

				var accountInputSelected = accountInput
						.find('.account-card-input-selected');
				accountInputSelected.removeClass('collapse');
				accountInputSelected.find('.account-card-input-account-name')
						.html(accountName);
				accountInputSelected.find('.account-card-input-account-number')
						.html(accountNumber);
				accountInputSelected.find('.account-card-input-balance').html(
						balance);
			})
</script>
<jsp:include page="footer.jsp" />