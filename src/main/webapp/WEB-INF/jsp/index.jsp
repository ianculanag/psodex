<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Psodex</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Overpass:wght@200;300;400;600;700;900&family=Ubuntu:wght@300&display=swap"
	rel="stylesheet">
</head>
<style>
* {
	font-family: 'Overpass', sans-serif;
}
</style>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand mx-4" href="/">
			<img src="<c:url value="/logo"/>"
			height="30" alt=""/>
		</a>
	</nav>
	<div class="container mt-5">
		<div class="card" style="width: 25rem;">
			<h3 class="card-title mt-5 mx-5">Login to your account</h3>
			<form action="login" method="post">
				<div class="form-group mt-3 mx-5">
					<label for="email" class="mb-1">Email Address</label>
					<input type="email" name="email"
						class="form-control" id="email" placeholder="Email Address">
				</div>
				<div class="form-group mt-3 mx-5">
					<label for="password" class="mb-1">Password</label>
					<input type="password" name="password"
						class="form-control" id="password" placeholder="Password">
				</div>
				<button type="submit" class="btn btn-primary my-5 mx-5">Sign
					in</button>
			</form>
		</div>
	</div>

</body>
</html>
