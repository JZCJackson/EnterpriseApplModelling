<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    <!-- Navbar -->
    <%@include file="navbar.jsp"%>
    <div class="container">
        <div class="card mt-5">
            <h1 class="my-5 card-title">Add Feedback</h1>
            <div class="card-body">
                <form class="row g-3" action="${pageContext.request.contextPath}/feedback/save" method="POST">
                    <div class="col-md-6">
                        <label for="productId" class="form-label">Product ID</label>
                        <form:hidden path="command.product_id" value="${product.product_id}" />
                        <form:hidden path="command.user_id" value="${user.user_id}" />
                        
                        <input type="text" class="form-control" id="productName" name="productName" readonly="readonly" value="${product.getName()}">
                    </div>
                    <div class="col-md-2">
                        <label for="feedback_score" class="form-label">Feedback Score</label>
                        <input type="number" class="form-control" id="feedbackScore" name="feedbackScore" min="1" max="5">
                    </div>
                    <div class="col-md-12">
                        <label for="description" class="form-label">Description</label>
                        <textarea type="text" class="form-control" id="description" name="description"></textarea>
                    </div>
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-primary">Submit Feedback</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
