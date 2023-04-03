<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h1 class="mt-5">Feedback</h1>
			</div>
		</div>
		<table class="mt-5 table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">User</th>
					<th scope="col">Product</th>
					<th scope="col">Rating</th>
					<th scope="col">Comment</th>
					<th scope="col">Date</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="feedback" items="${feedbacks}">
					<tr>
						<th scope="row">${feedback.feedbackId}</th>
						<td>${feedback.userData.name}</td>
						<td>${feedback.productData.name}</td>
						<td>${feedback.feedbackScore}</td>
						<td>${feedback.description}</td>
						<td>${feedback.feedbackDate}</td>
						<c:if
							test="${sessionScope.user.user_id == feedback.userData.user_id}">
							<td><a href="edit/${feedback.feedbackId}"><button
										type="button" class="btn btn-primary">Edit</button></a></td>
							<td><a href="delete/${feedback.feedbackId}"><button
										type="button" class="btn btn-danger">Delete</button></a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
