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
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDsCbg4ccOCCF-Pk9Cqd4J6ylFcQTiYyVE&callback=initMap"
	type="text/javascript"></script>
<script>
	var map;
	function initMap() {
		var mapOptions = {
			zoom : 8,
			center : new google.maps.LatLng(46.397, 23.644)
		};
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
		
		var marker = new google.maps.Marker({
			position : new google.maps.LatLng(46.397, 23.644),
			map : map
		});
	}	
</script>
<title>Contact</title>
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
						<li><a href="gallery">Gallery</a></li>
						<li class="active"><a href="contact">Contact</a></li>
						<li><a href="logout">Logout</a></li>
					</ul>
				</form>
			</div>
		</div>
		</nav>
	</div>
	<div id="wrapper">
		<div id="contactGroup">
			<h1>Contact</h1>
			<h3>
				Name: <em>Hotel Tristar</em>
			</h3>
			<h3>
				Address: <em>Tristar Street 1</em>
			</h3>
			<h3>
				Phone: <em>08734823234</em>
			</h3>
			<br></br>

		</div>

		<h3 class="text-center">GoogleMaps location</h3>
		<div id="map-canvas" style="margin-left: 1%; height: 51%; width: 98%;"></div>
	</div>
</body>
</html>