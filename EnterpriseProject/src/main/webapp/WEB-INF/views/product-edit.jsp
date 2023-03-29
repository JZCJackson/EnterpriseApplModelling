<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
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
<h1 class="my-5 card-title">Update Product</h1>
<div class="card-body">
<form class="row g-3" action="${pageContext.request.contextPath}/products/update" method="POST">
			<form:hidden path="product.product_id" />
			<div class="col-md-6">
				<label for="email" class="form-label">Name</label> 
				<form:input path="product.name" class="form-control" />
			</div>
			<div class="col-md-6">
				<label for="description" class="form-label">Price</label> 
				<form:input path="product.price" class="form-control" />
			</div>
			<div class="col-md-6">
				<label for="description" class="form-label">Category</label>
				<form:input path="product.category_id" class="form-control" />
			</div>
			<div class="col-md-6">
				<label for="description" class="form-label">Supplier</label>
				<form:input path="product.supplier_id" class="form-control" />
			</div>
			<div class="col-md-12">
				<label for="description" class="form-label">Description</label>
				<form:textarea path="product.description" class="form-control" />
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