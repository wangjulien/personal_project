<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Displayclient</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<body>
	Display Clients
	<div class="container">
		<table class="table table-striped">

			<c:forEach var="client" items="${cleclients}">
				
				<tr scope="row">
					<td>name</td>
					<td><div>
							<c:out value="${client.nom}" />
						</div></td>
				</tr>
				<tr scope="row">
					<td>firstname</td>
					<td><c:out value="${client.prenom}" /></td>
				</tr>
				
				<tr scope="row">
					<td scope="col">Rue</td>
					<td><c:out value="${client.adresse.rue}" /></td>

				</tr>
				<tr scope="row">
					<td scope="col">Code Postal</td>
					<td><c:out value="${client.adresse.codePostal}" /></td>

				</tr>
				<tr scope="row">
					<td>Ville</td>
					<td><c:out value="${client.adresse.ville}" /></td>
				</tr>
				
				<tr scope="row">
					<td></td>
					<td><c:out value="   " /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="<c:url value='/editClients' />" method='GET'>
		<input type='submit' value='retour'>
	</form>
</body>
</html>