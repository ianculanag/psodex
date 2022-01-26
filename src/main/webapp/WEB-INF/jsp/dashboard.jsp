<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Psodex</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Overpass:wght@200;300;400;600;700;900&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
</head>
<style>
* {
	font-family: 'Overpass', sans-serif;
}

body, html {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
}
</style>
<body>
	<nav class="navbar navbar-light bg-light" style="height: 55px;">
		<a class="navbar-brand mx-4" href="/"> <img src="<c:url value="/logo"/>" height="30" alt="" />
		</a>
	</nav>
	<div style="width: 100vw;">
		<jsp:include page="sidebarMenu.jsp" />
		<div class="workspace" style="padding-left: 250px">
			<div class="row w-100">
				<div class="accountsContainer">
					<div class="p-0 ms-5 me-5 mt-5">
						<h6 class="text-muted">Accounts</h6>
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

		</div>
	</div>
</body>
</html>
