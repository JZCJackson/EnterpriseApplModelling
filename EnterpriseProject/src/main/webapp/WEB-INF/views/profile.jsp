<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container">
		<h1 class="mt-3">Profile</h1>
		<div>
			<p>Name: ${sessionScope.user.name}</p>
			<p>Email: ${sessionScope.user.email}</p>
			<p>Gender: ${sessionScope.user.gender}</p>
		</div>

		<div>
			<h2>Reservations</h2>


			<c:forEach items="${reservations}" var="r" varStatus="loop">
				<div class="card me-3 mb-3">
					<div class="card-body">
						<div class="row">
							<div class="card-title">
								<h4 class="card-text col-md-4 text-secondary">
									${ticketMap[r.ticket_id].airline}</h4>
							</div>
							<p class="card-text">
								<b>Date of departure: </b>${r.departure_date}</p>
							<p class="card-text col-md-4">
								<b>Name: </b>${sessionScope.user.name}</p>
							<p class="card-text col-md-4">
								<b>Email: </b>${sessionScope.user.email}</p>
							<p class="card-text col-md-4">
								<b>Gender: </b>${sessionScope.user.gender}</p>
							<p class="card-text col-md-4">
								<b>Source: </b>${ticketMap[r.ticket_id].source}</p>
							<p class="card-text col-md-8">
								<b>Destination: </b>${ticketMap[r.ticket_id].destination}</p>
							<p class="card-text col-md-4">
								<b>Total Fare: </b>$ ${ticketMap[r.ticket_id].fare * r.num_of_passangers}
							</p>
							<p class="card-text col-md-4">
								<b>Number of passengers: </b>${r.num_of_passangers}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>


	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>