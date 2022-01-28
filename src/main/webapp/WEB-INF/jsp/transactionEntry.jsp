<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="transaction" items="${transactions}" varStatus="loopTransactions">
	<div class="list-group-item list-group-item-action" aria-current="true">
		<div class="row">
			<div class="col-4">
				<div class="w-100 justify-content-between">
					<h6 class="mb-1">${ transaction.details }</h6>
					<small class="text-muted">${ transaction.transactionDate }</small>
				</div>
			</div>
			<div class="col-1">
				<h5>
					<span class="badge bg-light text-dark">${ transaction.transactionType }</span>
				</h5>
			</div>
			<div class="col-1">
				<span class="badge bg-success"></span>
			</div>

			<c:set var="hasOutboundAccount" scope="session" value="${transaction.outboundAccountName == ''}" />
			<div class="col-3 text-end">
				<div class="w-100 justify-content-between">
					${ hasOutboundAccount ? "" : "(" } <small class="d-inline">${ hasOutboundAccount ? "" : "PHP" }</small>
					<h5 class="mb-1 d-inline">${ hasOutboundAccount ? "-" : transaction.transactionAmount }</h5>
					${ hasOutboundAccount ? "" : ")" } <small class="text-muted d-block">${ hasOutboundAccount ? "" : transaction.outboundAccountName }</small>
				</div>
			</div>

			<c:set var="hasInboundAccount" scope="session" value="${transaction.inboundAccountName == ''}" />
			<div class="col-3 text-end">
				<div class="w-100 justify-content-between">
					<small class="d-inline">${ hasInboundAccount ? "" : "PHP" }</small>
					<h5 class="mb-1 d-inline">${ hasInboundAccount ? "-" : transaction.transactionAmount }</h5>
					<small class="text-muted d-block">${ hasInboundAccount ? "" : transaction.inboundAccountName }</small>
				</div>
			</div>
		</div>
	</div>
</c:forEach>