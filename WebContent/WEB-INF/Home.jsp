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
	<script type="text/javascript">
	</script>
		<style>
	.table.table-striped.table-bordered .minimal_cell {
    background: none;
    border-width: 0;
}
</style>
	</head>

	
<body onload="onLoadUp()">
	<nav class='navbar navbar-default'>
		<div class="container-fluid">
			<div class='navbar-header'>
				<a class='navbar-brand' href='Home'>MyBin</a>
				<p class='navbar-text'>Signed in as ${sessionScope.username}</p>
	
				<a href='Logout' type='button' id='logout-button'
					class='navbar-btn btn btn-default logout-button navbar-right'>Logout</a>
				

		</div>
	</nav>
	<div class="container">
		<form action="Search" method="post">
				<div class ="col-lg-offset-2 ">
					<input name="search" id="search" class="form-control" placeholder="Search Item Number or Location" /></div>
					<button class="navbar-btn btn btn-default" name="searchBtn" value="Search" type="submit">Search</button>
					<button class="navbar-btn btn btn-default" name="Reset" value="Reset" type="submit">Reset</button>
			</form>
	
	<table id = "MyBin" class="table table-striped table-bordered">
	<thead>
	<th>Item#</th>
	<th>PO</th>
	<th>Location</th>
	<th>Amount</th>
	<th>Inputed by</th>
	</thead>
	<a href='ADD' type='button' class="btn btn-primary" id='ADD-button'>ADD</a>
	<c:forEach items ="${locator}" var="entry">
	<tr>
	<td>${entry.getItemNumber()}</td>
	<td>${entry.getPO()}</td>
	<td>${entry.getLocation()}</td>
	<td>${entry.getAmount()}</td>
	<td>${entry.getUserName()}</td>
	<td class="minimal_cell">
		<a href='Edit?id=${entry.getID()}' type='button' class="btn btn-primary" id='Edit-button'>Edit</a>
		</td>
	<td class="minimal_cell">
	<a href='Delete?id=${entry.getID()}' type='button' class="btn btn-primary" id='Delete-button'>Delete</a>
	</td>
	</tr>

	
	
	</c:forEach>
	
	</table>
	</div>
	
	</body>
	</html>