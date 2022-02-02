<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="transaction" items="${transactions}" varStatus="loopTransactions">
	<div class="list-group-item list-group-item-action" aria-current="true">
		<div class="row">
			<div class="col-6">
				<div class="w-100 justify-content-between">
					<div>
						<h6 class="mb-1 d-inline">${ transaction.details }</h6>
						<span class="badge bg-secondary ms-1 transaction-type align-top">${ transaction.transactionType }</span>
						<span class="badge rounded-pill bg-secondary ms-1 align-top">${ transaction.jarName }</span>
					</div>
					<small class="text-muted">${ transaction.transactionDate }</small>
				</div>
			</div>

			<c:set var="hasOutboundAccount" scope="session" value="${transaction.outboundAccountName == ''}" />
			<div class="col-3 text-end">
				<div class="w-100 justify-content-between">
					${ hasOutboundAccount ? "" : "(" } <small class="d-inline">${ hasOutboundAccount ? "" : "PHP" }</small>
					<h5 class="mb-1 d-inline peso-format">${ hasOutboundAccount ? "-" : transaction.transactionAmount }</h5>
					${ hasOutboundAccount ? "" : ")" } <small class="text-muted d-block">${ hasOutboundAccount ? "" : transaction.outboundAccountName }</small>
				</div>
			</div>

			<c:set var="hasInboundAccount" scope="session" value="${transaction.inboundAccountName == ''}" />
			<div class="col-3 text-end">
				<div class="w-100 justify-content-between">
					<small class="d-inline">${ hasInboundAccount ? "" : "PHP" }</small>
					<h5 class="mb-1 d-inline peso-format">${ hasInboundAccount ? "-" : transaction.transactionAmount }</h5>
					<small class="text-muted d-block">${ hasInboundAccount ? "" : transaction.inboundAccountName }</small>
				</div>
			</div>
		</div>
	</div>
</c:forEach>