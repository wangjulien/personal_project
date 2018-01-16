<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
<title>Gestion de conseiller</title>
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
				<c:url var="gestionConseillerUrl" value="/gerantGestionConseiller" />
				<li class="nav-item"><a class="nav-link" href="${loginUrl}">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="${logoutUrl}">Logout</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${gestionConseillerUrl}">Gestion de conseiller</a></li>
			</ul>
		</nav>

		<c:if test="${not empty error}">
			<div class="alert alert-danger">
				<p>${error}</p>
			</div>
		</c:if>
		<h3>Les conseillers geres par vous :</h3>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Reference employee</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Adresse</th>
					<th></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${conseillerList}" var="conseiller">
					<tr>
						<td>${conseiller.refEmployee}</td>
						<td>${conseiller.nom}</td>
						<td>${conseiller.prenom}</td>
						<td>${conseiller.adresse.toString()}</td>
						<td><a href="UpdateConseillerServlet?id=${conseiller.id}"
							class="view-link">Detail</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pager">
			<li class="next"><a href="">Plus &rarr;</a></li>
		</ul>

	</div>

</body>
</html>