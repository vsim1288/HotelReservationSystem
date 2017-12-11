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
	href="<c:url value="/resources/stylesheets/registerStyle.css" />" />
<title>Register</title>
</head>
<body>
	<div class="container" id="registerDiv">
		<div id="headerMenu">
			<form id="goBackForm" method="get" action="login">
				<input type="submit" id="goBackBtn" class="btn btn-default"
					value="Go back" />
			</form>
		</div>
		<div class="row">
			<div id="welcomeTitle" class="text-center">
				<h1>Welcome to Hotel Tristar</h1>
			</div>
			<div id="registrationTitle" class="text-center">
				<h1>Registration Form</h1>
			</div>
		</div>
		<br></br>

		<div class="text-center" id="registrationFormDiv">

			<form id="regFormId" class="form-horizontal">
				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="firstName">*First
						Name:</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="firstName"
							placeholer="Enter first name" />
					</div>
				</div>


				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="lastName">*Last
						Name:</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="lastName"
							placeholer="Enter first name" />
					</div>
				</div>

				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="address">Address:</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="address"
							placeholer="Enter address" />
					</div>
				</div>

				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="phone">*Phone:</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="phone"
							placeholer="Enter phone number" />

					</div>
				</div>
				<br></br> <em>E-mail and password will be used for
					authentification</em> <br></br>

				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="email">*E-mail:</label>
					<div class="col-sm-2">
						<input type="e-mail" class="form-control" id="email"
							placeholer="Enter e-mail" />
					</div>
				</div>
				<em>Password must contain:</em> <br></br> <em> - at least one
					digit</em> <br></br> <em> - at least a lower case letter</em> <br></br>
				<em> - at least an upper case letter</em> <br></br> <em> - at
					least a special character: @#$%^&amp;+=</em> <br></br> <em> ! no
					whitespace allowed !</em> <br></br>
				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="password">*Password:</label>
					<div class="col-sm-2">
						<input type="password" class="form-control" id="password"
							placeholer="Enter password" />
					</div>
				</div>
				<br></br> <input type="button" class="btn btn-default"
					value="Register" /> <br></br>

				<h5>*required fields</h5>
			</form>
		</div>
	</div>
</body>
</html>