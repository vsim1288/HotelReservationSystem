<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!-- JSTL import -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    	<script type='text/javascript' src='includes/angular.js'></script>
    	<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
    	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'/>
    	<link rel='stylesheet' type='text/css' href="stylesheets/WelcomeStyle.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome</title>
	</head>
	<body>
		<div class="container-fluid">
			<c:if test="${sessionScope.user == null}">
				<p>IS NULL</p>
			</c:if>
			<h3 id="userId">Welcome back, ${sessionScope.user}</h3>
		</div>
		<div class="container-fluid" id="welcomeDiv">			
			<header class="text-center" id="header">
				<h1>Hotel Tristar</h1>
			</header>
		</div>
		<div id="wrapper">
			<div id="navbarDiv">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">Tristar ***</a>
						</div>
						<ul class="nav navbar-nav col-sm-5">
							<li class="active"><a>Home</a></li>
							<li><a>Booking</a></li>
							<li><a>Gallery</a></li>
							<li><a>Contact</a></li>
						</ul>
					</div>
				</nav>
			</div>
			<div id="bodyDiv">
				<section>
					<div id="infoDiv">
						<div id="pricesDivLeft">
							<p>
							Berekfürdőn a strandfürdőtől 50 méterre kínálunk külön bejáratú, 
							zárt parkolóval ellátott, fürdőszobás apartmanokat. Faházainktól 
							a kempingen keresztül tényleg csak egy perc a strand, nem sétával 
							fog telni a nyaralása!
							</p>
							<br>
							<p>
							A 3 ágyas szobák ára 3 fő esetén 2300 Ft/fő/éj, ami a teljes szobára:
							6900 Ft/éj/szoba!
							</p>
							<br>
							<p>
							A 4 ágyas szobák ára 4 fő esetén 1975 Ft/fő/éj, ami a teljes szobára:
							7900 Ft/éj/szoba!
							</p>
							<br>
							<p>
							Nálunk a gépkocsibeállás díjmentes, így autóját is biztonságban tudhatja! Jöjjön el és próbálja ki!
							OTP SZÉP-kártyáját is használhatja!
							</p>
						</div>
						<div id="picturesDivRight">
							<h3>PICTURES</h3>
							<br>
							<img src="images/hotel-inside.jpg"/>
							<br>
							<img src="images/hotel-outside.jpg"/>
							<br>
						</div>
						<div id="footerDiv">
							Szállásfoglalás minden esetben telefonos egyeztetés útján történik, egyéb kérdés esetén a következő címen is állunk rendelkezésre: info@berekfurdoszallas.eu
						</div>
					</div>
				</section>
			</div>
		</div>
	</body>
</html>