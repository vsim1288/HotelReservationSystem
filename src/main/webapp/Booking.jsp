<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!-- JSTL import -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    	<script src="http://code.angularjs.org/1.2.15/angular.js"></script>
    	<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
    	<script src="app.js"></script>
    	<script src="pages.js"></script>
    	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'/>
    	<link rel='stylesheet' type='text/css' href="stylesheets/WelcomeStyle.css"/>
		<title>Welcome</title>
	</head>
	<body>
		<div class="container-fluid">
			<h3 id="userId">Welcome back, ${sessionScope.user}</h3>
		</div>
		<div class="container-fluid" id="welcomeDiv">			
			<header class="text-center" id="header">
				<h1>Hotel Tristar</h1>
			</header>
		</div>
		<div id="wrapper">
			<page-tabs></page-tabs>
		</div>
	</body>
</html>