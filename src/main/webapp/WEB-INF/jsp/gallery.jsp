<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' />
<link rel='stylesheet'
	href="<c:url value="/resources/stylesheets/WelcomeStyle.css" />" />
<script type="text/javascript"
	src="<c:url value='/resources/js/switchImage.js'/>"></script>
<title>Gallery</title>
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
						<li><a href="welcome">Home</a></li>
						<li><a href="booking">Booking</a></li>
						<li class="active"><a href="gallery">Gallery</a></li>
						<li><a href="contact">Contact</a></li>
						<li><a href="logout">Logout</a></li>
					</ul>
				</form>
			</div>
		</div>
		</nav>
	</div>
	<div id="wrapper">
		<h1 id="galleryTitle" class="text-center">Gallery</h1>

		<div id="galleryGroup">
			<div id="galleryButtons" class="text-center">
				<input type="button" value="Previous" class="btn btn-default"
					onClick="switchImage(document.getElementById('myImg'), -1)"/> 
				<input
					type="button" value="Next" class="btn btn-default"
					onClick="switchImage(document.getElementById('myImg'), 1)" />
			</div>
			<br> <br>
			<div id="galleryImages" >
				<img id="myImg" src="<c:url value="/resources/images/hotel-1.jpg"/>" />
			</div>
		</div>
	</div>
</body>
</html>