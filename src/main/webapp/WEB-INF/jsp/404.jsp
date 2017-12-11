<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' />
<link rel='stylesheet'
	href="<c:url value="/resources/stylesheets/WelcomeStyle.css" />" />
<title>Hotel Tristar</title>
</head>
<body>
	<div class="container-fluid">
		<h3 id="userId">
			Welcome back,
			<%="Szilard"%></h3>
	</div>
	<div class="container-fluid" id="welcomeDiv">
		<h1 class="text-center">Hotel Tristar</h1>
	</div>
	<div class='container' id="navbarDiv">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">*** Tristar ***</a>
			</div>
			<div id="navMenu">
				<form>
					<ul class="nav navbar-nav col-sm-6 text-center">
						<li class="active"><a href="welcome">Home</a></li>
						<li><a href="booking">Booking</a></li>
						<li><a href="gallery">Gallery</a></li>
						<li><a href="contact">Contact</a></li>
						<li><a href="logout">Logout</a></li>
					</ul>
				</form>
			</div>
		</div>
		</nav>
	</div>
	<div id="wrapper">
		<div id="bodyDiv">
			<h1>Oops, something went wrong...</h1>
			<br>
			<h3>404</h3>
			<br>
			<h3>This page does not exist or it was moved...</h3>
		</div>
	</div>
</body>
</html>