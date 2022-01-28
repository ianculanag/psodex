<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="account" items="${accounts}" varStatus="loopAccount">
	<div class="col-4">
		<div class="card">
			<div class="card-body border-start border-info border-4 shadow">
				<div class="row">
					<div class="col-6">
						<h5 class="card-subtitle mb-1">${ account.accountName }</h5>
						<h6 class="card-subtitle mb-2 text-muted">${ account.accountNumber }</h6>
						<small class="text-muted">${ account.issuingBank == null ? "&nbsp;" : account.issuingBank }</small>
					</div>
					<div class="col-6 d-flex text-end align-items-end flex-row-reverse text-nowrap ">
						<div class="align-text-bottom">
							<small class="d-inline">PHP</small>
							<h4 class="mb-1 d-inline">${ account.balance }</h4>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>