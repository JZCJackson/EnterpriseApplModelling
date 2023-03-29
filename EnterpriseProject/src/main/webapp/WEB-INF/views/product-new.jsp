<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<!-- Navbar -->
	<%@include file="navbar.jsp"%>
<div class="container">
<div class="card mt-5">
<h1 class="my-5 card-title">New Product</h1>
<div class="card-body">
<form class="row g-3" action="${pageContext.request.contextPath}/products/save" method="POST">
			<div class="col-md-6">
				<label for="email" class="form-label">Name</label> <input
					type="text" class="form-control" id="name" name="name">
			</div>
			<div class="col-md-6">
				<label for="description" class="form-label">Price</label> <input
					type="number" class="form-control" id="price" name="price">
			</div>
			<div class="col-md-6">
				<label for="description" class="form-label">Category</label> <input
					type="text" class="form-control" id="category" name="category_id">
			</div>
			<div class="col-md-6">
				<label for="description" class="form-label">Supplier</label> <input
					type="text" class="form-control" id="supplier" name="supplier_id">
			</div>
			<div class="col-md-12">
				<label for="description" class="form-label">Description</label> <textarea
					type="text" class="form-control" id="description" name="description">
					</textarea>
			</div>
			<div class="col-md-4">
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</form>
		</div>
		</div>
</div>
</body>
</html>