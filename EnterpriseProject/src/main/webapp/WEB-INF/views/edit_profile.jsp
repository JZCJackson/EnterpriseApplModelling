<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
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
        <h1 class="mt-3">Edit Profile</h1>
		<form action="${pageContext.request.contextPath}/profile/update" method="post">
            <input type="hidden" name="user_id" value="${user.user_id}"/>
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${user.name}" required>
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" value="${user.lastName}" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
            </div>
            <div class="mb-3">
				<label for="password" class="form-label">Password</label> 
				<input type="password" class="form-control" id="password" name="password" value="${user.password}" required>
			</div>
            <div class="mb-3">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}" required>
            </div>
            <div class="mb-3">
                <label for="birthDate" class="form-label">Birth Date</label>
                <input type="test" class="form-control" id="birthDate" name="birthDate" value="${user.birthDate}" required>
            </div>
            <div class="mb-3">
			    <label for="role" class="form-label">Role</label>
			    <select class="form-control" id="role" name="role" required>
			        <option value="user" ${user.role == 'user' ? 'selected' : ''}>User</option>
			        <option value="supplier" ${user.role == 'supplier' ? 'selected' : ''}>Supplier</option>
			    </select>
			</div>

            <button type="submit" class="btn btn-primary">Update Profile</button>
        </form>
    </div>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Lk1l9/5ueqiHDfqLxyibi5I7pATc5zU0z9c/9th92icOB/5PGVeGnxeGQnJkDxdf"
        crossorigin="anonymous"></script>
</body>
</html>
