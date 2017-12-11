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
	href='<c:url value="/resources/stylesheets/style.css" />' />
<title>Login</title>
</head>
<body style="background-color: lightblue;">
	<div id="indexMenu">
		<form id="indexForm" method="get" action="register">
			<input type="submit" id="registerBtn" class="btn btn-default"
				onclick="register" value="Register" />

			<div id="registerMsg">Hit the Register button if you don't have
				an account yet!</div>
		</form>


	</div>

	<div class="container" id="loginDiv">
		<div class="row">
			<div class="col-sm-offset-3 col-sm-10">
				<h1>Welcome to Hotel Tristar</h1>
			</div>
		</div>
		<br></br>

		<form id="loginForm" class="form-horizontal"
			action="<c:url value='/j_spring_security_check' />" method="post">
			<div class="form-group">
				<label class="control-label col-sm-5" for="username">Username:</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="username"
						id="username" placeholder="Enter username" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-5" for="password">Password:</label>
				<div class="col-sm-2">
					<input type="password" class="form-control" name="password"
						id="password" placeholder="Enter password" required="true" />
				</div>
			</div>
			<div class="form-group">
				<input type="submit"
					class="btn btn-default col-sm-offset-5 col-sm-1" value="Login"/>
			</div>
		</form>
	</div>
</body>
</html>