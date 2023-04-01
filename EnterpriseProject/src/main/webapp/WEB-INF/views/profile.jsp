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
            <p>ID: ${sessionScope.user.user_id}</p>
            <p>Name: ${sessionScope.user.name}</p>
            <p>LastName: ${sessionScope.user.lastName}</p>
            <p>Email: ${sessionScope.user.email}</p>
            <p>Phone: ${sessionScope.user.phone}</p>
            <p>BirthDate: ${sessionScope.user.birthDate}</p>
            <p>Role: ${sessionScope.user.role}</p>    
        </div>
        
        <a href="profile/edit/${sessionScope.user.user_id}" class="btn btn-primary">Edit Profile</a>
        <form action="${pageContext.request.contextPath}/profile/delete/${sessionScope.user.user_id}" method="post" onsubmit="return confirm('Are you sure you want to delete your profile? This action cannot be undone.');">
    	<button type="submit" class="btn btn-danger">Delete Profile</button>
</form>
        
    </div>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
