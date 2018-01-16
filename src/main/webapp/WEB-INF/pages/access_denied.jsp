<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<title>Bienvenu</title>
</head>
<body>

	<div class="container">

		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<a class="navbar-brand" href="#"> <img
				src="<c:url value='/resources/img/proxibank.jpg' />" alt="logo"
				style="width: 120px;">
			</a>

			<!-- Links -->
			<ul class="navbar-nav">
				<c:url var="loginUrl" value="/login" />
				<c:url var="logoutUrl" value="/logout" />
				<li class="nav-item"><a class="nav-link" href="${loginUrl}">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="${logoutUrl}">Logout</a>
				</li>
			</ul>
		</nav>
		<div class="generic-container">
			<div class="authbar">
				<span>Dear <strong>${user.nom} ${user.prenom}</strong>, You
					are not authorized to access this page.
				</span> <span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
			</div>
		</div>

	</div>
</body>
</html>