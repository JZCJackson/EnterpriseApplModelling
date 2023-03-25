<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Ticket</title>
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
		<h1>Book Ticket</h1>

		<div class="card me-3 mb-3">
			<div class="card-body">
				<p class="card-text">
					<b>Name: </b>${sessionScope.user.name}</p>
				<p class="card-text">
					<b>Email: </b>${sessionScope.user.email}</p>
				<p class="card-text">
					<b>Gender: </b>${sessionScope.user.gender}</p>
				<p class="card-text">
					<b>Airline: </b>${ticket.airline}</p>
				<p class="card-text">
					<b>Source: </b>${ticket.source}</p>
				<p class="card-text">
					<b>Destination: </b>${ticket.destination}</p>
				<p class="card-text">
					<b>Fare: </b>${ticket.fare}</p>
			</div>
		</div>

		<form class="row g-3"
			action="${pageContext.request.contextPath}/book-ticket" method="POST">

			<input type="hidden" name="user_id" value="${sessionScope.user.user_id}"> <input
				type="hidden" name="ticket_id" value="${ticket.ticket_id}">
			<div class="col-md-6">
				<label for="num_of_passangers" class="form-label">Number of
					passengers</label> <input type="number" class="form-control"
					id="num_of_passangers" name="num_of_passangers">
			</div>
			<div class="col-md-6">
				<label for="departure_date" class="form-label">Date of
					departure</label> <input type="date" class="form-control"
					id="departure_date" name="departure_date">
			</div>
			<div class="col-md-4">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</html>