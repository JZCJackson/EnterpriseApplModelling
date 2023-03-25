<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Ticket</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<!-- Navbar -->
	<%@include file="navbar.jsp"%>

	<div class="container mt-3" style="width: 75%">
		<h1>Add Ticket</h1>
		<form class="row g-3" action="${pageContext.request.contextPath}/ticket" method="POST">
			<div class="col-md-12">
				<label for="source" class="form-label">Airline</label> <input
					type="text" class="form-control" id="airline" name="airline">
			</div>	
			<div class="col-md-12">
				<label for="source" class="form-label">Source</label> <input
					type="text" class="form-control" id="source" name="source">
			</div>			
			<div class="col-md-12">
				<label for="destination" class="form-label">Destination</label> <input
					type="text" class="form-control" id="destination" name="destination">
			</div>
			<div class="col-md-12">
				<label for="fare" class="form-label">Fare</label> <input
					type="text" class="form-control" id="fare" name="fare">
			</div>
			<div class="col-md-4">
				<button type="submit" class="btn btn-primary">Add Ticket</button>
			</div>
		</form>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</html>