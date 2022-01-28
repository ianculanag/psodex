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
<link href="https://fonts.googleapis.com/css2?family=MuseoModerno:wght@600&display=swap" rel="stylesheet">
</head>
<style>
* {
	font-family: 'Overpass', sans-serif;
}

.logo {
	font-family: 'MuseoModerno', cursive;
	letter-spacing: -2px;
	color: #777373;
	display: inline-block;
	font-size: 1.4em;
	margin-top: -7.5px;
}

.logo::first-letter {
	color: #12ADBF;
}

body, html {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	background-color: #F1F1F1;
	overflow-x: hidden;
}

.workspace {
	background-color: #F1F1F1;
}

}
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}
</style>
<body>
	<jsp:include page="navbar.jsp" />
	<div style="width: 100vw;">
		<jsp:include page="sidebarMenu.jsp" />
		<div class="workspace" style="padding-left: 250px; padding-top: 55px;">