<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Feedback</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
    crossorigin="anonymous">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h1 class="mt-5">Edit Feedback</h1>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/feedback/save" method="post">
            <input type="hidden" name="feedbackId" value="${feedback.feedbackId}">
            <input type="hidden" name="product_id" value="${feedback.productData.product_id}">
            <form:hidden path="feedback.user_id" value="${feedback.user_id}" />
            
            <div class="col-md-6">
                        <label for="productId" class="form-label">Product Name</label>
                        
                        <input type="text" class="form-control" id="productName" name="productName" readonly="readonly" value="${feedback.productData.getName()}">
                    </div>
            <div class="form-group">
                <label for="rating">Rating</label>
                <input type="number" class="form-control" id="feedbackScore" name="feedbackScore" value="${feedback.feedbackScore}" required>
            </div>
            <div class="form-group">
                <label for="comment">Description</label>
                <textarea class="form-control" id="description" name="description" rows="3" required>${feedback.description}</textarea>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Update Feedback</button>
        </form>
    </div>
</body>
</html>
