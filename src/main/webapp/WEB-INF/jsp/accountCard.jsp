<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="account" items="${accounts}" varStatus="loopAccount">
	<div class="card text-end mb-4 me-4" style="width: 18rem;">
		<div class="card-body">
			<h5 class="card-title" style="display: inline-block">PHP</h5>
			<h2 class="card-title" style="display: inline-block">${ account.balance }</h2>
			<h5 class="card-subtitle mb-2 text-muted">${ account.accountName }</h5>
			<h6 class="card-subtitle mb-2 text-muted">${ account.accountNumber }</h6>
			<h6 class="card-subtitle mb-2 text-muted">${ account.issuingBank }</h6>
		</div>
	</div>
</c:forEach>