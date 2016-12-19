<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang='en'>
<head>
	<title>MyBin Login</title>
  	<meta charset="utf-8">
	<meta name="viewport" http-equiv="Content-Type" content="width=device-width,initial-scale=1" charset=ISO-8859-1>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1 align=center>
				<small>MyBin</small>
			</h1>
			
		</div>
		<c:if test="${ not empty errorMessage}">
			<div class="alert alert-danger" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${ errorMessage }
			</div>
		</c:if>
			
		<div class="row">
			<div class="col-sm-offset-3 col-sm-6">
				<form class="form-signin" action="Login" method="post">
					<h2 class="form-signin-heading">Please Sign In</h2>
					<label for="username" class="sr-only">Username</label> 
						<input type="text" name="username" id="username" class="form-control" placeholder="Username" /> 
						
					<label for="password" class="sr-only">Password</label> 
					<input type="password" name="password" id="password" class="form-control" placeholder="Password" />

					<button class="btn btn-lg btn-primary btn-block" name="Login" value="Login" type="submit">Sign in</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
