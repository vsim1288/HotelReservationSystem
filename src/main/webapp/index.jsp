<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    	<script src="http://code.angularjs.org/1.2.15/angular.js"></script>
    	<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
    	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'/>
    	<link rel='stylesheet' type='text/css' href="stylesheets/style.css"/>
    	<title>Hotel Tristar</title>
	</head>
	<body>
		<div class="container" id="loginDiv">
			<div class="row">
				<div class="col-sm-offset-3 col-sm-10">
					<h1>Welcome to Hotel Tristar</h1>
				</div>
			</div>
			<br>
			
			<form class="form-horizontal" method="POST" action="/login">
				<div class="form-group">
					<label class="control-label col-sm-5" for="username">Username:</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="username" id="username" placeholder="Enter username" required="required"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-5" for="password">Password:</label>
					<div class="col-sm-2">
						<input type="password" class="form-control" name="password" id="password" placeholder="Enter password" required="required"/>
					</div>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-default col-sm-offset-5 col-sm-1" value="Login"/>
					<input type="button" class="btn btn-default col-sm-1" value="Register"/>
				</div>
			</form>
		</div>
	</body>
</html>
