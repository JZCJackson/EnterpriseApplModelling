<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tickets</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container">
		<h1 class="mt-3">Tickets</h1>
		<table class="table table-striped table-success">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Airline</th>
					<th scope="col">Source</th>
					<th scope="col">Destination</th>
					<th scope="col">Fare</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tickets}" var="t" varStatus="loop">
					<tr>
						<th scope="row">${loop.count}</th>
						<td>${t.airline}</td>
						<td>${t.source}</td>
						<td>${t.destination}</td>
						<td>$ ${t.fare}</td>
						<td><a href="book-ticket/${t.ticket_id}"
							class="btn btn-primary btn-sm">Book</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="btn btn-primary" href="add-ticket">Add Ticket</a>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>