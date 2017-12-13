<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
<script src="<c:url value="/resources/js/registerValidation.js" />"
	type="text/javascript"></script>
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

			<form:form id="regFormId" class="form-horizontal" action="register"
				method="post" commandName="registerForm">
				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="firstName">*First
						Name:</label>
					<div class="col-sm-2">
						<form:input type="text" class="form-control" id="firstName"
							path="firstname" onkeyup="checkFirstNameLength()"
							onblur="checkFirstNameLength()" placeholder="Enter first name"
							required="true" />
						<em id="firstnameMessage"></em>
					</div>
				</div>


				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="lastName">*Last
						Name:</label>
					<div class="col-sm-2">
						<form:input type="text" class="form-control" id="lastName"
							path="lastname" onkeyup="checkLastNameLength()"
							onblur="checkLastNameLength()" placeholder="Enter first name"
							required="true" />
						<em id="lastnameMessage"></em>
					</div>
				</div>

				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="address">Address:</label>
					<div class="col-sm-2">
						<form:input type="text" class="form-control" id="address"
							path="address" placeholer="Enter address" />
					</div>
				</div>

				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="phone">*Phone:</label>
					<div class="col-sm-2">
						<form:input type="text" class="form-control" id="phone"
							path="phone" onkeyup="checkPhone()"
							onblur="checkPhone()" placeholer="Enter phone number" required="true" />
						<em id="phoneMessage"></em>
					</div>
				</div>
				<br></br>
				<em>E-mail and password will be used for authentification</em>
				<br></br>

				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="email">*E-mail:</label>
					<div class="col-sm-2">
						<form:input type="e-mail" class="form-control" id="email"
							path="username" placeholder="Enter e-mail" required="true" />
						<em id="emailMessage"></em>
					</div>
				</div>
				<em>Password can contain:</em>
				<br></br>
				<em> - numbers </em>
				<br>
				<em> - letters </em>
				<br>
				<em> - underscore </em>
				<br>
				<em> - must start with a letter </em>
				<br> - password length 7-14 characters
				<div class="form-group text-center">
					<label class="control-label col-sm-5" for="password">*Password:</label>
					<div class="col-sm-2">
						<form:input type="password" class="form-control" id="password"
							path="password" onkeyup="checkPassword()"
							onblur="checkPassword()" placeholder="Enter password" required="true" />
						<em id="passwordMessage"></em>
					</div>
				</div>
				<br></br>
				<input type="submit" class="btn btn-default" value="Register"
					onclick="return validate()" />
				<br></br>

				<h5>*required fields</h5>
			</form:form>
		</div>
	</div>
</body>
</html>