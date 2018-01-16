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

		<h3>Conseiller information :</h3>
		<c:url var="editConseillerUrl" value="/gerantEditConseiller" />
		<form action="${editConseillerUrl}" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
			<table>
				<tr>
					<td>Reference Employee : <br>(Laissez vide si vous voulez
						generation auto)<br> <input type="text" name="ref"
						value="${conseiller.refEmployee}" />
					</td>
				</tr>
				<tr>
					<td>Prenom : <br> <input type="text" name="prenom"
						value="${conseiller.getPrenom()}" required />
					</td>
				</tr>
				<tr>
					<td>Nom : <br> <input type="text" name="nom"
						value="${conseiller.getNom()}" required />
					</td>
				</tr>
				<tr>
					<td>Rue : <br> <input type="text" name="rue"
						value="${conseiller.adresse.rue}" />
					</td>
				</tr>
				<tr>
					<td>Code Postal : <br> <input type="text"
						name="codepostal" value="${conseiller.adresse.codePostal}" />
					</td>
				</tr>
				<tr>
					<td>Ville : <br> <input type="text" name="ville"
						value="${conseiller.adresse.ville}" />
					</td>
				</tr>
				<tr>
					<td>Tel : <br> <input type="text" name="tel"
						value="${conseiller.adresse.tel}" />
					</td>
				</tr>
							
				<c:choose>
					<c:when test="${empty conseiller}">
						<tr>
							<td><input type="submit" value="Ajouter"
								class="btn btn-primary" /></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td><input type="submit" value="Mettre a jour"
								class="btn btn-primary" /></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</form>
	</div>

</body>
</html>