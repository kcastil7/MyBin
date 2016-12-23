<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang='en'>
<head>
	<title>MyBin Home</title>
  	<meta charset="utf-8">
	<meta name="viewport" http-equiv="Content-Type" content="width=device-width,initial-scale=1" charset=ISO-8859-1>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- STYLESHEET -->
	<link rel="stylesheet" href=" <c:url value='/resources/mythemes/css/jquery-ui.css' />">
	<link rel="stylesheet" href="<c:url value='/resources/mythemes/css/home.css' />">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- SCRIPTS -->
		<script type="text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" ></script>
	<script type="text/javascript" src="<c:url value='/resources/scripts/jquery-3.1.1.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/scripts/jquery-ui.js' />"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	
	
	</head>
	
<body onload="onLoadUp()">
	<nav class='navbar navbar-default'>
		<div class="container-fluid">
			<div class='navbar-header'>
				<a class='navbar-brand' href='Home'>MyBin</a>
				<p class='navbar-text'>Signed in as ${sessionScope.username}</p>
	
				<a href='Login' type='button' id='logout-button'
					class='navbar-btn btn btn-default logout-button navbar-right'>Logout</a>
				

		</div>
	</nav>
<body>
<div class="row">
			<form action="ADD" method="post">
				<div class="form-group col-xs-3 col-md-3">
					<label for="itemnumber">Item # <font color="red">*</font>
					</label> <input type="text" class="form-control" name="itemnumber">
				</div>
				<div class="form-group col-xs-3 col-md-3">
					<label for="po">PO #<font color="red">*</font></label>
					<input type="text" class="form-control" name="po">
				</div>
				<div class="form-group col-xs-3 col-md-3">
					<label for="location">Location<font color="red">*</font></label>
					<input type="text" class="form-control" name="location">
				</div>
				<div class="form-group col-xs-3 col-md-3">
					<label for="qty">Quantity<font color="red">*</font></label>
					<input type="text" class="form-control" name="qty">
				</div>
									<div class="form-group col-xs-10 col-md-10"
						" style="color: #FF0000;">${errorMessage}</div>
					<div class="form-group col-xs-10 col-md-10">
						<input type="submit" value="ADD" />
					</div>
					</form>
				
</body>
</html>