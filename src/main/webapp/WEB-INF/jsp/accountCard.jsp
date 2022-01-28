<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="account" items="${accounts}" varStatus="loopAccount">
	<div class="card text-end mb-4 me-4" style="width: 18rem;">
		<div class="card-body border-start border-info border-4 shadow">
			<h6 class="card-title" style="display: inline-block">PHP</h6>
			<h3 class="card-title" style="display: inline-block">${ account.balance }</h3>
			<h5 class="card-subtitle mb-2 text-muted">${ account.accountName }</h5>
			<h6 class="card-subtitle mb-2 text-muted">${ account.accountNumber }</h6>
			<small class="card-subtitle mb-2 text-muted">${ account.issuingBank }</small>
		</div>
	</div>
</c:forEach>