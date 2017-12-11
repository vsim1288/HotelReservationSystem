<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<%@ include file="welcomeBackInclude.jsp" %>

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
						<%@ include file="logoutInclude.jsp" %>
					</ul>
				</form>
			</div>
		</div>
		</nav>
	</div>
	<div id="wrapper">
		<div id="bodyDiv">
			<div id="infoDiv">
				<div id="pricesDivLeft">
					<p>Hotel Tristar este la 50 de metri distanță de plajă,
						apartamente cu intrare privată și parcare privată.</p>
					<br></br>
					<p>Camerele cu 3 paturi sunt disponibile pentru 3 persoane 230
						RON / persoană / noapte, cu 2 paturi 180 RON / persoană / noapte
						și cu 1 pat 120 RON / persoană / noapte!</p>
					<br></br>
					<p>Toate camerele sunt dotate cu TV, baie proprie, balcon,
						frigider! Animalele de companie sunt binevenite!</p>
					<br></br>
					<p>Parcarea este gratuită, astfel încât mașina dvs. este în
						siguranță!</p>
				</div>

				<div id="picturesDivRight">
					<h3>PICTURES</h3>
					<br></br> <img class="hotel-img"
						src="<c:url value="/resources/images/hotel-inside.jpg"/>" /> <br></br>
					<img class="hotel-img"
						src="<c:url value="/resources/images/hotel-outside.jpg"/>" /> <br></br>
				</div>
				<div id="footerDiv">În toate cazurile rezervarea se face prin
					telefon sau prin pagina noastră web la Booking. Dacă aveți alte
					întrebări ne puteți contacta telefonic sau prim e-mail
					info@berekfurdoszallas.eu</div>
			</div>
		</div>
	</div>
</body>
</html>