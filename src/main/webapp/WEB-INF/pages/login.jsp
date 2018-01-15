<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
<link rel="stylesheet" href="<c:url value='/resources/css/app.css' />" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script -->
<!-- 	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script> -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="#"> 
			<img src="<c:url value='/resources/img/proxibank.jpg' />" alt="logo" style="width: 120px;">
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

	<div id="mainWrapper">
		<div class="login-container">
			<div class="login-card">
				<div class="login-form">
					
					<form action="${loginUrl}" method="post" class="form-horizontal">
						<c:if test="${param.error != null}">
							<div class="alert alert-danger">
								<p>Invalide login ou mot de passe.</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">
								<p>Vous etes logout.</p>
							</div>
						</c:if>
						<div class="input-group input-sm">
							<input type="text" class="form-control"
								name="login" placeholder="Saisir login" required>
						</div>
						<div class="input-group input-sm">
							<input type="password"
								class="form-control" name="password"
								placeholder="Saisir Password" required>
						</div>

						<div class="form-actions">
							<input type="submit"
								class="btn btn-block btn-primary btn-default" value="Log in">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
