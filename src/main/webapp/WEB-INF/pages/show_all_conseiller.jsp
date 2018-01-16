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

		<c:if test="${param.error != null}">
			<div class="alert alert-danger">
				<p>${param.error}</p>
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