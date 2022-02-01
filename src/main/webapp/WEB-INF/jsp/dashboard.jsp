<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="head.jsp" />
<div class="row w-100">
	<div class="accountsContainer">
		<div class="p-0 ms-5 me-5 mt-5">
			<h6 class="text-black-50">
				Accounts (<c:out value="${accounts.size()}" />)
			</h6>
			<div class="row g-3">
				<c:set var="accountInstance" value="${accounts}" scope="request" />
				<jsp:include page="accountCard.jsp" />
			</div>
		</div>
	</div>
</div>

<div class="row w-100">
	<div class="jarsContainer">
		<div class="p-0 ms-5 me-5 mt-5">
			<h6 class="text-black-50">Jars</h6>
			<div class="row g-3 justify-content-center">
				<c:forEach var="jar" items="${jars}" varStatus="loopJars">
					<div class="col-3">
						<div class="card rounded-pill shadow">
							<div class="card-body">
								<div class="row">
									<div class="col-12 d-flex justify-content-center text-nowrap">
										<div class="${ jar.availableBalanceRaw > 0 ? 'jar-safe' : jar.availableBalanceRaw < 0 ? 'jar-danger' : 'text-muted' }">
											<small class="d-inline">PHP</small>
											<h5 class="mb-1 d-inline peso-format">${ jar.availableBalance }</h5>
										</div>
									</div>
									<div class="col-12 d-flex justify-content-center">
										<small class="text-black-50">${ jar.jarName }</small>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>


<div class="row w-100">
	<div class="transactionsContainer">
		<div class="p-0 ms-5 me-5 mt-5">
			<h6 class="text-black-50">Transaction History</h6>
			<div class="list-group shadow">
				<c:set var="transactionInstance" value="${transactions}" scope="request" />
				<jsp:include page="transactionEntry.jsp" />
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp" />
