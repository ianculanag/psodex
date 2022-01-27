<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="transaction" items="${transactions}" varStatus="loopTransactions">
	<div class="list-group-item list-group-item-action" aria-current="true">
		<div class="row">
			<div class="col-6">
				<div class="w-100 justify-content-between">
					<h5 class="mb-1">${ transaction.details }</h5>
					<small class="text-muted">${ transaction.transactionDate }</small>
				</div>
				<span class="badge bg-secondary">${ transaction.transactionType }</span>
				<span class="badge bg-secondary"></span>
			</div>
			<div class="col-3 text-end">
				<div class="w-100 justify-content-between">
					(<small style="display: inline-block">PHP</small>
					<h5 class="mb-1" style="display: inline-block">${ transaction.transactionAmount }</h5>
					)
					<h6 class="text-muted">${ transaction.outboundAccountName }</h6>
				</div>
			</div>
			<div class="col-3 text-end">
				<div class="w-100 justify-content-between">
					<small style="display: inline-block">${ transaction.transactionType == "EXPENSE" ? "" : "PHP" }</small>
					<h5 class="mb-1" style="display: inline-block">${ transaction.transactionType == "EXPENSE" ? "-" : transaction.transactionAmount }</h5>
					<h6 class="text-muted">${ transaction.transactionType == "EXPENSE" ? "-" : transaction.inboundAccountName }</h6>
				</div>
			</div>
		</div>
	</div>
</c:forEach>