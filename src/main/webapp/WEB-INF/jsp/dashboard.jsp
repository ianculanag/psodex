<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="head.jsp" />
<div class="row w-100">
	<div class="accountsContainer mb-4">
		<div class="p-0 ms-5 me-5 mt-5">
			<h6 class="text-muted">Accounts (<c:out value="${accounts.size()}" />)</h6>
			<hr class="mb-4 mt-1">
			<div class="float-start ms-5" style="margin-left: 0 !important; width: 100%">
				<div class="d-flex flex-row flex-wrap">
					<c:set var="accountInstance" value="${accounts}" scope="request" />
					<jsp:include page="accountCard.jsp" />
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row w-100">
	<div class="transactionsContainer">
		<div class="p-0 ms-5 me-5 mb-5">
			<h6 class="text-muted">Transaction History</h6>
			<div class="list-group">
				<c:set var="transactionInstance" value="${transactions}" scope="request" />
				<jsp:include page="transactionEntry.jsp" />
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp" />
