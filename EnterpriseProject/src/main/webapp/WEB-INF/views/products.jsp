<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
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
				<h1 class="mt-5">Products</h1>
				<c:if test="${sessionScope.user.role.equals('supplier')}">
					<a href="new">
						<button type="button" class="btn btn-success">New</button>

					</a>
				</c:if>
				<a href="/EnterpriseProject/feedback/list"><button type="button"
						class="btn btn-info">All Feedback</button></a>
			</div>
		</div>
		<table class="mt-5 table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Supplier</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
					<c:if test="${sessionScope.user.role.equals('supplier')}">
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
					</c:if>
					<th scope="col">Feedback</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<th scope="row">${product.product_id}</th>
						<td>${product.name}</td>
						<td>${product.category_data.name}</td>
						<td>${product.supplier_data.name}</td>
						<td>${product.description}</td>
						<td>${product.price}</td>
						<c:if test="${sessionScope.user.role.equals('supplier')}">
							<td><a href="edit/${product.product_id}"><button
										type="button" class="btn btn-primary">Edit</button></a></td>
							<td><a href="delete/${product.product_id}"><button
										type="button" class="btn btn-danger">Delete</button></a></td>
						</c:if>
						<td><a
							href="/EnterpriseProject/feedback/add/${product.product_id}"><button
									type="button" class="btn btn-info">Feedback</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
			</div>

			</tbody>
</body>
</html>